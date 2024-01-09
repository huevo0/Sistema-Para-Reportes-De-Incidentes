package capas.reportesincidentes.logica;

import capas.reportesincidentes.persistencia.ControladoraPersistencia;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Controladora {

        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public List<Servicio> traerServicios() {
        return controlPersis.traerServicios();
    }

    public void guardarCliente(String razonSocial, String cuit, String telefono, String email, String servicio) {
        Cliente cliente = new Cliente();
        cliente.setRazonSocial(razonSocial);
        cliente.setCuit(cuit);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        
        List <Servicio> servIngresado = new ArrayList<>();
        
        List<Servicio>AllServicios = traerServicios();
        
        
        for (Servicio serv : AllServicios) {
            if(serv.getNombre().equalsIgnoreCase(servicio)){
                servIngresado.add(serv);
                    
            }
        }
        cliente.setServicios(servIngresado);
        
        controlPersis.guardarCliente(cliente); 
    }

    public void guardarServicio(String nombre, String descripcion) {
        Servicio  servicio = new Servicio();
        servicio.setNombre(nombre);
        servicio.setTipo(descripcion);
        
        controlPersis.guardarServicio(servicio);
    }

    public List<Cliente> traerClientes() {
        return controlPersis.traerClientes();
    }

    public void EliminarServicio(int idServicio) {
        controlPersis.eliminarServicio(idServicio);
    }

    public void eliminarCliente(int idCliente) {
        controlPersis.eliminarCliente(idCliente);
    }

    public Cliente traerUnCliente(int idCliente) {
        return controlPersis.traerUnCliente(idCliente);
    }

    public void agregarUnServicio(int idCliente, String servicio) {
        
        Cliente cliente = traerUnCliente(idCliente);
        List<Servicio> allServicios = traerServicios();
        
        List<Servicio> servCliente = cliente.getServicios();
        
        for (Servicio serv : allServicios){
            if(servicio.equalsIgnoreCase(serv.getNombre())){
                servCliente.add(serv);
            }
        }
        cliente.setServicios(servCliente);
        
        controlPersis.modificaUnServicio(cliente);
    }

    public void quitarUnServicio(int idCliente, String servicio) {
        Cliente cliente = traerUnCliente(idCliente);
        
        List<Servicio> servCliente = cliente.getServicios();
        Iterator<Servicio> iterador = servCliente.iterator();
                
        while(iterador.hasNext()){
            
            Servicio serv = iterador.next();
            if(serv.getNombre().equalsIgnoreCase(servicio)){
                 iterador.remove();
            } 
            
        }
        cliente.setServicios(servCliente);
        controlPersis.modificaUnServicio(cliente);
     }

    public Servicio traerUnServicio(int idServicio) {
        return controlPersis.traerUnServicio(idServicio);
    }

    public void editarServicio(int idServicio, String nombre, String descripcion) {
           Servicio servicio = traerUnServicio(idServicio);
           servicio.setNombre(nombre);
           servicio.setTipo(descripcion);
           
           controlPersis.editarUnServicio(servicio);
    }

    public void editarCliente(int idCliente, String razonSocial, String cuit, String telefono, String email) {
           Cliente cliente = traerUnCliente(idCliente);
           cliente.setRazonSocial(razonSocial);
           cliente.setCuit(cuit);
           cliente.setTelefono(telefono);
           cliente.setEmail(email);
           
           controlPersis.editarCliente(cliente);
    }

    public void crearTecnico(String nombre, String especialidad) {
           Tecnico tecnico = new Tecnico();
           tecnico.setNombre(nombre);
           
           List<Servicio>tecEspecialidad = new ArrayList<>();
           List<Servicio>ListaEspec = traerServicios();
           
           for (Servicio servicio : ListaEspec) {
               if(servicio.getNombre().equals(especialidad)){
                   tecEspecialidad.add(servicio);
               }            
            }
           tecnico.setEspecialidad(tecEspecialidad);
           
           controlPersis.crearTecnico(tecnico);
    }

    public List<Tecnico> traerTecnicos() {
        return controlPersis.traerTecnicos();
    }

    public void eliminarTecnico(int idTecnico) {
        controlPersis.eliminarTecnico(idTecnico);
    }

    public Tecnico traerUnTecnico(int idTecnico) {
        return controlPersis.traerUnTecnico(idTecnico);
    }

    public void editarTecnico(int idTecnico, String nombre) {
        Tecnico tecnico = traerUnTecnico(idTecnico);
        tecnico.setNombre(nombre);
        
        controlPersis.editarTecnico(tecnico);
    }

    public void agregarEspecialidadTecnico(int idTecnico, String especialidad) {
        Tecnico tecnico = traerUnTecnico(idTecnico);
        List<Servicio>tecnicoEsp = tecnico.getEspecialidad();
        List<Servicio>listaServicio = traerServicios();
        

        for (Servicio servicio : listaServicio) {
            if(servicio.getNombre().equalsIgnoreCase(especialidad)){
                tecnicoEsp.add(servicio);
            }
            
        }
        tecnico.setEspecialidad(tecnicoEsp);
        controlPersis.editarTecnico(tecnico);
    }

    public void QuitarEspecialidadTecnico(int idTecnico, String especialidad) {
        Tecnico tecnico = traerUnTecnico(idTecnico);
        
        List<Servicio> tecEsp = tecnico.getEspecialidad();
        Iterator<Servicio> iterador = tecEsp.iterator();
                
        while(iterador.hasNext()){
            
            Servicio espec = iterador.next();
            if(espec.getNombre().equalsIgnoreCase(especialidad)){
                 iterador.remove();
            } 
            
        }
        tecnico.setEspecialidad(tecEsp);
        controlPersis.editarTecnico(tecnico);
    }

    public List<Incidente> traerIncidentes() {
        return controlPersis.traerIncidente();
    }

    public void eliminarIncidente(int idIncidente) {
        controlPersis.eliminarIncidente(idIncidente);
    }

    public void crearIncidente(String cliente, String cuit, int idServicio, int idTecnico, String descripcion, String dificultad, 
                               String tipoProblema, String estado, String fechaAlta, String fechaReso, String colchonHoras) {
    
        Incidente incidente = new Incidente();
        List<Cliente>listaClientes = controlPersis.traerClientes();
                    
        for (Cliente unCliente : listaClientes) {
            if(cliente.equalsIgnoreCase(unCliente.getRazonSocial())){
                incidente.setCliente(unCliente);
            }
        }
        incidente.setServicio(controlPersis.traerUnServicio(idServicio));
        incidente.setTecnico(controlPersis.traerUnTecnico(idTecnico));
        incidente.setDescripcion(descripcion);
        incidente.setDificultad(dificultad);
        incidente.setTipoProblema(tipoProblema);
        incidente.setEstado(estado);
        incidente.setFechaAlta(fechaAlta);
        incidente.setFechaResolucion(fechaReso);
        incidente.setColchonHoras(colchonHoras);
        
        controlPersis.crearIncidente(incidente);
    }

    public Incidente traerUnIncidente(int idIncidente) {
        return controlPersis.traerUnIncidente(idIncidente);
    }

    public void editarIncidente(int idIncidente, int idCliente, int idServicio, int idTecnico, String descripcion, String dificultad, String tipoProblema, String estado, String fechaAlta, String fechaReso, String colchonHoras) {
        Incidente incidente = controlPersis.traerUnIncidente(idIncidente);
        
                    
        incidente.setCliente(controlPersis.traerUnCliente(idCliente));
        incidente.setServicio(controlPersis.traerUnServicio(idServicio));
        incidente.setTecnico(controlPersis.traerUnTecnico(idTecnico));
        incidente.setDescripcion(descripcion);
        incidente.setDificultad(dificultad);
        incidente.setTipoProblema(tipoProblema);
        incidente.setEstado(estado);
        incidente.setFechaAlta(fechaAlta);
        incidente.setFechaResolucion(fechaReso);
        incidente.setColchonHoras(colchonHoras);
        
        controlPersis.editarIncidente(incidente);
    }

    public void estadoResuelto(int idIncidente) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        Incidente incidente = traerUnIncidente(idIncidente);
        incidente.setEstado("Resuelto");
        String fechaRes = LocalDateTime.now().format(formatoFecha);
        incidente.setFechaResolucion(fechaRes);
        controlPersis.editarIncidente(incidente);
        
    }

    public void estadoPendiente(int idIncidente) {
        Incidente incidente = traerUnIncidente(idIncidente);
        incidente.setEstado("Pendiente");
        controlPersis.editarIncidente(incidente);    
    }

    public String primerInforme(int dias) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        
        String hoy = LocalDateTime.now().format(formatoFecha);
        LocalDateTime fechaLimite = LocalDateTime.parse(hoy, formatoFecha).minusDays(dias);
        
        List<Incidente>listaincidentes = traerIncidentes();
        List<Tecnico> listaTecnicos = traerTecnicos();
        List<Tecnico> mejoresTecnicos = new ArrayList<>();
        
        int cuentaAux = 0;
        
        for (Tecnico unTecnico : listaTecnicos) {
            int incidentePorTecnico = 0;
            for (Incidente unincidente : listaincidentes) {
                LocalDateTime fechaRes = LocalDateTime.parse(unincidente.getFechaResolucion(),formatoFecha);
                
                if(fechaRes.isAfter(fechaLimite) && unincidente.getEstado().equalsIgnoreCase("Resuelto") && unTecnico.getId()==unincidente.getTecnico().getId()){
                    incidentePorTecnico++;
                }
            }
            if(incidentePorTecnico>=cuentaAux){
                cuentaAux = incidentePorTecnico;
                mejoresTecnicos.add(unTecnico);
            }
            
                   
        }
        String informe="";
        for (Tecnico unTecnico : mejoresTecnicos) {
            informe += unTecnico.getNombre().concat(" con " + cuentaAux + " incidentes Resueltos \n");
        }
        if(informe!=""){
            return informe;
        }
        else { return "no hay resultado";}
    }

    public String segundoInforme(int dias, String especialidad) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        
        String hoy = LocalDateTime.now().format(formatoFecha);
        LocalDateTime fechaLimite = LocalDateTime.parse(hoy, formatoFecha).minusDays(dias);
        
        List<Incidente>listaincidentes = traerIncidentes();
        List<Tecnico> listaTecnicos = traerTecnicos();
        List<Tecnico> mejoresTecnicos = new ArrayList<>();
        List<Tecnico> tecnicoPorEspecialidad = new ArrayList<>();
        for (Tecnico unTecnico : listaTecnicos) {
            List<Servicio>espTec = unTecnico.getEspecialidad();
            for (Servicio esp : espTec) {
                if(especialidad.equalsIgnoreCase(esp.getNombre())){
                    tecnicoPorEspecialidad.add(unTecnico);
                }
            }
        }
        
        int cuentaAux = 0;
        
        for (Tecnico unTecnico : tecnicoPorEspecialidad) {
            int incidentePorTecnico = 0;
            
            for (Incidente unincidente : listaincidentes) {
                LocalDateTime fechaRes = LocalDateTime.parse(unincidente.getFechaResolucion(),formatoFecha);
                
                if(fechaRes.isAfter(fechaLimite) && unincidente.getEstado().equalsIgnoreCase("Resuelto") && unTecnico.getId()==unincidente.getTecnico().getId()){
                    incidentePorTecnico++;
                }
            }
            if(incidentePorTecnico>=cuentaAux){
                cuentaAux = incidentePorTecnico;
                mejoresTecnicos.add(unTecnico);
            }
            
                   
        }
        String informe="";
        for (Tecnico unTecnico : mejoresTecnicos) {
            informe += unTecnico.getNombre().concat(" con " + cuentaAux + " incidentes Resueltos \n");
        }
        if(cuentaAux!=0){
            return informe;
        }
        else { String mensaje = "No se encontraron incidentes resueltos en los ultimos ";
                return mensaje.concat(String.valueOf(dias) + " días");
        }
    }

    public String tercerInforme() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        
      
        
        List<Tecnico> listaTecnicos = traerTecnicos();
        Tecnico mejorTecnico = null;
        
               
        long cuentaAux = Long.MAX_VALUE;
        
        
        for (Tecnico unTecnico : listaTecnicos) {
            List<Incidente>listaincidentes = unTecnico.getIncidentes();
            long incidentePorTecnico = Long.MAX_VALUE;
            if(!unTecnico.getIncidentes().isEmpty()){
                for (Incidente unincidente : listaincidentes) {
                    LocalDateTime fechaRes = LocalDateTime.parse(unincidente.getFechaResolucion(),formatoFecha);
                    LocalDateTime fechaAlta = LocalDateTime.parse(unincidente.getFechaAlta(),formatoFecha);
                    Duration resultado = (Duration.between(fechaAlta, fechaRes));

                    if(resultado.toSeconds() < incidentePorTecnico){
                        incidentePorTecnico = resultado.toSeconds();
                    }
                    System.out.println(unTecnico.getNombre() + " " + incidentePorTecnico);

                }

                if (cuentaAux > incidentePorTecnico ){
                    cuentaAux = incidentePorTecnico;
                    mejorTecnico = unTecnico;

                }
            }
            
            
        }
        
        String informe="";
        System.out.println("Tecnico mas rapido es:  " + mejorTecnico.getNombre());
        
        informe += mejorTecnico.getNombre().concat(" resolvió mas rapido un incidente. \n");
        
            
        
        if(cuentaAux!=0){
        return informe;
        }
        else { String mensaje = "No se encontraron incidentes resueltos en los ultimos ";
        return mensaje.concat("");
        }
        
    }
        
     
    

}

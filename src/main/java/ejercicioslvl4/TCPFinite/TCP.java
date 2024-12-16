package ejercicioslvl4.TCPFinite;

import java.util.Arrays;
import java.util.function.Predicate;

public class TCP {


    public static String traverseStates(String[] events) {


        String[] estadosPosibles = {"APP_PASSIVE_OPEN", "APP_ACTIVE_OPEN", "APP_SEND", "APP_CLOSE", "APP_TIMEOUT",
                "RCV_SYN", "RCV_ACK", "RCV_SYN_ACK", "RCV_FIN", "RCV_FIN_ACK"};

        int numeroEventos = events.length;
        String estado = "CLOSED";
        String[]salida;
        for (int i = 0; i < numeroEventos; i++) {
            salida = tratarEstado(events[i], estadosPosibles, estado);
            if (salida[1].equals("ERROR")){
                return "ERROR";
            }else {
                estado = salida[1];
            }

        }


        return estado;
    }

    public static String[] tratarEstado(String evento, String[]estadosPosibles, String estado) {
       String[] resultadoERROR = {"ERROR", "ERROR"};
        if (Arrays.stream(estadosPosibles).anyMatch(Predicate.isEqual(evento))){

            if (evento.equals("APP_PASSIVE_OPEN")) {
                if (estado.equals("CLOSED")) {
                    String[] resultadoACIERTO = {"ACIERTO", "LISTEN"};
                    return resultadoACIERTO;
                    
                }else{
                    
                    return resultadoERROR;
                }
            }else if (evento.equals("APP_ACTIVE_OPEN")) {
                if (estado.equals("CLOSED")) {
                    String[] resultadoACIERTO = {"ACIERTO", "SYN_SENT"};
                    return resultadoACIERTO;
                    
                }else{
                    
                    return resultadoERROR;
                }     
            }else if (evento.equals("RCV_SYN")) {
                if (estado.equals("LISTEN")) {
                    String[] resultadoACIERTO = {"ACIERTO", "SYN_RCVD"};
                    return resultadoACIERTO;
                    
                }else if (estado.equals("SYN_SENT")) {
                    String[] resultadoACIERTO = {"ACIERTO", "SYN_RCVD"};
                    return resultadoACIERTO;
                } else{
                    
                    return resultadoERROR;
                }     
            }else if (evento.equals("APP_SEND")) {
                if (estado.equals("LISTEN")) {
                    String[] resultadoACIERTO = {"ACIERTO", "SYN_SENT"};
                    return resultadoACIERTO;
                    
                }else{
                    
                    return resultadoERROR;
                }     
            }else if (evento.equals("APP_CLOSE")) {
                if (estado.equals("LISTEN")) {
                    String[] resultadoACIERTO = {"ACIERTO", "CLOSED"};
                    return resultadoACIERTO;
                    
                }else if (estado.equals("SYN_RCVD")) {
                    String[] resultadoACIERTO = {"ACIERTO", "FIN_WAIT_1"};
                    return resultadoACIERTO;
                }else if (estado.equals("SYN_SENT")) {
                    String[] resultadoACIERTO = {"ACIERTO", "CLOSED"};
                    return resultadoACIERTO;
                }else if (estado.equals("ESTABLISHED")) {
                    String[] resultadoACIERTO = {"ACIERTO", "FIN_WAIT_1"};
                    return resultadoACIERTO;
                    
                }else if (estado.equals("CLOSE_WAIT")) {
                    String[] resultadoACIERTO = {"ACIERTO", "LAST_ACK"};
                    return resultadoACIERTO;
                    
                }else{
                    
                    return resultadoERROR;
                }     
            }else if (evento.equals("RCV_ACK")) {
                if (estado.equals("SYN_RCVD")) {
                    String[] resultadoACIERTO = {"ACIERTO", "ESTABLISHED"};
                    return resultadoACIERTO;
                    
                }else if (estado.equals("FIN_WAIT_1")) {
                    String[] resultadoACIERTO = {"ACIERTO", "FIN_WAIT_2"};
                    return resultadoACIERTO;
                }else if (estado.equals("CLOSING")) {
                    String[] resultadoACIERTO = {"ACIERTO", "TIME_WAIT"};
                    return resultadoACIERTO;
                }else if (estado.equals("LAST_ACK")) {
                    String[] resultadoACIERTO = {"ACIERTO", "CLOSED"};
                    return resultadoACIERTO;
                } else{
                    
                    return resultadoERROR;
                }     
            }else if (evento.equals("RCV_SYN_ACK")) {
                if (estado.equals("SYN_SENT")) {
                    String[] resultadoACIERTO = {"ACIERTO", "ESTABLISHED"};
                    return resultadoACIERTO;
                    
                }else{
                    
                    return resultadoERROR;
                }     
            }else if (evento.equals("RCV_FIN")) {
                if (estado.equals("ESTABLISHED")) {
                    String[] resultadoACIERTO = {"ACIERTO", "CLOSE_WAIT"};
                    return resultadoACIERTO;
                    
                }else if (estado.equals("FIN_WAIT_1")) {
                    
                     String[] resultadoACIERTO = {"ACIERTO", "CLOSING"};
                    return resultadoACIERTO;       
                }else if (estado.equals("FIN_WAIT_2")) {
                    
                     String[] resultadoACIERTO = {"ACIERTO", "TIME_WAIT"};
                    return resultadoACIERTO;       
                } else{
                    
                    return resultadoERROR;
                }     
            }else if (evento.equals("RCV_FIN_ACK")) {
                if (estado.equals("FIN_WAIT_1")) {
                    String[] resultadoACIERTO = {"ACIERTO", "TIME_WAIT"};
                    return resultadoACIERTO;
                    
                }else{
                    
                    return resultadoERROR;
                }     
            }else if (evento.equals("APP_TIMEOUT")) {
                if (estado.equals("TIME_WAIT")) {
                    String[] resultadoACIERTO = {"ACIERTO", "CLOSED"};
                    return resultadoACIERTO;
                    
                }else{
                    
                    return resultadoERROR;
                }     
            }

            return resultadoERROR;
        }else {
            
            return resultadoERROR;
        }

    }

}
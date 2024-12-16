package ejercicioslvl4.TCPFinite;

import java.util.Arrays;
import java.util.function.Predicate;

public class TCP {


    public static String traverseStates(String[] events) {

     /* CLOSED: APP_PASSIVE_OPEN -> LISTEN
        CLOSED: APP_ACTIVE_OPEN  -> SYN_SENT
        LISTEN: RCV_SYN          -> SYN_RCVD
        LISTEN: APP_SEND         -> SYN_SENT
        LISTEN: APP_CLOSE        -> CLOSED
        SYN_RCVD: APP_CLOSE      -> FIN_WAIT_1
        SYN_RCVD: RCV_ACK        -> ESTABLISHED
        SYN_SENT: RCV_SYN        -> SYN_RCVD
        SYN_SENT: RCV_SYN_ACK    -> ESTABLISHED
        SYN_SENT: APP_CLOSE      -> CLOSED
        ESTABLISHED: APP_CLOSE   -> FIN_WAIT_1
        ESTABLISHED: RCV_FIN     -> CLOSE_WAIT
        FIN_WAIT_1: RCV_FIN      -> CLOSING
        FIN_WAIT_1: RCV_FIN_ACK  -> TIME_WAIT
        FIN_WAIT_1: RCV_ACK      -> FIN_WAIT_2
        CLOSING: RCV_ACK         -> TIME_WAIT
        FIN_WAIT_2: RCV_FIN      -> TIME_WAIT
        TIME_WAIT: APP_TIMEOUT   -> CLOSED
        CLOSE_WAIT: APP_CLOSE    -> LAST_ACK
        LAST_ACK: RCV_ACK        -> CLOSED

     */


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
                    
                }else{
                    
                    return resultadoERROR;
                }
            }
            
 


           
            return resultadoERROR;
        }else {
            
            return resultadoERROR;
        }

    }

    public static void main(String[] args) {

        String[]casos = {"APP_PASSIVE_OPEN", "RCV_SYN","RCV_ACK"};
        System.out.println(traverseStates(casos));

    }
}
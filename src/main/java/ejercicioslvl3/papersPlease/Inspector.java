/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioslvl3.papersPlease;

/**
 *
 * @author tarde
 */
import com.sun.jdi.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Inspector {

    //BOLETIN GENERAL
    private ArrayList<String> paisesPermitidos = new ArrayList<>();
    private ArrayList<String> paisesProhibidos = new ArrayList<>();
    private ArrayList<String> buscados = new ArrayList<>();
    private ArrayList<String> documentosPedidos = new ArrayList<>();

    //CADUCIDAD
    String dateStr = "1982.11.23";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    LocalDate caducidad = LocalDate.parse(dateStr, formatter);
    //RESPUESTA
    Respuesta respuesta = new Respuesta();

    //PAISES
    ArrayList<String> todosPaises = new ArrayList<>();


    public void receiveBulletin(String bulletin) {
        String leyes[] = bulletin.split("\\\n");
        for (int i = 0; i < leyes.length; i++) {
            if (leyes[i].startsWith("Allow citizens of")) {

                String paises = leyes[i].substring(18);


                String[] pais = paises.split(", ");


                Arrays.stream(pais).forEach(s -> {
                    String paisTrimmed = s.trim(); // Elimina espacios adicionales

                    // Verifica si el país está en la lista de prohibidos
                    if (getPaisesProhibidos().contains(paisTrimmed)) {
                        // Eliminar de la lista de prohibidos
                        getPaisesProhibidos().remove(paisTrimmed);

                    }

                    // Agregar a la lista de permitidos
                    getPaisesPermitidos().add(paisTrimmed);

                });
            }

             else if (leyes[i].startsWith("Deny citizens of")) {
                String[] pais;
                String paises = leyes[i].substring(17);
                pais = paises.split(", ");
                Arrays.stream(pais).forEach(s -> {
                    String paisTrimmed = s.trim(); // Elimina espacios adicionales

                    // Verifica si el país está en la lista de prohibidos
                    if (getPaisesPermitidos().contains(paisTrimmed)) {
                        // Eliminar de la lista de prohibidos
                        getPaisesPermitidos().remove(paisTrimmed);

                    }

                    // Agregar a la lista de permitidos
                    getPaisesProhibidos().add(paisTrimmed);

                });
            } else if (leyes[i].startsWith("Foreigners") || leyes[i].startsWith("Citizens") || leyes[i].startsWith("Workers") || leyes[i].startsWith("Entrants")) {
                documentacionNecesaria(leyes[i]);

            } else if (leyes[i].startsWith("Wanted")) {
                String criminal = leyes[i].substring(21);
                ArrayList<String> buscado = new ArrayList<>();
                buscado.add(criminal);
                this.setBuscados(buscado);

            }
        }
        //System.out.println(this.getBuscados());
        //System.out.println(this.getDocumentosPedidos());
        //System.out.println(this.getPaisesPermitidos());

        ArrayList<String> paisesProhiNuevo = new ArrayList<>();
        for (String paisNi:paisesProhibidos) {
            if (!paisesPermitidos.contains(paisNi)){
                paisesProhiNuevo.add(paisNi);
            }
        }
        //this.paisesProhibidos = paisesProhiNuevo;
        //System.out.println(paisesProhibidos);
    }

    private void documentacionNecesaria(String ley) {
        if (ley.startsWith("Citizens of")) {

            String[] paises;

            String textoPais = ley.substring(12);
            if (textoPais.contains(",")) {
                paises = textoPais.split(", ");
                String[] texto = paises[paises.length - 1].split(" ");
                String pais = texto[0];
                String pedido = texto[2] +"_"+ texto[3];

                for (int i = 0; i < paises.length; i++) {
                    if (i == paises.length - 1) {
                        this.getDocumentosPedidos().add(pais + ":" + pedido);

                    } else {
                        this.getDocumentosPedidos().add(paises[i] + ":" + pedido);

                    }

                }

            } else {
                paises = textoPais.split(" ");
                if (textoPais.contains("require")) {

                    this.getDocumentosPedidos().add(paises[0] + ":" + paises[2] +"_" + paises[3]);
                }
            }

        } else if (ley.startsWith("Foreigners")) {
            String[] required = ley.split(" ");
            if (required.length < 4) {
                this.getDocumentosPedidos().add("Foreigners:" + required[2]);
            } else {
                if (ley.contains("no longer require")) {
                    //Quitar requerimiento

                } else if (ley.contains(" require ")) {
                    this.getDocumentosPedidos().add("Foreigners:" + required[2] +"_" + required[3]);
                }

            }

        } else if (ley.startsWith("Workers")) {
            String[] required = ley.split(" ");
            if (required.length < 4) {
                this.getDocumentosPedidos().add("Workers:" + required[2]);
            } else {
                if (ley.contains("no longer require")) {
                    //Quitar requerimiento

                } else if (ley.contains(" require ")) {
                    this.getDocumentosPedidos().add("Workers:" + required[2] +"_" + required[3]);
                }

            }

        } else if (ley.startsWith("Entrants")) {
            String[] required = ley.split(" ");
            if (required.length < 4) {
                this.getDocumentosPedidos().add("Entrants:" + required[2]);
            } else {
                if (ley.contains("no longer require")) {
                    //Quitar requerimiento

                } else if (ley.contains(" require ")) {
                    this.getDocumentosPedidos().add("Entrants:" + required[2] +"_" + required[3]);
                }

            }

        }

    }

    public String inspect(Map<String, String> person) {
        ArrayList<String> documentosUsuario = new ArrayList<>();
        llenarPaises();
        Persona verificado = new Persona();
        String respuestaFinal = "";
        for (Map.Entry<String, String> entry : person.entrySet()) {
            documentosUsuario.add(entry.getKey());
            if (entry.getKey().equals("passport")) {
                respuestaFinal = verificarDocumento(entry.getValue(), verificado);

            } else if (entry.getKey().equals("certificate_of_vaccination")) {
                respuestaFinal = verificarDocumento(entry.getValue(), verificado);

            } else if (entry.getKey().equals("ID_card")) {

                respuestaFinal = verificarDocumento(entry.getValue(), verificado);
            } else if (entry.getKey().equals("access_permit")) {

                respuestaFinal = verificarDocumento(entry.getValue(), verificado);
            } else if (entry.getKey().equals("work_pass")) {
                respuestaFinal = verificarDocumento(entry.getValue(), verificado);

            } else if (entry.getKey().equals("grant_of_asylum")) {

                respuestaFinal = verificarDocumento(entry.getValue(), verificado);
            } else if (entry.getKey().equals("diplomatic_authorization")) {
                respuestaFinal = verificarDocumento(entry.getValue(), verificado);

            }
            verificado.documentosUsuario.add(entry.getKey());

        }

        verificado.documentosNecesarios = verDocumentosNecesarios(verificado.nacion, verificado.esTrabajador);

        //System.out.println(documentosUsuario);
        if (respuestaFinal.equals("Pass")){
         if (verificado.nacion.equals("Arstotzka")){
             respuestaFinal = respuesta.entradaGloriosa;
         }else {
             respuestaFinal = respuesta.entrada;
         }

        }
        //System.out.println(verificado.documentosUsuario);
        //System.out.println(verificado.documentosNecesarios);
        if (comparador(verificado.documentosUsuario, verificado.documentosNecesarios).startsWith("Entry denied")){
            respuestaFinal = comparador(verificado.documentosUsuario, verificado.documentosNecesarios);

        }

        if (verificado.nacion.equals("Arstotzka") && verificado.documentosUsuario.contains("ID_card")) {
            respuestaFinal = respuesta.entradaGloriosa;
        }

        String nombreApellido;
        String []completo = verificado.name.split(", ");
        nombreApellido = completo[1] + " " + completo[0];

        if (this.getBuscados().contains(nombreApellido)){
            return respuesta.detenerCriminal;
        }
        if (respuestaFinal.startsWith("Detainment:")){
            return  respuestaFinal;
        }

        for (String pais:paisesProhibidos) {

            if (verificado.nacion.equals(pais)){
                return "Entry denied: citizen of banned nation.";
            }
        }
        if (!paisesPermitidos.contains(verificado.nacion)){
            return "Entry denied: citizen of banned nation.";
        }

        return respuestaFinal;
    }

    private String comparador(ArrayList<String> documentosUsuario, ArrayList<String> documentosNecesarios) {
        int documentosComprobados = 0;
        int documentosTotales = documentosNecesarios.size();
        ArrayList<String> docuBuenos = new ArrayList<>();

        for (String nec:documentosNecesarios) {
            if (!documentosUsuario.contains(nec)){
                if (nec.length() > 1){
                    nec = nec.replace("_", " ");
                    System.out.println(nec);
                }
                return "Entry denied: missing required " + nec + ".";
            }else {
                documentosComprobados ++;
            }
        }

        return "Bien";
    }

    private ArrayList<String> verDocumentosNecesarios(String nacion, boolean esTrabajador) {
        ArrayList<String> documentos= new ArrayList<>();
        for (String pais:this.documentosPedidos) {
            
            if (pais.startsWith(nacion)){
                documentos.add(pais.substring(pais.indexOf(":")+1));
            }
            if (pais.startsWith("Entrants")){
                documentos.add(pais.substring(pais.indexOf(":")+1));
            }
            if (pais.startsWith("Foreigners") && !nacion.equals("Arstotzka")){
                documentos.add(pais.substring(pais.indexOf(":")+1));
            }
            if (pais.startsWith("Workers") && esTrabajador){
                documentos.add(pais.substring(pais.indexOf(":")+1));
            }

        }
        return documentos;
    }

    public ArrayList<String> getPaisesPermitidos() {
        return paisesPermitidos;
    }

    public void setPaisesPermitidos(ArrayList<String> paisesPermitidos) {
        this.paisesPermitidos = paisesPermitidos;
    }

    public ArrayList<String> getPaisesProhibidos() {
        return paisesProhibidos;
    }

    public void setPaisesProhibidos(ArrayList<String> paisesProhibidos) {
        this.paisesProhibidos = paisesProhibidos;
    }

    public ArrayList<String> getBuscados() {
        return buscados;
    }

    public void setBuscados(ArrayList<String> buscados) {
        this.buscados = buscados;
    }

    public ArrayList<String> getDocumentosPedidos() {
        return documentosPedidos;
    }

    public void setDocumentosPedidos(ArrayList<String> documentosPedidos) {
        this.documentosPedidos = documentosPedidos;
    }
    public void llenarPaises() {
        // Agregar países al ArrayList
        todosPaises.add("Arstotzka");
        todosPaises.add("Antegria");
        todosPaises.add("Impor");
        todosPaises.add("Kolechia");
        todosPaises.add("Obristan");
        todosPaises.add("Republia");
        todosPaises.add("United Federation");
    }

    public String verificarDocumento(String value, Persona verificado) {
        
        if (value.contains("ID#:")) {
            if (verificado.id == null) {
                verificado.id = value.substring(value.indexOf("ID#:") + 5, value.indexOf("ID#:") + 16);
            }else{
                //System.out.println(value.substring(value.indexOf("ID#:") + 5, value.indexOf("ID#:") + 16));
                if (!(value.substring(value.indexOf("ID#:") + 5, value.indexOf("ID#:") + 16).equals(verificado.id))) {
                    return respuesta.detenerID;
                }
            }
        }
        if (value.contains("NATION:")){
            if (verificado.nacion == null){
                for (String pais: todosPaises) {
                    if (value.contains(pais)){
                        verificado.nacion = pais;
                    }
                }

            }else {
                for (String pais: todosPaises) {
                    if (value.contains(pais)){
                        if (!pais.equals(verificado.nacion)){
                            return respuesta.detenerID;
                        }
                    }
                }
            }


        }
        if (value.contains("NAME:")){
            String datosNombre = value.substring(value.indexOf("NAME:") + 6);
            String [] parteNombre = datosNombre.split("\\\n");
            String nombre = parteNombre[0];
            if (verificado.name == null){
                verificado.name = nombre;
            }else {
                if (!verificado.name.equals(nombre)){
                    return respuesta.detenerID;
                }
            }
        }

        if (value.contains("EXP:")){

            String fecha = value.substring(value.indexOf("EXP:") + 5, value.indexOf("EXP:") + 15);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate fechaC = LocalDate.parse(fecha, formatter);
            if (this.caducidad.isAfter(fechaC)){

                return respuesta.pasaporteCaducado;
            }

        }
        //System.out.println(verificado.id);
        //System.out.println(verificado.nacion);
        //System.out.println(verificado.name);
        return "Pass";
    }

    class Respuesta {

        private String entrada = "Cause no trouble.";
        private String entradaGloriosa = "Glory to Arstotzka.";
        private String pasaporteCaducado = "Entry denied: passport expired.";
        private String noVacuna = "Entry denied: missing required vaccination.";
        private String noPermisoAcceso = "Entry denied: missing required access permit.";
        private String detenerID = "Detainment: ID number mismatch.";
        private String detenerCriminal = "Detainment: Entrant is a wanted criminal.";
    }

    class Persona {
        public boolean esTrabajador = false;
        //PARA TODOS
        private String passport;
        private String certificate_of_vaccination;
        //LOCAL
        private String idCard;
        //EXTRANJERO
        private String accessPermit;
        private String workPass;
        private String grant_of_asylum;
        private String diplomatic_authorization;
        //DOCUMENTACION PERSONAL
        private String name;
        private String sexo;
        private String id;
        private LocalDate fecha;
        private String nacion;

        //DOCUMENTACION
        private ArrayList<String> documentosUsuario = new ArrayList<>();
        private ArrayList<String> documentosNecesarios = new ArrayList<>();

        public String getPassport() {
            return passport;
        }

        public void setPassport(String passport) {
            this.passport = passport;
        }

        public String getCertificate_of_vaccination() {
            return certificate_of_vaccination;
        }

        public void setCertificate_of_vaccination(String certificate_of_vaccination) {
            this.certificate_of_vaccination = certificate_of_vaccination;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getAccessPermit() {
            return accessPermit;
        }

        public void setAccessPermit(String accessPermit) {
            this.accessPermit = accessPermit;
        }

        public String getWorkPass() {
            return workPass;
        }

        public void setWorkPass(String workPass) {
            this.workPass = workPass;
        }

        public String getGrant_of_asylum() {
            return grant_of_asylum;
        }

        public void setGrant_of_asylum(String grant_of_asylum) {
            this.grant_of_asylum = grant_of_asylum;
        }

        public String getDiplomatic_authorization() {
            return diplomatic_authorization;
        }

        public void setDiplomatic_authorization(String diplomatic_authorization) {
            this.diplomatic_authorization = diplomatic_authorization;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public String getNacion() {
            return nacion;
        }

        public void setNacion(String nacion) {
            this.nacion = nacion;
        }

        public ArrayList<String> getDocumentosUsuario() {
            return documentosUsuario;
        }

        public void setDocumentosUsuario(ArrayList<String> documentosUsuario) {
            this.documentosUsuario = documentosUsuario;
        }

        public ArrayList<String> getDocumentosNecesarios() {
            return documentosNecesarios;
        }

        public void setDocumentosNecesarios(ArrayList<String> documentosNecesarios) {
            this.documentosNecesarios = documentosNecesarios;
        }
    }
}

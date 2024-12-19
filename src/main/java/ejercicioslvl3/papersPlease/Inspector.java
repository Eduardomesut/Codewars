/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioslvl3.papersPlease;

/**
 *
 * @author tarde
 */
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
    String dateStr = "1933.11.28";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    LocalDate caducidad = LocalDate.parse(dateStr, formatter);
    //RESPUESTA
    Respuesta respuesta = new Respuesta();

    public void receiveBulletin(String bulletin) {
        String leyes[] = bulletin.split("\\\\n");
        for (int i = 0; i < leyes.length; i++) {
            if (leyes[i].startsWith("Allow citizens of")) {
                String[] pais;
                String paises = leyes[i].substring(18);
                pais = paises.split(" ,");
                Arrays.stream(pais).forEach(s -> getPaisesPermitidos().add(s));

            } else if (leyes[i].startsWith("Deny citizens of")) {
                String[] pais;
                String paises = leyes[i].substring(17);
                pais = paises.split(" ,");
                Arrays.stream(pais).forEach(s -> getPaisesProhibidos().add(s));
            } else if (leyes[i].startsWith("Foreigners") || leyes[i].startsWith("Citizens") || leyes[i].startsWith("Workers") || leyes[i].startsWith("Entrants")) {
                documentacionNecesaria(leyes[i]);

            } else if (leyes[i].startsWith("Wanted")) {
                String criminal = leyes[i].substring(21);
                ArrayList<String> buscado = new ArrayList<>();
                buscado.add(criminal);
                this.setBuscados(buscado);

            }
        }
        System.out.println(this.getBuscados());
        System.out.println(this.getDocumentosPedidos());
        System.out.println(this.getPaisesPermitidos());
    }

    private void documentacionNecesaria(String ley) {
        if (ley.startsWith("Citizens of")) {

            String[] paises;

            String textoPais = ley.substring(12);
            if (textoPais.contains(",")) {
                paises = textoPais.split(", ");
                String[] texto = paises[paises.length - 1].split(" ");
                String pais = texto[0];
                String pedido = texto[2] + texto[3];

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

                    this.getDocumentosPedidos().add(paises[0] + ":" + paises[2] + paises[3]);
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
                    this.getDocumentosPedidos().add("Foreigners:" + required[2] + required[3]);
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
                    this.getDocumentosPedidos().add("Workers:" + required[2] + required[3]);
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
                    this.getDocumentosPedidos().add("Entrants:" + required[2] + required[3]);
                }

            }

        }

    }

    public String inspect(Map<String, String> person) {
        ArrayList<String> documentosUsuario = new ArrayList<>();
        Persona verificado = new Persona();
        String respuestaFinal = "";
        for (Map.Entry<String, String> entry : person.entrySet()) {
            documentosUsuario.add(entry.getKey());
            if (entry.getKey().equals("passport")) {
                respuestaFinal = verificarDocumento(entry.getValue(), verificado);

            } else if (entry.getKey().equals("certificate_of_vaccination")) {
                respuestaFinal = verificarDocumento(entry.getValue(), verificado);

            } else if (entry.getKey().equals("idCard")) {

                respuestaFinal = verificarDocumento(entry.getValue(), verificado);
            } else if (entry.getKey().equals("accessPermit")) {

                respuestaFinal = verificarDocumento(entry.getValue(), verificado);
            } else if (entry.getKey().equals("workPass")) {
                respuestaFinal = verificarDocumento(entry.getValue(), verificado);

            } else if (entry.getKey().equals("grant_of_asylum")) {

                respuestaFinal = verificarDocumento(entry.getValue(), verificado);
            } else if (entry.getKey().equals("diplomatic_authorization")) {
                respuestaFinal = verificarDocumento(entry.getValue(), verificado);

            }

        }
        System.out.println(documentosUsuario);

        return respuestaFinal;
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

    public String verificarDocumento(String value, Persona verificado) {
        
        if (value.contains("ID#:")) {
            
            
            if (verificado.id == null) {
                verificado.id = value.substring(value.indexOf("ID#:") + 4, value.indexOf("ID#:") + 16);
            }else{
                System.out.println(value.substring(value.indexOf("ID#:") + 4, value.indexOf("ID#:") + 16));
                if (!(value.substring(value.indexOf("ID#:") + 4, value.indexOf("ID#:") + 16).equals(verificado.id))) {
                    System.out.println();
                    System.out.println("fdfdfdfdfd");
                    return respuesta.detenerID;
                }
                
                
            }

        }

        System.out.println(verificado.id);
        return "";
    }

    class Respuesta {

        private String entrada = "Cause no trouble.";
        private String entradaGloriosa = "Glory to Arstotzka.";
        private String noPasaporte = "Entry denied: passport expired.";
        private String noVacuna = "Entry denied: missing required vaccination.";
        private String noPermisoAcceso = "Entry denied: missing required access permit.";
        private String detenerID = "Detainment: ID number mismatch.";
        private String detenerCriminal = "Detainment: Entrant is a wanted criminal.";
    }

    class Persona {

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

    }
}

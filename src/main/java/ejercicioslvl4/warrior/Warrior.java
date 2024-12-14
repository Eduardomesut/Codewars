package ejercicioslvl4.warrior;

import java.util.ArrayList;
import java.util.List;

public class Warrior {

    private int nivel = 1;
    private int experiencia = 100;
    private String rango = "Pushover";
    private List<String> logros = new ArrayList<>();

    //Funciones
    public int level(){
        return this.nivel;
    }

    public int experience(){
        return this.experiencia;
    }

    public String rank(){
        return this.rango;
    }
    public List<String> achievements(){
        return this.logros;
    }
    public String training(String type, int exp, int lvlRequired){
        if (this.nivel >= lvlRequired){
            this.subirExp(exp);
            this.getLogros().add(type);
            return type;
        }else {
            return "Not strong enough";
        }

    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public List<String> getLogros() {
        return logros;
    }

    public void setLogros(List<String> logros) {
        this.logros = logros;
    }
    public String battle(int i) {
        if (i > 100 || i < 1){
            return "Invalid level";
        }

        if (i == this.nivel){
            this.subirExp(10);
            return "A good fight";
        } else if (i + 1 == this.nivel) {
            this.subirExp(5);
            return "A good fight";
        } else if (i + 1 < this.nivel) {
            return "Easy fight";
        } else {
            int diff = 0;
            diff = i - this.nivel;

            Warrior enemigo = new Warrior();
            enemigo.subirNivel(i);
            System.out.println(enemigo.getRango());
            if (diff >= 5 && !enemigo.getRango().equals(this.getRango())){
                    return "You've been defeated";

            }else {
                    int experienciaGanada = 20 * diff * diff;
                    this.subirExp(experienciaGanada);
                    return "An intense fight";
            }
        }

    }
    public void subirNivel(int nivel){
        if (nivel<10){
            this.rango = "Pushover";
        } else if (nivel >= 10 && nivel < 20) {
            this.rango = "Novice";
        }else if (nivel >= 20 && nivel < 30) {
            this.rango = "Fighter";
        }else if (nivel >= 30 && nivel < 40) {
            this.rango = "Warrior";
        }else if (nivel >= 40 && nivel < 50) {
            this.rango = "Veteran";
        }else if (nivel >= 50 && nivel < 60) {
            this.rango = "Sage";
        }else if (nivel >= 60 && nivel < 70) {
            this.rango = "Elite";
        }else if (nivel >= 70 && nivel < 80) {
            this.rango = "Conqueror";
        }else if (nivel >= 80 && nivel < 90) {
            this.rango = "Champion";
        }else if (nivel >= 90 && nivel < 100) {
            this.rango = "Master";
        }else {
            this.rango = "Greatest";
        }

    }

    public void subirExp(int exp){
        if (this.experiencia + exp <= 10000){

            this.experiencia += exp;
            this.nivel = this.experiencia / 100;

            if (nivel<10){
                this.rango = "Pushover";
            } else if (nivel >= 10 && nivel < 20) {
                this.rango = "Novice";
            }else if (nivel >= 20 && nivel < 30) {
                this.rango = "Fighter";
            }else if (nivel >= 30 && nivel < 40) {
                this.rango = "Warrior";
            }else if (nivel >= 40 && nivel < 50) {
                this.rango = "Veteran";
            }else if (nivel >= 50 && nivel < 60) {
                this.rango = "Sage";
            }else if (nivel >= 60 && nivel < 70) {
                this.rango = "Elite";
            }else if (nivel >= 70 && nivel < 80) {
                this.rango = "Conqueror";
            }else if (nivel >= 80 && nivel < 90) {
                this.rango = "Champion";
            }else if (nivel >= 90 && nivel < 100) {
                this.rango = "Master";
            }else {
                this.rango = "Greatest";
            }


        }else{
            this.experiencia = 10000;
            this.nivel = 100;
            this.rango = "Greatest";
        }
    }

}



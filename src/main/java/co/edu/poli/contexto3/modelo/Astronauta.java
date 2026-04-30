package co.edu.poli.contexto3.modelo;

public class Astronauta extends Entidad {

    private String agenciaEspacial;
    private String rango;

    public Astronauta() {
        super();
    }

    public Astronauta(String id, String nombre, String agenciaEspacial, String rango) {
        super(id, nombre); 
        this.agenciaEspacial = agenciaEspacial;
        this.rango = rango;
    }


    public String getAgenciaEspacial() {
        return agenciaEspacial;
    }

    public String getRango() {
        return rango;
    }


    public void setAgenciaEspacial(String agenciaEspacial) {
        this.agenciaEspacial = agenciaEspacial;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }


    @Override
    public String toString() {
        return getNombre(); 
    }
}
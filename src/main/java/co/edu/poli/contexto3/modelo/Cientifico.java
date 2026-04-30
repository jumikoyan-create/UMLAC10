package co.edu.poli.contexto3.modelo;

public class Cientifico extends Entidad {

    private String especialidad;
    private int experienciaAnios;

    public Cientifico() {
        super();
    }

    public Cientifico(String id, String nombre, String especialidad, int experienciaAnios) {
        super(id, nombre); 
        this.especialidad = especialidad;
        this.experienciaAnios = experienciaAnios;
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public int getExperienciaAnios() {
        return experienciaAnios;
    }


    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setExperienciaAnios(int experienciaAnios) {
        this.experienciaAnios = experienciaAnios;
    }

    @Override
    public String toString() {
        return getNombre(); 
    }
}

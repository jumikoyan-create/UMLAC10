package co.edu.poli.contexto3.modelo;

public class Astronauta extends Persona {

    private static final long serialVersionUID = 3L;

    private String especialidad;

    public Astronauta() {}

    public Astronauta(String nombre, String id, String sexo) {
        super(nombre, id, sexo);
    }

    public Astronauta(String nombre, String id, String sexo, String especialidad) {
        super(nombre, id, sexo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty())
            throw new IllegalArgumentException("La especialidad no puede ser nula o vacía");
        this.especialidad = especialidad;
    }

    @Override
    public int sueldoSinPasaje() {
        return 5000000 - 180000;
    }

    @Override
    public String toString() {
        return "Astronauta{nombre='" + getNombre() +
               "', id='" + getId() +
               "', sexo='" + getSexo() +
               "', especialidad='" + especialidad + "'}";
    }
}
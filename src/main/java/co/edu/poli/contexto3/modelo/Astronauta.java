package co.edu.poli.contexto3.modelo;

public class Astronauta extends Persona {

    private String fechadenacimiento;

    public Astronauta() {
    }

    public Astronauta(String nombre, String id, String sexo) {
        super(nombre, id);
    }

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(String fechadenacimiento) throws IllegalArgumentException {
        if (fechadenacimiento == null || fechadenacimiento.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula o vacía");
        }
        this.fechadenacimiento = fechadenacimiento;
    }

    @Override
    public String toString() {
        return "Astronauta{" +
                "fechadenacimiento='" + fechadenacimiento + '\'' +
                '}';
    }

    @Override
    public int sueldoSinPasaje() {
        int sueldo = 5000000;
        int pasaje = 180000;
        int resultado = sueldo - pasaje;
        return resultado;
    }
}
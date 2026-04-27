package co.edu.poli.contexto3.modelo;
import java.io.Serializable;

public abstract class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private final String id;
    private double peso;
    private String especialidad;
    private String empresa;
    private String experiencia;
    private String fechainiciotrabajo;
    private String fechanacimiento;

    public Persona() {
        this.id = "";
    }

    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public final void mostrarTipo() {
        System.out.println("Soy una persona del sistema");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) throws IllegalArgumentException {
        if (peso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo");
        }
        this.peso = peso;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) throws IllegalArgumentException {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede ser nula o vacía");
        }
        this.especialidad = especialidad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) throws IllegalArgumentException {
        if (empresa == null || empresa.trim().isEmpty()) {
            throw new IllegalArgumentException("La empresa no puede ser nula o vacía");
        }
        this.empresa = empresa;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) throws IllegalArgumentException {
        if (experiencia == null || experiencia.trim().isEmpty()) {
            throw new IllegalArgumentException("La experiencia no puede ser nula o vacía");
        }
        this.experiencia = experiencia;
    }

    public String getFechainiciotrabajo() {
        return fechainiciotrabajo;
    }

    public void setFechainiciotrabajo(String fechainiciotrabajo) throws IllegalArgumentException {
        if (fechainiciotrabajo == null || fechainiciotrabajo.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula o vacía");
        }
        this.fechainiciotrabajo = fechainiciotrabajo;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) throws IllegalArgumentException {
        if (fechanacimiento == null || fechanacimiento.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula o vacía");
        }
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public int operacion(int i) {
        return i;
    }

    public abstract int sueldoSinPasaje();
}
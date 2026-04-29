package co.edu.poli.contexto3.modelo;
import java.io.Serializable;

public abstract class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private final String id;
    private String sexo;

    public Persona() {
        this.id = "";
    }

    public Persona(String nombre, String id, String sexo) {
        this.nombre = nombre;
        this.id     = id;
        this.sexo   = sexo;
    }

    // ── Getters / Setters ──────────────────
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        this.nombre = nombre;
    }

    public String getId()  { return id; }

    public String getSexo() { return sexo; }

    public void setSexo(String sexo) { this.sexo = sexo; }

    // ── Métodos ────────────────────────────
    public final void mostrarTipo() {
        System.out.println("Soy una persona del sistema");
    }

    public int operacion(int i) { return i; }

    public abstract int sueldoSinPasaje();

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', id='" + id + "', sexo='" + sexo + "'}";
    }
}

package co.edu.poli.contexto3.modelo;

public class Cientifico extends Persona {

    private static final long serialVersionUID = 2L;

    private String experiencia;
    private static double sueldo;

    public Cientifico() {}

    public Cientifico(String nombre, String id, String sexo) {
        super(nombre, id, sexo);
    }

    public Cientifico(String nombre, String id, String sexo, String experiencia) {
        super(nombre, id, sexo);
        this.experiencia = experiencia;
    }

    public String getExperiencia() { return experiencia; }

    public void setExperiencia(String experiencia) {
        if (experiencia == null || experiencia.trim().isEmpty())
            throw new IllegalArgumentException("La experiencia no puede ser nula o vacía");
        this.experiencia = experiencia;
    }

    public static double getSueldo()              { return sueldo; }
    public static void   setSueldo(double sueldo) {
        if (sueldo < 0)
            throw new IllegalArgumentException("El sueldo no puede ser negativo");
        Cientifico.sueldo = sueldo;
    }

    @Override
    public int operacion(int i) { return i * 2; }

    @Override
    public int sueldoSinPasaje() {
        return 2000000 - 180000;
    }

    @Override
    public String toString() {
        return "Cientifico{nombre='" + getNombre() +
               "', id='" + getId() +
               "', sexo='" + getSexo() +
               "', experiencia='" + experiencia + "'}";
    }
}
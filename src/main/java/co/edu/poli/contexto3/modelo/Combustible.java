package co.edu.poli.contexto3.modelo;

/**
 * Clase que representa un tipo de combustible con sus características.
 */
public class Combustible {

    /**
     * Identificador del combustible.
     */
    private String id;

    /**
     * Nombre del combustible.
     */
    private String nombre;

    /**
     * Indica si el combustible es inflamable.
     */
    private boolean esinflamable;

    /**
     * Marca del combustible.
     */
    private String marca;

    /**
     * Indica si el combustible es contaminante.
     */
    private boolean escontaminante;

    /**
     * Constructor vacío de la clase Combustible.
     */
    public Combustible() {
    }

    /**
     * Constructor con parámetros básicos del combustible.
     * 
     * @param id Identificador del combustible
     * @param nombre Nombre del combustible
     */
    public Combustible(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del combustible.
     * 
     * @return id del combustible
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del combustible.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del combustible.
     * 
     * @return nombre del combustible
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del combustible.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Indica si el combustible es inflamable.
     * 
     * @return true si es inflamable, false en caso contrario
     */
    public boolean isEsinflamable() {
        return esinflamable;
    }

    /**
     * Define si el combustible es inflamable.
     * 
     * @param esinflamable valor a asignar
     */
    public void setEsinflamable(boolean esinflamable) {
        this.esinflamable = esinflamable;
    }

    /**
     * Obtiene la marca del combustible.
     * 
     * @return marca del combustible
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del combustible.
     * 
     * @param marca nueva marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Indica si el combustible es contaminante.
     * 
     * @return true si es contaminante, false en caso contrario
     */
    public boolean isEscontaminante() {
        return escontaminante;
    }

    /**
     * Define si el combustible es contaminante.
     * 
     * @param escontaminante valor a asignar
     */
    public void setEscontaminante(boolean escontaminante) {
        this.escontaminante = escontaminante;
    }

    /**
     * Devuelve una representación en cadena del objeto Combustible.
     * 
     * @return cadena con la información del combustible
     */
    @Override
    public String toString() {
        return "Combustible{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
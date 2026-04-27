package co.edu.poli.contexto3.modelo;

/**
 * Clase que representa el suelo con sus características físicas.
 */
public class Suelo {

    /**
     * Nombre del suelo.
     */
    private String nombre;

    /**
     * Identificador del suelo.
     */
    private String id;

    /**
     * Material del suelo.
     */
    private String material;

    /**
     * Estado del suelo.
     */
    private String estado;

    /**
     * Tamaño del suelo.
     */
    private double tamanio;

    /**
     * Indica si el suelo es estable.
     */
    private boolean estable;

    /**
     * Constructor vacío de la clase Suelo.
     */
    public Suelo() {
    }

    /**
     * Constructor con parámetros básicos del suelo.
     * 
     * @param nombre Nombre del suelo
     * @param id Identificador del suelo
     */
    public Suelo(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre del suelo.
     * 
     * @return nombre del suelo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del suelo.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del suelo.
     * 
     * @return id del suelo
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del suelo.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el material del suelo.
     * 
     * @return material del suelo
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el material del suelo.
     * 
     * @param material nuevo material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Obtiene el estado del suelo.
     * 
     * @return estado del suelo
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del suelo.
     * 
     * @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el tamaño del suelo.
     * 
     * @return tamaño del suelo
     */
    public double getTamanio() {
        return tamanio;
    }

    /**
     * Establece el tamaño del suelo.
     * 
     * @param tamanio nuevo tamaño
     */
    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * Indica si el suelo es estable.
     * 
     * @return true si es estable, false en caso contrario
     */
    public boolean isEstable() {
        return estable;
    }

    /**
     * Define si el suelo es estable.
     * 
     * @param estable valor a asignar
     */
    public void setEstable(boolean estable) {
        this.estable = estable;
    }

    /**
     * Devuelve una representación en cadena del objeto Suelo.
     * 
     * @return cadena con la información del suelo
     */
    @Override
    public String toString() {
        return "Suelo{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
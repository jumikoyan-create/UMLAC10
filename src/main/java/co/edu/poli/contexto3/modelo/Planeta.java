package co.edu.poli.contexto3.modelo;

/**
 * Clase que representa un planeta con sus características físicas
 * y su relación con misiones y suelo.
 */
public class Planeta {

    /**
     * Nombre del planeta.
     */
    private String nombre;

    /**
     * Identificador del planeta.
     */
    private String id;

    /**
     * Tamaño del planeta.
     */
    private double tamanio;

    /**
     * Material predominante del planeta.
     */
    private String material;

    /**
     * Indica si el planeta es habitable.
     */
    private boolean eshabitable;

    /**
     * Fecha de descubrimiento del planeta.
     */
    private String fechadescubrimiento;

    /**
     * Distancia del planeta a la Tierra.
     */
    private double distanciaalatierra;

    /**
     * Suelo del planeta.
     */
    private Suelo suelo;

    /**
     * Misión asociada al planeta.
     */
    private Mision mision;

    /**
     * Constructor vacío de la clase Planeta.
     */
    public Planeta() {
    }

    /**
     * Constructor con parámetros básicos del planeta.
     * 
     * @param nombre Nombre del planeta
     * @param id Identificador del planeta
     */
    public Planeta(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre del planeta.
     * 
     * @return nombre del planeta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del planeta.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del planeta.
     * 
     * @return id del planeta
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del planeta.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el tamaño del planeta.
     * 
     * @return tamaño del planeta
     */
    public double getTamanio() {
        return tamanio;
    }

    /**
     * Establece el tamaño del planeta.
     * 
     * @param tamanio nuevo tamaño
     */
    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * Obtiene el material del planeta.
     * 
     * @return material del planeta
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el material del planeta.
     * 
     * @param material nuevo material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Indica si el planeta es habitable.
     * 
     * @return true si es habitable, false en caso contrario
     */
    public boolean isEshabitable() {
        return eshabitable;
    }

    /**
     * Define si el planeta es habitable.
     * 
     * @param eshabitable valor a asignar
     */
    public void setEshabitable(boolean eshabitable) {
        this.eshabitable = eshabitable;
    }

    /**
     * Obtiene la fecha de descubrimiento del planeta.
     * 
     * @return fecha de descubrimiento
     */
    public String getFechadescubrimiento() {
        return fechadescubrimiento;
    }

    /**
     * Establece la fecha de descubrimiento del planeta.
     * 
     * @param fechadescubrimiento nueva fecha
     */
    public void setFechadescubrimiento(String fechadescubrimiento) {
        this.fechadescubrimiento = fechadescubrimiento;
    }

    /**
     * Obtiene la distancia del planeta a la Tierra.
     * 
     * @return distancia a la Tierra
     */
    public double getDistanciaalatierra() {
        return distanciaalatierra;
    }

    /**
     * Establece la distancia del planeta a la Tierra.
     * 
     * @param distanciaalatierra nueva distancia
     */
    public void setDistanciaalatierra(double distanciaalatierra) {
        this.distanciaalatierra = distanciaalatierra;
    }

    /**
     * Obtiene el suelo del planeta.
     * 
     * @return objeto Suelo
     */
    public Suelo getSuelo() {
        return suelo;
    }

    /**
     * Establece el suelo del planeta.
     * 
     * @param suelo objeto Suelo a asignar
     */
    public void setSuelo(Suelo suelo) {
        this.suelo = suelo;
    }

    /**
     * Obtiene la misión asociada al planeta.
     * 
     * @return objeto Mision
     */
    public Mision getMision() {
        return mision;
    }

    /**
     * Establece la misión del planeta.
     * 
     * @param mision objeto Mision a asignar
     */
    public void setMision(Mision mision) {
        this.mision = mision;
    }

    /**
     * Devuelve una representación en cadena del objeto Planeta.
     * 
     * @return cadena con la información del planeta
     */
    @Override
    public String toString() {
        return "Planeta{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
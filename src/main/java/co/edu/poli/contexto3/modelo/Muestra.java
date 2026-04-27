package co.edu.poli.contexto3.modelo;

/**
 * Clase que representa una muestra con sus características y origen.
 */
public class Muestra {

    /**
     * Identificador de la muestra.
     */
    private String id;

    /**
     * Nombre de la muestra.
     */
    private String nombre;

    /**
     * Tipo de muestra.
     */
    private String tipomuestra;

    /**
     * Cantidad de la muestra.
     */
    private int cantidad;

    /**
     * Material de la muestra.
     */
    private String material;

    /**
     * Estado de la muestra.
     */
    private String estado;

    /**
     * Lugar de donde proviene la muestra.
     */
    private String dedondeviene;

    /**
     * Indica si la muestra es radioactiva.
     */
    private boolean esradioactiva;

    /**
     * Fecha de recolección de la muestra.
     */
    private String fecharecoleccion;

    /**
     * Suelo asociado a la muestra.
     */
    private Suelo suelo;

    /**
     * Constructor vacío de la clase Muestra.
     */
    public Muestra() {
    }

    /**
     * Constructor con parámetros básicos de la muestra.
     * 
     * @param id Identificador de la muestra
     * @param nombre Nombre de la muestra
     */
    public Muestra(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la muestra.
     * 
     * @return id de la muestra
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la muestra.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la muestra.
     * 
     * @return nombre de la muestra
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la muestra.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de muestra.
     * 
     * @return tipo de muestra
     */
    public String getTipomuestra() {
        return tipomuestra;
    }

    /**
     * Establece el tipo de muestra.
     * 
     * @param tipomuestra nuevo tipo de muestra
     */
    public void setTipomuestra(String tipomuestra) {
        this.tipomuestra = tipomuestra;
    }

    /**
     * Obtiene la cantidad de la muestra.
     * 
     * @return cantidad de la muestra
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de la muestra.
     * 
     * @param cantidad nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el material de la muestra.
     * 
     * @return material de la muestra
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el material de la muestra.
     * 
     * @param material nuevo material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Obtiene el estado de la muestra.
     * 
     * @return estado de la muestra
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la muestra.
     * 
     * @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el lugar de origen de la muestra.
     * 
     * @return origen de la muestra
     */
    public String getDedondeviene() {
        return dedondeviene;
    }

    /**
     * Establece el lugar de origen de la muestra.
     * 
     * @param dedondeviene nuevo origen
     */
    public void setDedondeviene(String dedondeviene) {
        this.dedondeviene = dedondeviene;
    }

    /**
     * Indica si la muestra es radioactiva.
     * 
     * @return true si es radioactiva, false en caso contrario
     */
    public boolean isEsradioactiva() {
        return esradioactiva;
    }

    /**
     * Define si la muestra es radioactiva.
     * 
     * @param esradioactiva valor a asignar
     */
    public void setEsradioactiva(boolean esradioactiva) {
        this.esradioactiva = esradioactiva;
    }

    /**
     * Obtiene la fecha de recolección de la muestra.
     * 
     * @return fecha de recolección
     */
    public String getFecharecoleccion() {
        return fecharecoleccion;
    }

    /**
     * Establece la fecha de recolección de la muestra.
     * 
     * @param fecharecoleccion nueva fecha
     */
    public void setFecharecoleccion(String fecharecoleccion) {
        this.fecharecoleccion = fecharecoleccion;
    }

    /**
     * Obtiene el suelo asociado a la muestra.
     * 
     * @return objeto Suelo
     */
    public Suelo getSuelo() {
        return suelo;
    }

    /**
     * Establece el suelo de la muestra.
     * 
     * @param suelo objeto Suelo a asignar
     */
    public void setSuelo(Suelo suelo) {
        this.suelo = suelo;
    }

    /**
     * Devuelve una representación en cadena del objeto Muestra.
     * 
     * @return cadena con la información de la muestra
     */
    @Override
    public String toString() {
        return "Muestra{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
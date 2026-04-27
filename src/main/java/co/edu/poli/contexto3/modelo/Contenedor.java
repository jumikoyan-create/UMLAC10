package co.edu.poli.contexto3.modelo;

/**
 * Clase que representa un contenedor utilizado para almacenar muestras.
 */
public class Contenedor {

    /**
     * Nombre del contenedor.
     */
    private String nombre;

    /**
     * Identificador del contenedor.
     */
    private String id;

    /**
     * Tamaño del contenedor.
     */
    private double tamanio;

    /**
     * Tipo de contenedor.
     */
    private String tipo;

    /**
     * Marca del contenedor.
     */
    private String marca;

    /**
     * Indica si el contenedor puede ser esterilizado.
     */
    private boolean esterilizable;

    /**
     * Indica si el contenedor es delicado.
     */
    private boolean esdelicado;

    /**
     * Muestra almacenada en el contenedor.
     */
    private Muestra muestra;

    /**
     * Constructor vacío de la clase Contenedor.
     */
    public Contenedor() {
    }

    /**
     * Constructor con parámetros básicos del contenedor.
     * 
     * @param nombre Nombre del contenedor
     * @param id Identificador del contenedor
     */
    public Contenedor(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre del contenedor.
     * 
     * @return nombre del contenedor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del contenedor.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del contenedor.
     * 
     * @return id del contenedor
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del contenedor.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el tamaño del contenedor.
     * 
     * @return tamaño del contenedor
     */
    public double getTamanio() {
        return tamanio;
    }

    /**
     * Establece el tamaño del contenedor.
     * 
     * @param tamanio nuevo tamaño
     */
    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * Obtiene el tipo del contenedor.
     * 
     * @return tipo del contenedor
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del contenedor.
     * 
     * @param tipo nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la marca del contenedor.
     * 
     * @return marca del contenedor
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del contenedor.
     * 
     * @param marca nueva marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Indica si el contenedor es esterilizable.
     * 
     * @return true si es esterilizable, false en caso contrario
     */
    public boolean isEsterilizable() {
        return esterilizable;
    }

    /**
     * Define si el contenedor es esterilizable.
     * 
     * @param esterilizable valor a asignar
     */
    public void setEsterilizable(boolean esterilizable) {
        this.esterilizable = esterilizable;
    }

    /**
     * Indica si el contenedor es delicado.
     * 
     * @return true si es delicado, false en caso contrario
     */
    public boolean isEsdelicado() {
        return esdelicado;
    }

    /**
     * Define si el contenedor es delicado.
     * 
     * @param esdelicado valor a asignar
     */
    public void setEsdelicado(boolean esdelicado) {
        this.esdelicado = esdelicado;
    }

    /**
     * Obtiene la muestra almacenada en el contenedor.
     * 
     * @return objeto Muestra
     */
    public Muestra getMuestra() {
        return muestra;
    }

    /**
     * Establece la muestra del contenedor.
     * 
     * @param muestra objeto Muestra a asignar
     */
    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }

    /**
     * Devuelve una representación en cadena del objeto Contenedor.
     * 
     * @return cadena con la información del contenedor
     */
    @Override
    public String toString() {
        return "Contenedor{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
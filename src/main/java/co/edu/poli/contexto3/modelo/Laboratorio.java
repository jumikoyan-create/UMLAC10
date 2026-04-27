package co.edu.poli.contexto3.modelo;

/**
 * Clase que representa un laboratorio con sus características,
 * empleados y contenedores asociados.
 */
public class Laboratorio {

    /**
     * Nombre del laboratorio.
     */
    private String nombre;

    /**
     * Identificador del laboratorio.
     */
    private String id;

    /**
     * Dirección del laboratorio.
     */
    private String direccion;

    /**
     * Tamaño del laboratorio.
     */
    private double tamanio;

    /**
     * Indica si el laboratorio es moderno.
     */
    private boolean esmoderno;

    /**
     * Número de empleados del laboratorio.
     */
    private int numeroempleados;

    /**
     * Horario de funcionamiento del laboratorio.
     */
    private String horario;

    /**
     * Arreglo de contenedores asociados al laboratorio.
     */
    private Contenedor[] contenedor;

    /**
     * Arreglo de científicos que trabajan en el laboratorio.
     */
    private Cientifico[] cientifico;

    /**
     * Constructor vacío de la clase Laboratorio.
     */
    public Laboratorio() {
    }

    /**
     * Constructor con parámetros básicos del laboratorio.
     * 
     * @param nombre Nombre del laboratorio
     * @param id Identificador del laboratorio
     */
    public Laboratorio(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre del laboratorio.
     * 
     * @return nombre del laboratorio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del laboratorio.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del laboratorio.
     * 
     * @return id del laboratorio
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del laboratorio.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la dirección del laboratorio.
     * 
     * @return dirección del laboratorio
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del laboratorio.
     * 
     * @param direccion nueva dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el tamaño del laboratorio.
     * 
     * @return tamaño del laboratorio
     */
    public double getTamanio() {
        return tamanio;
    }

    /**
     * Establece el tamaño del laboratorio.
     * 
     * @param tamanio nuevo tamaño
     */
    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * Indica si el laboratorio es moderno.
     * 
     * @return true si es moderno, false en caso contrario
     */
    public boolean isEsmoderno() {
        return esmoderno;
    }

    /**
     * Define si el laboratorio es moderno.
     * 
     * @param esmoderno valor a asignar
     */
    public void setEsmoderno(boolean esmoderno) {
        this.esmoderno = esmoderno;
    }

    /**
     * Obtiene el número de empleados del laboratorio.
     * 
     * @return número de empleados
     */
    public int getNumeroempleados() {
        return numeroempleados;
    }

    /**
     * Establece el número de empleados del laboratorio.
     * 
     * @param numeroempleados nuevo número de empleados
     */
    public void setNumeroempleados(int numeroempleados) {
        this.numeroempleados = numeroempleados;
    }

    /**
     * Obtiene el horario del laboratorio.
     * 
     * @return horario del laboratorio
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Establece el horario del laboratorio.
     * 
     * @param horario nuevo horario
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Obtiene el arreglo de contenedores del laboratorio.
     * 
     * @return arreglo de objetos Contenedor
     */
    public Contenedor[] getContenedor() {
        return contenedor;
    }

    /**
     * Establece el arreglo de contenedores del laboratorio.
     * 
     * @param contenedor arreglo de contenedores
     */
    public void setContenedor(Contenedor[] contenedor) {
        this.contenedor = contenedor;
    }

    /**
     * Obtiene el arreglo de científicos del laboratorio.
     * 
     * @return arreglo de objetos Cientifico
     */
    public Cientifico[] getCientifico() {
        return cientifico;
    }

    /**
     * Establece el arreglo de científicos del laboratorio.
     * 
     * @param cientifico arreglo de científicos
     */
    public void setCientifico(Cientifico[] cientifico) {
        this.cientifico = cientifico;
    }

    /**
     * Devuelve una representación en cadena del objeto Laboratorio.
     * 
     * @return cadena con la información del laboratorio
     */
    @Override
    public String toString() {
        return "Laboratorio{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
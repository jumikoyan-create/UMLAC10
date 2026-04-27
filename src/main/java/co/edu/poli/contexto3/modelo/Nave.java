package co.edu.poli.contexto3.modelo;

/**
 * Clase que representa una nave espacial con sus características,
 * componentes y tripulación.
 */
public class Nave {

    /**
     * Nombre de la nave.
     */
    private String nombre;

    /**
     * Identificador de la nave.
     */
    private String id;

    /**
     * Material de construcción de la nave.
     */
    private String material;

    /**
     * Fecha de creación de la nave.
     */
    private String fechadecreacion;

    /**
     * Peso de la nave.
     */
    private double peso;

    /**
     * Tamaño de la nave.
     */
    private double tamanio;

    /**
     * Velocidad de la nave.
     */
    private double velocidad;

    /**
     * Combustible utilizado por la nave.
     */
    private Combustible combustible;

    /**
     * Misión asignada a la nave.
     */
    private Mision mision;

    /**
     * Robot presente en la nave.
     */
    private Robot robot;

    /**
     * Arreglo de astronautas que conforman la tripulación.
     */
    private Astronauta[] astronauta;

    /**
     * Constructor vacío de la clase Nave.
     */
    public Nave() {
    }

    /**
     * Constructor con parámetros básicos de la nave.
     * 
     * @param nombre Nombre de la nave
     * @param id Identificador de la nave
     */
    public Nave(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre de la nave.
     * 
     * @return nombre de la nave
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la nave.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la nave.
     * 
     * @return id de la nave
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la nave.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el material de la nave.
     * 
     * @return material de la nave
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el material de la nave.
     * 
     * @param material nuevo material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Obtiene la fecha de creación de la nave.
     * 
     * @return fecha de creación
     */
    public String getFechadecreacion() {
        return fechadecreacion;
    }

    /**
     * Establece la fecha de creación de la nave.
     * 
     * @param fechadecreacion nueva fecha
     */
    public void setFechadecreacion(String fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }

    /**
     * Obtiene el peso de la nave.
     * 
     * @return peso de la nave
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso de la nave.
     * 
     * @param peso nuevo peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el tamaño de la nave.
     * 
     * @return tamaño de la nave
     */
    public double getTamanio() {
        return tamanio;
    }

    /**
     * Establece el tamaño de la nave.
     * 
     * @param tamanio nuevo tamaño
     */
    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * Obtiene la velocidad de la nave.
     * 
     * @return velocidad de la nave
     */
    public double getVelocidad() {
        return velocidad;
    }

    /**
     * Establece la velocidad de la nave.
     * 
     * @param velocidad nueva velocidad
     */
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Obtiene el combustible de la nave.
     * 
     * @return objeto Combustible
     */
    public Combustible getCombustible() {
        return combustible;
    }

    /**
     * Establece el combustible de la nave.
     * 
     * @param combustible objeto Combustible a asignar
     */
    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    /**
     * Obtiene la misión de la nave.
     * 
     * @return objeto Mision
     */
    public Mision getMision() {
        return mision;
    }

    /**
     * Establece la misión de la nave.
     * 
     * @param mision objeto Mision a asignar
     */
    public void setMision(Mision mision) {
        this.mision = mision;
    }

    /**
     * Obtiene el robot de la nave.
     * 
     * @return objeto Robot
     */
    public Robot getRobot() {
        return robot;
    }

    /**
     * Establece el robot de la nave.
     * 
     * @param robot objeto Robot a asignar
     */
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    /**
     * Obtiene la tripulación de astronautas.
     * 
     * @return arreglo de objetos Astronauta
     */
    public Astronauta[] getAstronauta() {
        return astronauta;
    }

    /**
     * Establece la tripulación de astronautas.
     * 
     * @param astronauta arreglo de astronautas
     */
    public void setAstronauta(Astronauta[] astronauta) {
        this.astronauta = astronauta;
    }

    /**
     * Devuelve una representación en cadena del objeto Nave.
     * 
     * @return cadena con la información de la nave
     */
    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
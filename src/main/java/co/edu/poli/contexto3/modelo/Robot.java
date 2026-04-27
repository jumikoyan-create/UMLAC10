package co.edu.poli.contexto3.modelo;

/**
 * Clase final que representa un robot con sus características físicas
 * y funcionales. No puede ser heredada.
 */
public final class Robot {

    /**
     * Identificador del robot.
     */
    private String id;

    /**
     * Modelo del robot.
     */
    private String modelo;

    /**
     * Material de construcción del robot.
     */
    private String material;

    /**
     * Peso del robot.
     */
    private double peso;

    /**
     * Estado del robot.
     */
    private String estado;

    /**
     * Fecha de creación del robot.
     */
    private String fechadecreacion;

    /**
     * Capacidad de batería del robot.
     */
    private int capacidadbateria;

    /**
     * Constructor vacío de la clase Robot.
     */
    public Robot() {
    }

    /**
     * Constructor con parámetros básicos del robot.
     * 
     * @param id Identificador del robot
     * @param modelo Modelo del robot
     */
    public Robot(String id, String modelo) {
        this.id = id;
        this.modelo = modelo;
    }

    /**
     * Obtiene el identificador del robot.
     * 
     * @return id del robot
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del robot.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el modelo del robot.
     * 
     * @return modelo del robot
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del robot.
     * 
     * @param modelo nuevo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el material del robot.
     * 
     * @return material del robot
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el material del robot.
     * 
     * @param material nuevo material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Obtiene el peso del robot.
     * 
     * @return peso del robot
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del robot.
     * 
     * @param peso nuevo peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el estado del robot.
     * 
     * @return estado del robot
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del robot.
     * 
     * @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de creación del robot.
     * 
     * @return fecha de creación
     */
    public String getFechadecreacion() {
        return fechadecreacion;
    }

    /**
     * Establece la fecha de creación del robot.
     * 
     * @param fechadecreacion nueva fecha
     */
    public void setFechadecreacion(String fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }

    /**
     * Obtiene la capacidad de batería del robot.
     * 
     * @return capacidad de batería
     */
    public int getCapacidadbateria() {
        return capacidadbateria;
    }

    /**
     * Establece la capacidad de batería del robot.
     * 
     * @param capacidadbateria nueva capacidad
     */
    public void setCapacidadbateria(int capacidadbateria) {
        this.capacidadbateria = capacidadbateria;
    }

    /**
     * Devuelve una representación en cadena del objeto Robot.
     * 
     * @return cadena con la información del robot
     */
    @Override
    public String toString() {
        return "Robot{" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
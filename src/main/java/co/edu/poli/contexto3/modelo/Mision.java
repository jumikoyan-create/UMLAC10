package co.edu.poli.contexto3.modelo;

/**
 * Clase que representa una misión con sus características principales.
 */
public class Mision {

    /**
     * Nombre de la misión.
     */
    private String nombre;

    /**
     * Identificador de la misión.
     */
    private String id;

    /**
     * Lugar donde se realiza la misión.
     */
    private String lugar;

    /**
     * Fecha de inicio de la misión.
     */
    private int fechadeinicio;

    /**
     * Fecha de finalización de la misión.
     */
    private int fechafinalizacion;

    /**
     * Objetivo principal de la misión.
     */
    private String objetivo;

    /**
     * Persona encargada de la misión.
     */
    private String encargado;

    /**
     * Beneficio que aporta la misión.
     */
    private String beneficio;

    /**
     * Planeta asociado a la misión.
     */
    private Planeta planeta;

    /**
     * Constructor vacío de la clase Mision.
     */
    public Mision() {
    }

    /**
     * Constructor con parámetros básicos de la misión.
     * 
     * @param nombre Nombre de la misión
     * @param id Identificador de la misión
     */
    public Mision(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre de la misión.
     * 
     * @return nombre de la misión
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la misión.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la misión.
     * 
     * @return id de la misión
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la misión.
     * 
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el lugar de la misión.
     * 
     * @return lugar de la misión
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar de la misión.
     * 
     * @param lugar nuevo lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Obtiene la fecha de inicio de la misión.
     * 
     * @return fecha de inicio
     */
    public int getFechadeinicio() {
        return fechadeinicio;
    }

    /**
     * Establece la fecha de inicio de la misión.
     * 
     * @param fechadeinicio nueva fecha de inicio
     */
    public void setFechadeinicio(int fechadeinicio) {
        this.fechadeinicio = fechadeinicio;
    }

    /**
     * Obtiene la fecha de finalización de la misión.
     * 
     * @return fecha de finalización
     */
    public int getFechafinalizacion() {
        return fechafinalizacion;
    }

    /**
     * Establece la fecha de finalización de la misión.
     * 
     * @param fechafinalizacion nueva fecha de finalización
     */
    public void setFechafinalizacion(int fechafinalizacion) {
        this.fechafinalizacion = fechafinalizacion;
    }

    /**
     * Obtiene el objetivo de la misión.
     * 
     * @return objetivo de la misión
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * Establece el objetivo de la misión.
     * 
     * @param objetivo nuevo objetivo
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Obtiene el encargado de la misión.
     * 
     * @return encargado de la misión
     */
    public String getEncargado() {
        return encargado;
    }

    /**
     * Establece el encargado de la misión.
     * 
     * @param encargado nuevo encargado
     */
    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    /**
     * Obtiene el beneficio de la misión.
     * 
     * @return beneficio de la misión
     */
    public String getBeneficio() {
        return beneficio;
    }

    /**
     * Establece el beneficio de la misión.
     * 
     * @param beneficio nuevo beneficio
     */
    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    /**
     * Obtiene el planeta asociado a la misión.
     * 
     * @return objeto Planeta
     */
    public Planeta getPlaneta() {
        return planeta;
    }

    /**
     * Establece el planeta de la misión.
     * 
     * @param planeta objeto Planeta a asignar
     */
    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    /**
     * Devuelve una representación en cadena del objeto Mision.
     * 
     * @return cadena con la información de la misión
     */
    @Override
    public String toString() {
        return "Mision{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
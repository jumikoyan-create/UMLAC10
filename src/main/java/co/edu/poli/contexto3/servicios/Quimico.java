package co.edu.poli.contexto3.servicios;
import co.edu.poli.contexto3.modelo.Cientifico;

/**
 * Clase que representa un Químico, la cual hereda de la clase Cientifico
 * y añade características específicas como especialización y uniforme.
 */
public class Quimico extends Cientifico {

    private static final long serialVersionUID = 1L;

    /**
     * Especialización del químico.
     */
    private String especializacion;

    /**
     * Uniforme del químico (compartido por todas las instancias).
     */
    private static String uniforme;

    /**
     * Constructor vacío de la clase Quimico.
     */
    public Quimico() {
        super();
    }

    /**
     * Constructor con parámetros básicos del químico.
     *
     * @param id Identificador del químico
     * @param nombre Nombre del químico
     * @param especialidad Especialidad del científico base
     */
    public Quimico(String id,String nombre, String especialidad, int experienciaAnios) {
        super(id, nombre, especialidad, experienciaAnios);
    }

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
     * Obtiene la especialización del químico.
     *
     * @return especialización
     */
    public String getEspecializacion() {
        return especializacion;
    }

    /**
     * Establece la especialización del químico.
     *
     * @param especializacion nueva especialización
     */
    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    /**
     * Obtiene el uniforme del químico.
     *
     * @return uniforme actual
     */
    public static String getUniforme() {
        return uniforme;
    }

    /**
     * Establece el uniforme del químico.
     *
     * @param uniforme nuevo uniforme
     */
    public static void setUniforme(String uniforme) {
        Quimico.uniforme = uniforme;
    }

    /**
     * Calcula la edad del químico a partir del año actual.
     *
     * @param anioactual año actual
     * @return edad calculada (actualmente retorna 0)
     */
    public static double calcularedad(int anioactual) {
        return 0;
    }

    /**
     * Devuelve una representación en cadena del objeto Quimico.
     *
     * @return cadena con la información del químico
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Quimico{" +
                "especializacion='" + especializacion + '\'' +
                ", uniforme='" + uniforme + '\'' +
                '}';
    }

  
 
}
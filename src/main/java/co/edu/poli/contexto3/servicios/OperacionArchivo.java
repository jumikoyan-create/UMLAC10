package co.edu.poli.contexto3.servicios;

import co.edu.poli.contexto3.modelo.Persona;

/**
 * Interfaz que define las operaciones de manejo de archivos
 * para objetos de tipo Persona, incluyendo serialización
 * y deserialización.
 */
public interface OperacionArchivo {

    /**
     * Serializa un arreglo de personas y lo guarda en un archivo.
     * 
     * @param personas arreglo de objetos Persona a guardar
     * @param path ruta donde se almacenará el archivo
     * @param name nombre del archivo
     * @return mensaje indicando el resultado de la operación
     */
    public String serializar(Persona[] personas, String path, String name);

    /**
     * Deserializa un archivo y recupera un arreglo de personas.
     * 
     * @param path ruta del archivo
     * @param name nombre del archivo
     * @return arreglo de objetos Persona recuperado
     */
    public Persona[] deserializar(String path, String name);
}
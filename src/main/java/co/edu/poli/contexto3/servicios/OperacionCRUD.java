package co.edu.poli.contexto3.servicios;

import co.edu.poli.contexto3.modelo.Persona;

/**
 * Interfaz que define las operaciones básicas CRUD
 * (Crear, Leer, Actualizar y Eliminar) para objetos de tipo Persona.
 */
public interface OperacionCRUD {

    /**
     * Crea una nueva persona.
     * 
     * @param p objeto Persona a crear
     */
    void crear(Persona p);

    /**
     * Lee o busca una persona por su ID.
     * 
     * @param id identificador de la persona
     * @return objeto Persona encontrado o null si no existe
     */
    Persona leer(String id);

    /**
     * Actualiza la información de una persona existente.
     * 
     * @param id identificador de la persona a actualizar
     * @param p nueva información de la persona
     */
    void actualizar(String id, Persona p);

    /**
     * Elimina una persona por su ID.
     * 
     * @param id identificador de la persona a eliminar
     */
    void eliminar(String id);

}
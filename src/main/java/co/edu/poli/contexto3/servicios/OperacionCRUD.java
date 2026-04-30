package co.edu.poli.contexto3.servicios;

import co.edu.poli.contexto3.modelo.Entidad;

/**
 * Interfaz que define las operaciones básicas CRUD
 * (Crear, Leer, Actualizar y Eliminar) para objetos
 * que heredan de Entidad.
 *
 * Permite manejar cualquier tipo de entidad del sistema
 * (Astronauta, Cientifico, MuestraSuelo, etc.).
 */
public interface OperacionCRUD {

    /**
     * Crea una nueva entidad en el sistema.
     *
     * @param e objeto Entidad a crear
     */
    void crear(Entidad e);

    /**
     * Busca una entidad por su identificador.
     *
     * @param id identificador de la entidad
     * @return entidad encontrada o null si no existe
     */
    Entidad leer(String id);

    /**
     * Actualiza la información de una entidad existente.
     *
     * @param id identificador de la entidad a actualizar
     * @param e nueva información de la entidad
     */
    void actualizar(String id, Entidad e);

    /**
     * Elimina una entidad del sistema por su ID.
     *
     * @param id identificador de la entidad a eliminar
     */
    void eliminar(String id);
    

    Entidad[] listar();
}
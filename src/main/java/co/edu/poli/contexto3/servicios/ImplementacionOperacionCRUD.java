package co.edu.poli.contexto3.servicios;

import co.edu.poli.contexto3.modelo.Entidad;
import java.io.*;

public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

    private Entidad[] entidades = new Entidad[2];

    public Entidad[] getEntidades() {
        return this.entidades;
    }

    public void setEntidades(Entidad[] entidades) {
        this.entidades = entidades;
    }

    // =========================
    // CREAR (con crecimiento)
    // =========================
    @Override
    public void crear(Entidad e) {

        try {
            if (e == null) {
                throw new IllegalArgumentException("No se puede agregar un objeto null");
            }

            if (leer(e.getId()) != null) {
                throw new IllegalArgumentException("Ya existe una entidad con ese ID");
            }

            // 1. Buscar espacio vacío
            for (int i = 0; i < entidades.length; i++) {
                if (entidades[i] == null) {
                    entidades[i] = e;
                    System.out.println("Entidad agregada en posición " + i);
                    return;
                }
            }

            // 2. Si no hay espacio → crecer arreglo
            Entidad[] nuevo = new Entidad[entidades.length + 1];

            for (int i = 0; i < entidades.length; i++) {
                nuevo[i] = entidades[i];
            }

            nuevo[entidades.length] = e;
            entidades = nuevo;

            System.out.println("Arreglo expandido. Entidad agregada en posición " + (entidades.length - 1));

        } catch (IllegalArgumentException ex) {
            System.out.println("Error al crear: " + ex.getMessage());
        }
    }

    // =========================
    // LEER
    // =========================
    @Override
    public Entidad leer(String id) {

        try {
            if (id == null) {
                throw new IllegalArgumentException("El ID no puede ser nulo");
            }

            for (Entidad e : entidades) {
                if (e != null && e.getId().equals(id)) {
                    return e;
                }
            }

        } catch (IllegalArgumentException ex) {
            System.out.println("Error al leer: " + ex.getMessage());
        }

        return null;
    }

    // =========================
    // ACTUALIZAR
    // =========================
    @Override
    public void actualizar(String id, Entidad nueva) {

        try {
            if (id == null || nueva == null) {
                throw new IllegalArgumentException("ID o entidad no pueden ser nulos");
            }

            for (int i = 0; i < entidades.length; i++) {
                if (entidades[i] != null && entidades[i].getId().equals(id)) {
                    entidades[i] = nueva;
                    System.out.println("Entidad actualizada con ID: " + id);
                    return;
                }
            }

            System.out.println("No se encontró entidad con ID: " + id);

        } catch (IllegalArgumentException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        }
    }

    // =========================
    // ELIMINAR
    // =========================
    @Override
    public void eliminar(String id) {

        try {
            if (id == null) {
                throw new IllegalArgumentException("El ID no puede ser nulo");
            }

            for (int i = 0; i < entidades.length; i++) {
                if (entidades[i] != null && entidades[i].getId().equals(id)) {
                    entidades[i] = null;
                    System.out.println("Entidad eliminada con ID: " + id);
                    return;
                }
            }

            System.out.println("No se encontró entidad con ID: " + id);

        } catch (IllegalArgumentException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
        }
    }

    // =========================
    // LISTAR
    // =========================
    @Override
    public Entidad[] listar() {

        int count = 0;
        for (Entidad e : entidades) {
            if (e != null) count++;
        }

        Entidad[] limpio = new Entidad[count];
        int j = 0;

        for (Entidad e : entidades) {
            if (e != null) limpio[j++] = e;
        }

        return limpio;
    }

    // =========================
    // SERIALIZAR
    // =========================
    @Override
    public String serializar(Entidad[] entidades, String path, String name) {

        try (FileOutputStream fos = new FileOutputStream(path + name);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(entidades);
            return "Archivo creado correctamente";

        } catch (IOException e) {
            return "Error al guardar: " + e.getMessage();
        }
    }

    // =========================
    // DESERIALIZAR
    // =========================
    @Override
    public Entidad[] deserializar(String path, String name) {

        Entidad[] datos = null;

        try (FileInputStream fis = new FileInputStream(path + name);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            datos = (Entidad[]) ois.readObject();

        } catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        }

        return datos;
    }
}
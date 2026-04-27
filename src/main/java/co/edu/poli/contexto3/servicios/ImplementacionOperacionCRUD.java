package co.edu.poli.contexto3.servicios;

import co.edu.poli.contexto3.modelo.Persona;
import java.io.*;

public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

    private Persona[] personaa = new Persona[2];

    public Persona[] getPersonas() {
        return this.personaa;
    }

    @Override
    public void crear(Persona p) {
        try {
            if (p == null) {
                throw new IllegalArgumentException("No se puede agregar un objeto null");
            }
            if (leer(p.getId()) != null) {
                throw new IllegalArgumentException("Ya existe una persona con ese ID");
            }

            for (int i = 0; i < personaa.length; i++) {
                if (personaa[i] == null) {
                    personaa[i] = p;
                    System.out.println("Persona agregada en posición " + i);
                    return;
                }
            }

            Persona[] nuevo = new Persona[personaa.length + 1];
            for (int i = 0; i < personaa.length; i++) {
                nuevo[i] = personaa[i];
            }
            nuevo[personaa.length] = p;
            personaa = nuevo;
            System.out.println("Arreglo expandido. Persona agregada en posición " + (personaa.length - 1));

        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear: " + e.getMessage());
        }
    }

    @Override
    public Persona leer(String id) {
        try {
            if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");

            for (Persona p : personaa) {
                if (p != null && p.getId().equals(id)) {
                    return p;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizar(String id, Persona nueva) {
        try {
            if (id == null || nueva == null) {
                throw new IllegalArgumentException("El ID y la persona no pueden ser nulos");
            }

            for (int i = 0; i < personaa.length; i++) {
                if (personaa[i] != null && personaa[i].getId().equals(id)) {
                    personaa[i] = nueva;
                    System.out.println("Persona actualizada con ID: " + id);
                    return;
                }
            }
            System.out.println("No se encontró persona con ID: " + id);

        } catch (IllegalArgumentException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(String id) {
        try {
            if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");

            for (int i = 0; i < personaa.length; i++) {
                if (personaa[i] != null && personaa[i].getId().equals(id)) {
                    personaa[i] = null;
                    System.out.println("Persona eliminada con ID: " + id);
                    return;
                }
            }
            System.out.println("No se encontró persona con ID: " + id);

        } catch (IllegalArgumentException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void listar() {
        try {
            System.out.println("\n--- LISTADO DE PERSONAS ---");
            for (int i = 0; i < personaa.length; i++) {
                if (personaa[i] != null) {
                    System.out.println("Posición " + i + ": " + personaa[i]);
                } else {
                    System.out.println("Posición " + i + ": vacío");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }

    @Override
    public String serializar(Persona[] personas, String path, String name) {
        try (FileOutputStream fos = new FileOutputStream(path + name);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(personas);
            return "Archivo creado correctamente";
        } catch (IOException e) {
            return "Error al guardar: " + e.getMessage();
        }
    }

    @Override
    public Persona[] deserializar(String path, String name) {
        Persona[] personas = null;
        try (FileInputStream fis = new FileInputStream(path + name);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            personas = (Persona[]) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        }
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personaa = personas;
    }
}
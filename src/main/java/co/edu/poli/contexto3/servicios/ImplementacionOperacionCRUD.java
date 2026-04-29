package co.edu.poli.contexto3.servicios;

import co.edu.poli.contexto3.modelo.Astronauta;
import co.edu.poli.contexto3.modelo.Cientifico;
import co.edu.poli.contexto3.modelo.Persona;
import java.io.*;

public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

    // ✅ Inicia vacío, crece dinámicamente
    private Persona[] personaa = new Persona[0];

    public Persona[] getPersonas() {
        return this.personaa;
    }

    public void setPersonas(Persona[] personas) {
        this.personaa = personas;
    }

    // ════════════════════════════════════════
    //  CREAR
    // ════════════════════════════════════════
    @Override
    public void crear(Persona p) {
        if (p == null)
            throw new IllegalArgumentException("No se puede agregar un objeto null");
        if (leer(p.getId()) != null)
            throw new IllegalArgumentException("Ya existe una persona con ese ID: " + p.getId());

        // Buscar espacio vacío (null) primero
        for (int i = 0; i < personaa.length; i++) {
            if (personaa[i] == null) {
                personaa[i] = p;
                return;
            }
        }

        // Si no hay espacio, crecer el arreglo
        Persona[] nuevo = new Persona[personaa.length + 1];
        for (int i = 0; i < personaa.length; i++) {
            nuevo[i] = personaa[i];
        }
        nuevo[personaa.length] = p;
        personaa = nuevo;
    }

    // ════════════════════════════════════════
    //  LEER / BUSCAR
    // ════════════════════════════════════════
    @Override
    public Persona leer(String id) {
        if (id == null)
            throw new IllegalArgumentException("El ID no puede ser nulo");
        for (Persona p : personaa) {
            if (p != null && p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    // ════════════════════════════════════════
    //  ACTUALIZAR
    // ════════════════════════════════════════
    @Override
    public void actualizar(String id, Persona nueva) {
        if (id == null || nueva == null)
            throw new IllegalArgumentException("El ID y la persona no pueden ser nulos");
        for (int i = 0; i < personaa.length; i++) {
            if (personaa[i] != null && personaa[i].getId().equals(id)) {
                personaa[i] = nueva;
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró persona con ID: " + id);
    }

    // ════════════════════════════════════════
    //  ELIMINAR
    // ════════════════════════════════════════
    @Override
    public void eliminar(String id) {
        if (id == null)
            throw new IllegalArgumentException("El ID no puede ser nulo");
        for (int i = 0; i < personaa.length; i++) {
            if (personaa[i] != null && personaa[i].getId().equals(id)) {
                personaa[i] = null;
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró persona con ID: " + id);
    }

    // ════════════════════════════════════════
    //  LISTAR (✅ ahora muestra tipo correctamente)
    // ════════════════════════════════════════
    public String listar() {
        StringBuilder resultado = new StringBuilder("\n--- LISTADO DE PERSONAS ---\n");
        int count = 0;
        for (Persona p : personaa) {
            if (p != null) {
                String tipo = (p instanceof Astronauta) ? "🚀 Astronauta" : "🔬 Científico";
                resultado.append(tipo).append(": ").append(p).append("\n");
                count++;
            }
        }
        if (count == 0) resultado.append("No hay personas registradas.\n");
        return resultado.toString();
    }

    // ════════════════════════════════════════
    //  SERIALIZAR
    // ════════════════════════════════════════
    @Override
    public String serializar(Persona[] personas, String path, String name) {
        try (FileOutputStream fos = new FileOutputStream(path + name);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(personas);
            return "Archivo guardado correctamente";
        } catch (IOException e) {
            return "Error al guardar: " + e.getMessage();
        }
    }

    // ════════════════════════════════════════
    //  DESERIALIZAR
    // ════════════════════════════════════════
    @Override
    public Persona[] deserializar(String path, String name) {
        try (FileInputStream fis = new FileInputStream(path + name);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Persona[]) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + name);
        } catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        }
        return null;
    }
}

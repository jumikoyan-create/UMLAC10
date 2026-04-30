package co.edu.poli.contexto3.modelo;

import java.io.Serializable;

public abstract class Entidad implements Serializable {

    protected String id;
    protected String nombre; // 🔥 NUEVO

    public Entidad() {}

    public Entidad(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // ================= GETTERS =================

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // ================= SETTERS =================

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

    // ================= MÉTODO ABSTRACTO =================

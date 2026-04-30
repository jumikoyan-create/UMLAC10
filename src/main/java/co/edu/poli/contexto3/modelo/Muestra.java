package co.edu.poli.contexto3.modelo;

public class Muestra extends Entidad {

    private String tipoMuestra;
    private int cantidad;
    private String material;
    private String estado;
    private String deDondeViene;
    private boolean esRadioactiva;
    private String fechaRecoleccion;
    private Suelo suelo;

    // 🔥 NUEVO (lo importante del contexto)
    private Astronauta recolector;
    private Cientifico analizador;

    public Muestra() {
        super();
    }

    public Muestra(String id, String nombre, String tipoMuestra,
                   Astronauta recolector, Cientifico analizador) {

        super(id, nombre); // 👈 usa el nombre del padre
        this.tipoMuestra = tipoMuestra;
        this.recolector = recolector;
        this.analizador = analizador;
    }

    // ================= GETTERS =================

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getMaterial() {
        return material;
    }

    public String getEstado() {
        return estado;
    }

    public String getDeDondeViene() {
        return deDondeViene;
    }

    public boolean isEsRadioactiva() {
        return esRadioactiva;
    }

    public String getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    public Suelo getSuelo() {
        return suelo;
    }

    public Astronauta getRecolector() {
        return recolector;
    }

    public Cientifico getAnalizador() {
        return analizador;
    }

    // ================= SETTERS =================

    public void setRecolector(Astronauta recolector) {
        this.recolector = recolector;
    }

    public void setAnalizador(Cientifico analizador) {
        this.analizador = analizador;
    }

    // ================= OTROS =================

    public void setTipoMuestra(String tipoMuestra) {
		this.tipoMuestra = tipoMuestra;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setDeDondeViene(String deDondeViene) {
		this.deDondeViene = deDondeViene;
	}

	public void setEsRadioactiva(boolean esRadioactiva) {
		this.esRadioactiva = esRadioactiva;
	}

	public void setFechaRecoleccion(String fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public void setSuelo(Suelo suelo) {
		this.suelo = suelo;
	}

    @Override
    public String toString() {
        return getNombre(); // 👈 importante
    }
}
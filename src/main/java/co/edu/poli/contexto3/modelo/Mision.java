package co.edu.poli.contexto3.modelo;

public class Mision extends Entidad {

    private String lugar;
    private int    fechadeinicio;
    private int    fechafinalizacion;
    private String objetivo;
    private String encargado;
    private String beneficio;
    private Planeta planeta;

    public Mision() { super(); }

    public Mision(String nombre, String id) {
        super(id, nombre); // ✅ Entidad(id, nombre)
    }

    // ── Getters / Setters ──────────────────────
    public String getLugar()                    { return lugar; }
    public void   setLugar(String lugar)        { this.lugar = lugar; }

    public int  getFechadeinicio()              { return fechadeinicio; }
    public void setFechadeinicio(int f)         { this.fechadeinicio = f; }

    public int  getFechafinalizacion()          { return fechafinalizacion; }
    public void setFechafinalizacion(int f)     { this.fechafinalizacion = f; }

    public String getObjetivo()                 { return objetivo; }
    public void   setObjetivo(String objetivo)  { this.objetivo = objetivo; }

    public String getEncargado()                { return encargado; }
    public void   setEncargado(String e)        { this.encargado = e; }

    public String getBeneficio()                { return beneficio; }
    public void   setBeneficio(String b)        { this.beneficio = b; }

    public Planeta getPlaneta()                 { return planeta; }
    public void    setPlaneta(Planeta planeta)  { this.planeta = planeta; }

    @Override
    public String toString() { return getNombre(); } // ✅ para ComboBox
}
package co.edu.poli.contexto3.modelo;

public class Nave extends Entidad {

    private String material;
    private String fechadecreacion;
    private double peso;
    private double tamanio;
    private double velocidad;
    private Mision     mision;
    private Robot      robot;
    private Astronauta[] astronauta;

    public Nave() { super(); }

    public Nave(String nombre, String id) {
        super(id, nombre); 
    }

    // ── Getters / Setters ──────────────────────
    public String getMaterial()                     { return material; }
    public void   setMaterial(String material)      { this.material = material; }

    public String getFechadecreacion()              { return fechadecreacion; }
    public void   setFechadecreacion(String f)      { this.fechadecreacion = f; }

    public double getPeso()                         { return peso; }
    public void   setPeso(double peso)              { this.peso = peso; }

    public double getTamanio()                      { return tamanio; }
    public void   setTamanio(double tamanio)        { this.tamanio = tamanio; }

    public double getVelocidad()                    { return velocidad; }
    public void   setVelocidad(double velocidad)    { this.velocidad = velocidad; }

    public Mision getMision()                       { return mision; }
    public void   setMision(Mision mision)          { this.mision = mision; }

    public Robot getRobot()                         { return robot; }
    public void  setRobot(Robot robot)              { this.robot = robot; }

    public Astronauta[] getAstronauta()             { return astronauta; }
    public void setAstronauta(Astronauta[] a)       { this.astronauta = a; }

    @Override
    public String toString() { return getNombre(); } 
}
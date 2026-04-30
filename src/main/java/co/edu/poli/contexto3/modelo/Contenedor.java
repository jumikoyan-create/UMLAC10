package co.edu.poli.contexto3.modelo;

public class Contenedor extends Entidad {

    private double  tamanio;
    private String  tipo;
    private String  marca;
    private boolean esterilizable;
    private boolean esdelicado;
    private Muestra muestra;

    public Contenedor() { super(); }

    public Contenedor(String nombre, String id) {
        super(id, nombre);
    }

    public double getTamanio()                      { return tamanio; }
    public void   setTamanio(double tamanio)        { this.tamanio = tamanio; }

    public String getTipo()                         { return tipo; }
    public void   setTipo(String tipo)              { this.tipo = tipo; }

    public String getMarca()                        { return marca; }
    public void   setMarca(String marca)            { this.marca = marca; }

    public boolean isEsterilizable()                { return esterilizable; }
    public void    setEsterilizable(boolean e)      { this.esterilizable = e; }

    public boolean isEsdelicado()                   { return esdelicado; }
    public void    setEsdelicado(boolean e)         { this.esdelicado = e; }

    public Muestra getMuestra()                     { return muestra; }
    public void    setMuestra(Muestra muestra)      { this.muestra = muestra; }

    @Override
    public String toString() { return getNombre(); }
}
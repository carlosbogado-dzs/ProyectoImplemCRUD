package vehiculo;

public abstract class Vehiculo {
    protected String id;
    protected String tipo;

    public Vehiculo(String id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo (String tipo) {
        this.tipo = tipo;
    }
    //El método abstacto obliga a las subclases a definir su movimiento//
    public abstract void patronMovimiento();

    @Override
    public String toString(){
        return String.format("ID: %s | Tipo: %s", id, tipo);
    }
}



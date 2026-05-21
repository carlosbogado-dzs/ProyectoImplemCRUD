package vehiculo;

public class DronTransporte extends Vehiculo implements IConectable{
    public DronTransporte(String id){
        super(id, "Dron");
    }
    @Override
    public void patronMovimiento(){
        System.out.println("El dron vuela en trayectorias aéreas.");
    }
    @Override
    public void sincronizarGPS(){
        System.out.println("Dron sincronizando con satélite...");
    }
}

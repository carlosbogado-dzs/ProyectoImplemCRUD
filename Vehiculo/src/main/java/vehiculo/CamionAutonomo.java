package vehiculo;

public class CamionAutonomo extends Vehiculo{
    public CamionAutonomo(String id){
        super(id, "Camion");
    }
    @Override
    public void patronMovimiento(){
        System.out.println("El camión circula por carreteras.");
    }
}

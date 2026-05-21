package vehiculo;

import java.util.*;
import java.util.stream.Collectors;

import vehiculo.IConectable;

public class GestionVehiculo {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    //implementación de CRUD
    public void crearVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    public void listarVehiculos() {
        vehiculos.forEach(System.out::println);
    }

    public Vehiculo buscarVehiculo(String id) {
        Optional<Vehiculo> resultado = vehiculos.stream()
                .filter(v -> v.getId().equalsIgnoreCase(id))
                .findFirst();
        return resultado.orElse(null);
    }

    public boolean modificarVehiculo(String id, String nuevoTipo) {
        Vehiculo v = buscarVehiculo(id);
        if (v != null) {
            v.setTipo(nuevoTipo);
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculo(String id) {
        return vehiculos.removeIf(v -> v.getId().equalsIgnoreCase(id));
    }

    //aplicando lambda y streams
    //metodo para filtrar conectables
    public List<Vehiculo> filtrarConectables() {
        return vehiculos.stream()
                .filter(v -> v instanceof IConectable)
                .collect(Collectors.toList());
    }

    //metodo para obtener IDs
    public List<String> obtenerIds() {
        return vehiculos.stream()
                .map(Vehiculo::getId)
                .collect(Collectors.toList());
    }

    //metodo para contar vehiculos
    public long contarVehiculos() {
        return vehiculos.stream().count();
    }

    // método para buscar por tipo
    public List<Vehiculo> buscarPorTipo(String tipo) {
        return vehiculos.stream()
                .filter(v -> v.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());

    }
    //metodo para ordenar por ID


    public List<Vehiculo> ordenarPorId() {
        return vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getId))
                .collect(Collectors.toList());
    }

    //metodo para ordenar por tipo
    public List<Vehiculo> ordenarPorTipo() {
        return vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getTipo))
                .collect(Collectors.toList());
    }

    //metodo para realizar reportes
    public void generarReporte() {
        System.out.println("==== REPORTE DE VEHICULOS ====");
        vehiculos.forEach(v ->
                System.out.println("ID: " + v.getId() + " | TIPO: " + v.getTipo()));
    }

    public Map<String, List<Vehiculo>> agruparPorTipo() {
        return vehiculos.stream().collect(Collectors.groupingBy(Vehiculo::getTipo));
    }
}


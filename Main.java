package Ubicación;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        //Creamos las ubicaciones
        Ubicacion ubicacion0 = new Ubicacion(0, "Estás sentado en la clase de programación.");
        Ubicacion ubicacion1 = new Ubicacion(1, "Estás en la cima de una montaña.");
        Ubicacion ubicacion2 = new Ubicacion(2, "Estás bañándote en la playa.");
        Ubicacion ubicacion3 = new Ubicacion(3, "Estás dentro de un edificio muy alto.");
        Ubicacion ubicacion4 = new Ubicacion(4, "Estás de pie en un puente.");
        Ubicacion ubicacion5 = new Ubicacion(5, "Estás en un bosque.");
        //Metemos las ubicaciones en el mapa
        ubicaciones.put(0, ubicacion0);
        ubicaciones.put(1, ubicacion1);
        ubicaciones.put(2, ubicacion2);
        ubicaciones.put(3, ubicacion3);
        ubicaciones.put(4, ubicacion4);
        ubicaciones.put(5, ubicacion5);
        //Creamos las salidas del mapa
        ubicacion1.addExit("N", 5);
        ubicacion1.addExit("S", 4);
        ubicacion1.addExit("E", 3);
        ubicacion1.addExit("W", 2);

        ubicacion2.addExit("N", 5);

        ubicacion3.addExit("W", 1);

        ubicacion4.addExit("N", 1);
        ubicacion4.addExit("W", 2);

        ubicacion5.addExit("S", 1);
        ubicacion5.addExit("W", 2);

        int ubicacionActual = 1;

        String Inicio = "";

        while (!Inicio.equalsIgnoreCase("Q")) {
            Ubicacion actual = ubicaciones.get(ubicacionActual);
            System.out.println(actual.getDescripcion());
            if (ubicacionActual != 0) {
                System.out.println("Tus salidas válidas son ");
                for (String direccion : actual.getExits().keySet()) {
                    System.out.print(direccion + ", ");
                }
                System.out.print("Q\n");

                Inicio = sc.nextLine().toUpperCase();
                if (Inicio.equalsIgnoreCase("Q")) {
                    actual= ubicaciones.get(0);
                    System.out.println(actual.getDescripcion());
                    System.out.println("El juega a terminado");
                }
                else if (actual.getExits().containsKey(Inicio)) {
                    ubicacionActual = actual.getExits().get(Inicio);

                    } else{
                    System.out.println("No puedes ir en esa dirección");
                }
                }
            }
            sc.close();
        }
    }
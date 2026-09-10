package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1 – Alta de producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Buscar producto");
            System.out.println("4 – Eliminar producto");
            System.out.println("5 – Salir");
            System.out.print("Elija opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1": 
                    System.out.print("Ingrese clave: ");
                    int clave = Integer.parseInt(sc.nextLine());

                    if (productos.containsKey(clave)) {
                        System.out.println("La clave ya existe.");
                        break;
                    }

                    System.out.println("Descripcion:"); 
                    String desc = sc.nextLine();
                
                    System.out.println("Precio:"); 
                    double precio = Double.parseDouble(sc.nextLine()); 
                    
                    System.out.println("Fecha de vencimiento yyyy-mm-dd:"); 
                    String fecha = sc.nextLine(); 

                    Producto p = new Producto(desc, precio, LocalDate.parse(fecha));
                    productos.put(clave, p);
                    System.out.println("Producto agregado.");
                    break;

                case "2":
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos.");
                        break;
                    }
                    Iterator<Map.Entry<Integer, Producto>> it = productos.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Producto> entry = it.next();
                        System.out.println("Clave: " + entry.getKey());
                        entry.getValue().mostrarDatos();
                        System.out.println("-------------------");
                    }
                    break;

                case "3": 
                    System.out.print("Clave a buscar: ");
                    int buscar = Integer.parseInt(sc.nextLine());
                    if (productos.containsKey(buscar)) {
                        System.out.println("Clave encontrada: " + buscar);
                        productos.get(buscar).mostrarDatos();
                    } else {
                        System.out.println("No existe esa clave.");
                    }
                    break;

                case "4": 
                    System.out.print("Clave a eliminar: ");
                    int borrar = Integer.parseInt(sc.nextLine());
                    if (productos.remove(borrar) != null) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("No existe esa clave.");
                    }
                    break;

                case "5":
                    salir = true;
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}

package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Empleado> empleados = new HashMap<>();

        int opcion;

        do {
            System.out.println("\n===== MENU EMPLEADOS =====");
            System.out.println("1 - Alta de empleado");
            System.out.println("2 - Mostrar empleados");
            System.out.println("3 - Eliminar empleado");
            System.out.println("4 - Consultar los datos de un empleado");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

            case 1:
                System.out.print("Ingrese DNI: ");
                String dni = sc.nextLine();

                System.out.print("Ingrese nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese apellido: ");
                String apellido = sc.nextLine();

                System.out.print("Ingrese sueldo: ");
                double sueldo = sc.nextDouble();
                sc.nextLine();

                System.out.print("Ingrese categoria: ");
                char categoria = sc.nextLine().charAt(0);

                String clave = dni + categoria;

                Empleado empleado = new Empleado(
                        dni, nombre, apellido, sueldo, categoria);

                empleados.put(clave, empleado);

                System.out.println("Empleado agregado correctamente.");
                break;

            case 2:
                Iterator<Map.Entry<String, Empleado>> iterator =
                        empleados.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry<String, Empleado> entrada = iterator.next();

                    System.out.println("Clave: " + entrada.getKey());
                    System.out.println("Valor: " + entrada.getValue());
                    System.out.println("--------------------");
                }
                break;

            case 3:
                System.out.print("Ingrese la clave: ");
                String claveEliminar = sc.nextLine();

                if (empleados.containsKey(claveEliminar)) {
                    empleados.remove(claveEliminar);
                    System.out.println("Empleado eliminado.");
                } else {
                    System.out.println("No se encuentra la clave.");
                }
                break;

            case 4:
                System.out.print("Ingrese la clave: ");
                String claveConsultar = sc.nextLine();

                if (empleados.containsKey(claveConsultar)) {
                    Empleado emp = empleados.get(claveConsultar);
                    System.out.println(emp);
                } else {
                    System.out.println("No se encuentra la clave.");
                }
                break;

            case 5:
                System.out.println("Programa finalizado.");
                break;

            default:
                System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
package ar.edu.unju.escmi.tp4.ejercicio4;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<Cliente> clientes = new HashSet<>();
        int op;

        do {
            System.out.println("---------------------Menu de Opciones---------------------");
            System.out.println("1- Crear cliente");
            System.out.println("2- Mostrar los datos de un cliente.");
            System.out.println("3- Mostrar todos los clientes.");
            System.out.println("4- Mostrar todos los clientes ocasionales y la cantidad.");
            System.out.println("5- Mostrar todos los clientes frecuentes y la cantidad.");
            System.out.println("6- Salir.");
            System.out.println("Seleccione una opcion:");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

            case 1: {
                System.out.println("Ingrese DNI:");
                int dni = sc.nextInt();
                sc.nextLine();

                System.out.println("Ingrese nombre:");
                String nombre = sc.nextLine();

                System.out.println("Ingrese tipo de cliente (ocasional/frecuente):");
                String tipo = sc.nextLine().toLowerCase();

                while (!tipo.equals("ocasional") && !tipo.equals("frecuente")) {
                    System.out.println("Tipo invalido. Intente nuevamente:");
                    tipo = sc.nextLine().toLowerCase();
                }

                Cliente cliente = new Cliente(dni, nombre, tipo);
                clientes.add(cliente);

                break;
            }

            case 2: {
                System.out.println("--- Datos de los clientes ---");

                clientes.stream().forEach(c -> {
                    System.out.println(c);
                });

                break;
            }

            case 3: {
                System.out.println("Ingrese DNI a buscar:");
                int dni = sc.nextInt();
                sc.nextLine();

                final boolean[] encontrado = { false };

                clientes.stream()
                        .filter(c -> c.getDni() == dni)
                        .forEach(c -> {
                            System.out.println(c);
                            encontrado[0] = true;
                        });

                if (!encontrado[0]) {
                    System.out.println("No se encontró el dni");
                }

                break;
            }

            case 4: {
                System.out.println("--- Clientes ocasionales ---");

                clientes.stream()
                        .filter(c -> c.getTipoCliente().equals("ocasional"))
                        .forEach(System.out::println);

                long cant = clientes.stream()
                        .filter(c -> c.getTipoCliente().equals("ocasional"))
                        .count();

                System.out.println("La cantidad de clientes ocasionales es: " + cant);

                break;
            }

            case 5: {
                System.out.println("--- Clientes frecuentes ---");

                clientes.stream()
                        .filter(c -> c.getTipoCliente().equals("frecuente"))
                        .forEach(System.out::println);

                long cant = clientes.stream()
                        .filter(c -> c.getTipoCliente().equals("frecuente"))
                        .count();

                System.out.println("La cantidad de clientes frecuentes es: " + cant);

                break;
            }

            case 6:
                System.out.println("Fin del programa");
                break;

            default:
                System.out.println("Opcion invalida");
                break;
            }

        } while (op != 6);

        sc.close();
    }
}
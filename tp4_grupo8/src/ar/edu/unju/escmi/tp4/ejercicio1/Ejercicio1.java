package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Jugador> jugadores=new ArrayList<>();
        int opcion;
        do {
            System.out.println("\n***** MENU DE JUGADORES *****");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Modificar los datos de un jugador");
            System.out.println("3 - Eliminar un jugador");
            System.out.println("4 - Mostrar todos los jugadores");
            System.out.println("5 - Mostrar la cantidad de jugadores en la lista");
            System.out.println("6 - Limpiar toda la lista de jugadores");
            System.out.println("7 - Salir");
            System.out.print("Elija una opcion: ");
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
            case 1: {
                Jugador jugador=new Jugador();
                int dni;
                System.out.print("Ingrese el DNI: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("El DNI solo puede contener numeros.");
                    scanner.nextLine();
                    System.out.print("Ingrese nuevamente el DNI: ");}
                dni=scanner.nextInt();
                scanner.nextLine();
                jugador.setDni(dni);
                String nombre;
                do {
                    System.out.print("Ingrese el nombre: ");
                    nombre=scanner.nextLine();
                    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        System.out.println("El nombre unicamente puede contener letras.");
                    }
                } while (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
                jugador.setNombre(nombre);
                System.out.print("Ingrese el equipo: ");
                jugador.setEquipo(scanner.nextLine());
                System.out.print("Ingrese la nacionalidad: ");
                jugador.setNacionalidad(scanner.nextLine());
                System.out.print("Ingrese la estatura (en metros): ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("La estatura solo puede contener numeros.");
                    scanner.nextLine();
                    System.out.print("Ingrese nuevamente la estatura: ");}
                jugador.setEstatura(scanner.nextDouble());
                scanner.nextLine();
                jugadores.add(jugador);
                System.out.println("Jugador creado correctamente.");
                break;
            }
            case 2: {
                int dniBuscado;
                System.out.print("Ingrese el DNI del jugador a modificar: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("El DNI solo puede contener numeros.");
                    scanner.nextLine();
                    System.out.print("Ingrese nuevamente el DNI: ");}
                dniBuscado=scanner.nextInt();
                scanner.nextLine();
                Jugador encontrado=null;
                for (Jugador j: jugadores) {
                    if (j.getDni()==dniBuscado) {
                        encontrado=j;
                        break;
                    }
                }
                if (encontrado!=null) {
                    System.out.println("Datos actuales del jugador:");
                    encontrado.mostrarDatos();
                    String nombre;
                    do {
                        System.out.print("Ingrese el nuevo nombre: ");
                        nombre=scanner.nextLine();
                        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                            System.out.println("El nombre unicamente puede contener letras.");
                        }
                    } while (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
                    encontrado.setNombre(nombre);
                    System.out.print("Ingrese el nuevo equipo: ");
                    encontrado.setEquipo(scanner.nextLine());
                    System.out.print("Ingrese la nueva nacionalidad: ");
                    encontrado.setNacionalidad(scanner.nextLine());
                    System.out.print("Ingrese la nueva estatura (en metros): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("La estatura solo puede contener numeros.");
                        scanner.nextLine();
                        System.out.print("Ingrese nuevamente la estatura: ");}
                    encontrado.setEstatura(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.println("Jugador modificado correctamente.");
                } else {
                    System.out.println("No se encuentra el dni");
                }
                break;
            }
            case 3: {
                int dniBuscado;
                System.out.print("Ingrese el DNI del jugador a eliminar: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("El DNI solo puede contener numeros.");
                    scanner.nextLine();
                    System.out.print("Ingrese nuevamente el DNI: ");}
                dniBuscado=scanner.nextInt();
                scanner.nextLine();
                Jugador encontrado=null;
                for (Jugador j: jugadores) {
                    if (j.getDni()==dniBuscado) {
                        encontrado=j;
                        break;
                    }
                }
                if (encontrado!=null) {
                    jugadores.remove(encontrado);
                    System.out.println("Jugador eliminado correctamente.");
                } else {
                    System.out.println("No se encuentra el dni");
                }
                break;
            }
            case 4: {
                if (jugadores.isEmpty()) {
                    System.out.println("No hay jugadores guardados.");
                } else {
                    for (Jugador j: jugadores) {
                        j.mostrarDatos();
                        System.out.println("--------------------------------------");
                    }
                }
                break;
            }
            case 5: {
                System.out.println("Cantidad de jugadores: "+jugadores.size());
                break;
            }
            case 6: {
                jugadores.clear();
                System.out.println("Lista de jugadores limpiada correctamente.");
                break;
            }
            case 7: {
                System.out.println("Programa finalizado.");
                break;
            }
            default: {
                System.out.println("Opcion no valida. Ingrese un numero del 1 al 7.");
            }
            }
        } while (opcion!=7);
        scanner.close();
    }
}
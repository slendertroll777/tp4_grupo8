package ar.edu.unju.escmi.tp4.ejercicio3;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeSet<Paciente> pacientes = new TreeSet<>();

        int opcion;

        do {
            System.out.println("\n===== MENU PACIENTES =====");
            System.out.println("1 - Alta de paciente");
            System.out.println("2 - Mostrar todos los pacientes");
            System.out.println("3 - Mostrar el paciente de la mitad");
            System.out.println("4 - Mostrar el primer paciente");
            System.out.println("5 - Mostrar el ultimo paciente");
            System.out.println("6 - Filtrar por historia clinica");
            System.out.println("7 - Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

            case 1:
                Paciente paciente = new Paciente();

                System.out.print("Ingrese DNI: ");
                paciente.setDni(sc.nextLine());

                System.out.print("Ingrese nombre: ");
                paciente.setNombre(sc.nextLine());

                System.out.print("Ingrese apellido: ");
                paciente.setApellido(sc.nextLine());

                System.out.print("Ingrese numero de historia clinica: ");
                paciente.setNumeroHistoriaClinica(sc.nextInt());
                sc.nextLine();

                System.out.print("Ingrese obra social: ");
                paciente.setObraSocial(sc.nextLine());

                pacientes.add(paciente);

                System.out.println("Paciente agregado correctamente.");
                break;

            case 2:
                pacientes.stream()
                        .forEach(p -> System.out.println(p));
                break;

            case 3:
                if (pacientes.isEmpty()) {
                    System.out.println("No hay pacientes.");
                } else {
                    int posicion = pacientes.size() / 2;

                    if (posicion == 0) {
                        posicion = 1;
                    }

                    Paciente mitad = pacientes.stream()
                            .skip(posicion - 1)
                            .findFirst()
                            .orElse(null);

                    System.out.println(mitad);
                }
                break;

            case 4:
                if (pacientes.isEmpty()) {
                    System.out.println("No hay pacientes.");
                } else {
                    System.out.println(pacientes.first());
                }
                break;

            case 5:
                if (pacientes.isEmpty()) {
                    System.out.println("No hay pacientes.");
                } else {
                    System.out.println(pacientes.last());
                }
                break;

            case 6:
                System.out.print("Ingrese numero de historia clinica: ");
                int historia = sc.nextInt();
                sc.nextLine();

                pacientes.stream()
                        .filter(p -> p.getNumeroHistoriaClinica() > historia)
                        .forEach(p -> System.out.println(p));
                break;

            case 7:
                System.out.println("Programa finalizado.");
                break;

            default:
                System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
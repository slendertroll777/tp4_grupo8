package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

class Jugador {
    private String dni;
    private String nombre;
    private String equipo;
    private String nacionalidad;
    private double estatura;

    public Jugador() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public void mostrarDatos() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Equipo: " + equipo);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Estatura: " + estatura + " m");
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        int op = 0;

        do {
            System.out.println("\n--- MENU DE OPCIONES ---");
            System.out.println("1 – Alta de jugador.");
            System.out.println("2 – Modificar los datos de un jugador.");
            System.out.println("3 – Eliminar un jugador.");
            System.out.println("4 – Mostrar todos los jugadores.");
            System.out.println("5 – Mostrar la cantidad de jugadores en la lista.");
            System.out.println("6 – Limpiar toda la lista de jugadores.");
            System.out.println("7 - Salir");
            System.out.print("Elija una opcion: ");

            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida. Ingrese un numero.");
                continue;
            }

            switch (op) {
                case 1:
                    Jugador nuevoJugador = new Jugador();

                    System.out.print("Ingrese DNI: ");
                    nuevoJugador.setDni(sc.nextLine());

                    System.out.print("Ingrese Nombre: ");
                    nuevoJugador.setNombre(sc.nextLine());

                    System.out.print("Ingrese Equipo: ");
                    nuevoJugador.setEquipo(sc.nextLine());

                    System.out.print("Ingrese Nacionalidad: ");
                    nuevoJugador.setNacionalidad(sc.nextLine());

                    System.out.print("Ingrese Estatura (ej. 1.85): ");
                    try {
                        nuevoJugador.setEstatura(Double.parseDouble(sc.nextLine()));
                    } catch (NumberFormatException e) {
                        nuevoJugador.setEstatura(0.0);
                        System.out.println("Error en el formato de estatura. Se guardo 0.0");
                    }

                    listaJugadores.add(nuevoJugador);
                    System.out.println("Jugador dado de alta.");
                    break;

                case 2:
                    System.out.print("Ingrese DNI del jugador a modificar: ");
                    String dniBuscar = sc.nextLine();
                    boolean encontradoMod = false;

                    for (Jugador j : listaJugadores) {
                        if (j.getDni().equals(dniBuscar)) {
                            encontradoMod = true;
                            System.out.println("--- Datos actuales ---");
                            j.mostrarDatos();

                            System.out.println("\nIngrese los nuevos datos:");
                            System.out.print("Nuevo Nombre: ");
                            j.setNombre(sc.nextLine());

                            System.out.print("Nuevo Equipo: ");
                            j.setEquipo(sc.nextLine());

                            System.out.print("Nueva Nacionalidad: ");
                            j.setNacionalidad(sc.nextLine());

                            System.out.print("Nueva Estatura: ");
                            try {
                                j.setEstatura(Double.parseDouble(sc.nextLine()));
                            } catch (NumberFormatException e) {
                                System.out.println("Formato incorrecto. Se mantiene la estatura anterior.");
                            }
                            System.out.println("Datos modificados.");
                            break;
                        }
                    }
                    if (!encontradoMod) {
                        System.out.println("No se encuentra el dni");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese DNI del jugador a eliminar: ");
                    String dniEliminar = sc.nextLine();
                    boolean encontradoElim = false;

                    for (int i = 0; i < listaJugadores.size(); i++) {
                        if (listaJugadores.get(i).getDni().equals(dniEliminar)) {
                            listaJugadores.remove(i);
                            encontradoElim = true;
                            System.out.println("Jugador eliminado.");
                            break;
                        }
                    }
                    if (!encontradoElim) {
                        System.out.println("No se encuentra el dni");
                    }
                    break;

                case 4:
                    if (listaJugadores.isEmpty()) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        System.out.println("--- LISTA DE JUGADORES ---");
                        for (Jugador j : listaJugadores) {
                            j.mostrarDatos();
                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Cantidad de jugadores en la lista: " + listaJugadores.size());
                    break;

                case 6:
                    listaJugadores.clear();
                    System.out.println("Toda la lista ha sido limpiada.");
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (op != 7);

        sc.close();
    }
}
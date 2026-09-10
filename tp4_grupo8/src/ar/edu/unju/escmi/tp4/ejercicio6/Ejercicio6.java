package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {

	private static int buscarPorIsbn(ArrayList<Libro> libros, String isbn) {

		for (int i = 0; i < libros.size(); i++) {

			if (libros.get(i).getIsbn().equalsIgnoreCase(isbn)) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Libro> libros = new ArrayList<>();

		int opcion;

		do {

			System.out.println();
			System.out.println("1 - Alta de Libro");
			System.out.println("2 - Mostrar libros");
			System.out.println("3 - Buscar y mostrar un libro");
			System.out.println("4 - Ordenar libros");
			System.out.println("5 - Modificar datos de un libro");
			System.out.println("6 - Eliminar un libro");
			System.out.println("7 - Salir");
			System.out.print("Seleccione una opcion: ");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {

			case 1:

				Libro libro = new Libro();

				System.out.print("Ingrese ISBN: ");
				libro.setIsbn(scanner.nextLine());

				System.out.print("Ingrese titulo: ");
				libro.setTitulo(scanner.nextLine());

				System.out.print("Ingrese cantidad de paginas: ");
				libro.setCantidadPaginas(scanner.nextInt());
				scanner.nextLine();

				System.out.print("Ingrese autor: ");
				libro.setAutor(scanner.nextLine());

				libros.add(libro);

				System.out.println("Libro agregado correctamente.");
				break;

			case 2:

				if (libros.isEmpty()) {

					System.out.println("No hay libros cargados.");

				} else {

					for (Libro l : libros) {
						l.mostrarDatos();
					}
				}

				break;

			case 3:

				System.out.print("Ingrese ISBN a buscar: ");
				String isbnBuscar = scanner.nextLine();

				int posicionBuscar = buscarPorIsbn(libros, isbnBuscar);

				if (posicionBuscar == -1) {

					System.out.println("Libro no encontrado.");

				} else {

					libros.get(posicionBuscar).mostrarDatos();
				}

				break;

			case 4:

				if (libros.isEmpty()) {

					System.out.println("No hay libros para ordenar.");

				} else {

					Collections.sort(libros);

					System.out.println("Libros ordenados por titulo.");
				}

				break;

			case 5:

				System.out.print("Ingrese ISBN del libro a modificar: ");
				String isbnModificar = scanner.nextLine();

				int posicionModificar = buscarPorIsbn(libros, isbnModificar);

				if (posicionModificar == -1) {

					System.out.println("Libro no encontrado.");

				} else {

					Libro libroModificar = libros.get(posicionModificar);

					System.out.println("Datos actuales:");
					libroModificar.mostrarDatos();

					System.out.print("Ingrese nuevo titulo: ");
					libroModificar.setTitulo(scanner.nextLine());

					System.out.print("Ingrese nueva cantidad de paginas: ");
					libroModificar.setCantidadPaginas(scanner.nextInt());
					scanner.nextLine();

					System.out.print("Ingrese nuevo autor: ");
					libroModificar.setAutor(scanner.nextLine());

					System.out.println("Libro modificado correctamente.");
				}

				break;

			case 6:

				System.out.print("Ingrese ISBN del libro a eliminar: ");
				String isbnEliminar = scanner.nextLine();

				int posicionEliminar = buscarPorIsbn(libros, isbnEliminar);

				if (posicionEliminar == -1) {

					System.out.println("Libro no encontrado.");

				} else {

					libros.remove(posicionEliminar);

					System.out.println("Libro eliminado correctamente.");
				}

				break;

			case 7:

				System.out.println("Saliendo...");
				break;

			default:

				System.out.println("Opcion invalida.");
			}

		} while (opcion != 7);

		scanner.close();
	}
}
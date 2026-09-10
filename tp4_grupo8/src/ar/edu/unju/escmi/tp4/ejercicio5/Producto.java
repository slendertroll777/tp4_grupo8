package ar.edu.unju.escmi.tp4.ejercicio5;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Producto {
    private String descripcion;
    private double precio;
    private LocalDate fechaVencimiento;

    // Constructor por defecto
        public Producto(String descripcion, double precio, LocalDate fechaVencimiento) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getters y setters que se usan en el main
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    // Método para mostrar datos
    public void mostrarDatos() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Fecha de vencimiento: " + 
            (fechaVencimiento != null ? fechaVencimiento.format(fmt) : "Sin fecha"));
    }

}
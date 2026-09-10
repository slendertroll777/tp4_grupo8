package ar.edu.unju.escmi.tp4.ejercicio4;

import java.util.Objects;

public class Cliente {
    private int dni;
    private String nombre;
    private String tipoCliente;
    
    public Cliente(int dni, String nombre, String tipoCliente) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public int getDni() {
        return dni;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", tipoCliente=" + tipoCliente + "]";
    }

    // AGREGADO: Necesario para el correcto funcionamiento dentro de un HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni == cliente.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}

package apicalendario.core.dto;

import java.time.LocalDate;

public class FestivoCalculadoDto {

    private String nombre;
    private LocalDate fecha;
    private String tipo;

    public FestivoCalculadoDto() {
    }

    public FestivoCalculadoDto(String nombre, LocalDate fecha, String tipo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
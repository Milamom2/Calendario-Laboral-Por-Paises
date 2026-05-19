package apicalendario.core.dominio;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "calendario")
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    public Calendario() {
    }

    public Calendario(Long id, LocalDate fecha, Integer anio, String descripcion, Pais pais) {
        this.id = id;
        this.fecha = fecha;
        this.anio = anio;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
package apicalendario.core.interfaces.servicios;

import java.time.LocalDate;
import java.util.List;

import apicalendario.core.dominio.Festivo;
import apicalendario.core.dto.FestivoCalculadoDto;

public interface IFestivoServicio {

    List<Festivo> listar();

    Festivo obtenerPorId(Long id);

    Festivo guardar(Festivo festivo);

    Festivo actualizar(Long id, Festivo festivo);

    void eliminar(Long id);

    List<Festivo> listarPorPais(Long idPais);

    boolean esFestivo(Long idPais, LocalDate fecha);

    List<FestivoCalculadoDto> listarFestivosPorPaisYAnio(Long idPais, int anio);
}
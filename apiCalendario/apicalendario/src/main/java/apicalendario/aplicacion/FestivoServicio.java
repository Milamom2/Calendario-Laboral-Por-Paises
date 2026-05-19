package apicalendario.aplicacion;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import apicalendario.core.dominio.Festivo;
import apicalendario.core.dto.FestivoCalculadoDto;
import apicalendario.core.interfaces.repositorios.FestivoRepositorio;
import apicalendario.core.interfaces.servicios.IFestivoServicio;
import apicalendario.core.util.PascuaUtil;

@Service
public class FestivoServicio implements IFestivoServicio {

    private final FestivoRepositorio repositorio;

    public FestivoServicio(FestivoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Festivo> listar() {
        return repositorio.findAll();
    }

    @Override
    public Festivo obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Festivo guardar(Festivo festivo) {
        return repositorio.save(festivo);
    }

    @Override
    public Festivo actualizar(Long id, Festivo festivo) {
        Festivo existente = repositorio.findById(id).orElse(null);

        if (existente != null) {
            existente.setNombre(festivo.getNombre());
            existente.setDia(festivo.getDia());
            existente.setMes(festivo.getMes());
            existente.setDiasPascua(festivo.getDiasPascua());
            existente.setPais(festivo.getPais());
            existente.setTipoFestivo(festivo.getTipoFestivo());
            return repositorio.save(existente);
        }

        return null;
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Festivo> listarPorPais(Long idPais) {
        return repositorio.findByPaisId(idPais);
    }

    // Método reutilizable para calcular la fecha de un festivo según su tipo
    public LocalDate calcularFechaFestivo(Festivo festivo, int anio) {
        String tipo = festivo.getTipoFestivo().getTipo().trim().toUpperCase();

        switch (tipo) {
           // Calcula festivos con fecha fija en el calendario
            case "FIJO":
                return LocalDate.of(anio, festivo.getMes(), festivo.getDia());

            case "PUENTE":
                return moverASiguienteLunes(
                        LocalDate.of(anio, festivo.getMes(), festivo.getDia())
                );

            case "PASCUA":
                return PascuaUtil.calcularDomingoPascua(anio)
                        .plusDays(festivo.getDiasPascua());

            case "PASCUA + PUENTE":
            case "PASCUA+PUENTE":
                return moverASiguienteLunes(
                        PascuaUtil.calcularDomingoPascua(anio)
                                .plusDays(festivo.getDiasPascua())
                );

            default:
                throw new RuntimeException("Tipo de festivo no soportado: " + tipo);
        }
    }

    private LocalDate moverASiguienteLunes(LocalDate fecha) {
        while (fecha.getDayOfWeek() != DayOfWeek.MONDAY) {
            fecha = fecha.plusDays(1);
        }
        return fecha;
    }

    @Override
    public boolean esFestivo(Long idPais, LocalDate fecha) {
        List<Festivo> festivos = repositorio.findByPaisId(idPais);

        for (Festivo festivo : festivos) {
            LocalDate calculada = calcularFechaFestivo(festivo, fecha.getYear());
            if (calculada.equals(fecha)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<FestivoCalculadoDto> listarFestivosPorPaisYAnio(Long idPais, int anio) {
        List<Festivo> festivos = repositorio.findByPaisId(idPais);
        List<FestivoCalculadoDto> respuesta = new ArrayList<>();

        for (Festivo festivo : festivos) {
            LocalDate fechaCalculada = calcularFechaFestivo(festivo, anio);
            respuesta.add(new FestivoCalculadoDto(
                    festivo.getNombre(),
                    fechaCalculada,
                    festivo.getTipoFestivo().getTipo()
            ));
        }

        respuesta.sort((a, b) -> a.getFecha().compareTo(b.getFecha()));
        return respuesta;
    }
}
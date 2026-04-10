package apicalendario.aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apicalendario.core.dominio.Festivo;
import apicalendario.core.interfaces.repositorios.FestivoRepositorio;
import apicalendario.core.interfaces.servicios.IFestivoServicio;

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
        Festivo festivoExistente = repositorio.findById(id).orElse(null);

        if (festivoExistente != null) {
            festivoExistente.setNombre(festivo.getNombre());
            festivoExistente.setDia(festivo.getDia());
            festivoExistente.setMes(festivo.getMes());
            festivoExistente.setDiasPascua(festivo.getDiasPascua());
            festivoExistente.setPais(festivo.getPais());
            festivoExistente.setTipoFestivo(festivo.getTipoFestivo());
            return repositorio.save(festivoExistente);
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
}
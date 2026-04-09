package apicalendario.aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apicalendario.core.dominio.TipoFestivo;
import apicalendario.core.interfaces.repositorios.TipoFestivoRepositorio;
import apicalendario.core.interfaces.servicios.ITipoFestivoServicio;

@Service
public class TipoFestivoServicio implements ITipoFestivoServicio {

    private final TipoFestivoRepositorio repositorio;

    public TipoFestivoServicio(TipoFestivoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<TipoFestivo> listar() {
        return repositorio.findAll();
    }

    @Override
    public TipoFestivo obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public TipoFestivo guardar(TipoFestivo tipoFestivo) {
        return repositorio.save(tipoFestivo);
    }

    @Override
    public TipoFestivo actualizar(Long id, TipoFestivo tipoFestivo) {
        TipoFestivo tipoExistente = repositorio.findById(id).orElse(null);

        if (tipoExistente != null) {
            tipoExistente.setTipo(tipoFestivo.getTipo());
            tipoExistente.setDescripcion(tipoFestivo.getDescripcion());
            return repositorio.save(tipoExistente);
        }

        return null;
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}

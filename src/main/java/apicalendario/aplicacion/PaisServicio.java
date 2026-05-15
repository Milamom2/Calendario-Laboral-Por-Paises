package apicalendario.aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apicalendario.core.dominio.Pais;
import apicalendario.core.interfaces.repositorios.PaisRepositorio;
import apicalendario.core.interfaces.servicios.IPaisServicio;

@Service
public class PaisServicio implements IPaisServicio {

    private final PaisRepositorio repositorio;

    public PaisServicio(PaisRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Pais> listar() {
        return repositorio.findAll();
    }

    @Override
    public Pais obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Pais guardar(Pais pais) {
        return repositorio.save(pais);
    }

    @Override
    public Pais actualizar(Long id, Pais pais) {
        Pais paisExistente = repositorio.findById(id).orElse(null);

        if (paisExistente != null) {
            paisExistente.setNombre(pais.getNombre());
            paisExistente.setCodigo(pais.getCodigo());
            return repositorio.save(paisExistente);
        }

        return null;
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
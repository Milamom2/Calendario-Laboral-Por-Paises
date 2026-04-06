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
}
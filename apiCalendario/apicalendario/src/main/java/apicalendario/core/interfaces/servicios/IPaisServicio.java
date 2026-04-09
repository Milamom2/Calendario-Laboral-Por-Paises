package apicalendario.core.interfaces.servicios;

import java.util.List;
import apicalendario.core.dominio.Pais;

public interface IPaisServicio {
    List<Pais> listar();
    Pais obtenerPorId(Long id);
    Pais guardar(Pais pais);
    Pais actualizar(Long id, Pais pais);
    void eliminar(Long id);
}
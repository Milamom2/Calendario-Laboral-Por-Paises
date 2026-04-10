package apicalendario.core.interfaces.servicios;

import java.util.List;
import apicalendario.core.dominio.TipoFestivo;

public interface ITipoFestivoServicio {
    List<TipoFestivo> listar();
    TipoFestivo obtenerPorId(Long id);
    TipoFestivo guardar(TipoFestivo tipoFestivo);
    TipoFestivo actualizar(Long id, TipoFestivo tipoFestivo);
    void eliminar(Long id);
}
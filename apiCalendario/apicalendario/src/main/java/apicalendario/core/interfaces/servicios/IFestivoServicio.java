package apicalendario.core.interfaces.servicios;

import java.util.List;
import apicalendario.core.dominio.Festivo;

public interface IFestivoServicio {
    List<Festivo> listar();
    Festivo obtenerPorId(Long id);
    Festivo guardar(Festivo festivo);
    Festivo actualizar(Long id, Festivo festivo);
    void eliminar(Long id);
    List<Festivo> listarPorPais(Long idPais);
}
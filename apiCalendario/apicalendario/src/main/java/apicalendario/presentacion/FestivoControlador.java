package apicalendario.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicalendario.core.dominio.Festivo;
import apicalendario.core.interfaces.servicios.IFestivoServicio;

@RestController
@RequestMapping("/festivos")
public class FestivoControlador {

    private final IFestivoServicio servicio;

    public FestivoControlador(IFestivoServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Festivo obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public Festivo guardar(@RequestBody Festivo festivo) {
        return servicio.guardar(festivo);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
    public Festivo actualizar(@PathVariable Long id, @RequestBody Festivo festivo) {
        return servicio.actualizar(id, festivo);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pais/{idPais}", method = RequestMethod.GET)
    public List<Festivo> listarPorPais(@PathVariable Long idPais) {
        return servicio.listarPorPais(idPais);
    }
}

package apicalendario.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicalendario.core.dominio.TipoFestivo;
import apicalendario.core.interfaces.servicios.ITipoFestivoServicio;

@RestController
@RequestMapping("/tiposfestivo")
public class TipoFestivoControlador {

    private final ITipoFestivoServicio servicio;

    public TipoFestivoControlador(ITipoFestivoServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<TipoFestivo> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TipoFestivo obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public TipoFestivo guardar(@RequestBody TipoFestivo tipoFestivo) {
        return servicio.guardar(tipoFestivo);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
    public TipoFestivo actualizar(@PathVariable Long id, @RequestBody TipoFestivo tipoFestivo) {
        return servicio.actualizar(id, tipoFestivo);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}

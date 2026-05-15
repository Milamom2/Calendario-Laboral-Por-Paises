package apicalendario.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicalendario.core.dominio.Pais;
import apicalendario.core.interfaces.servicios.IPaisServicio;

@RestController
@RequestMapping("/paises")
public class PaisControlador {

    private final IPaisServicio servicio;

    public PaisControlador(IPaisServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Pais> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pais obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public Pais guardar(@RequestBody Pais pais) {
        return servicio.guardar(pais);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
    public Pais actualizar(@PathVariable Long id, @RequestBody Pais pais) {
        return servicio.actualizar(id, pais);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
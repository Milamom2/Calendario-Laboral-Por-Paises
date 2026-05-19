package apicalendario.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicalendario.core.dominio.Calendario;

@Repository
public interface CalendarioRepositorio extends JpaRepository<Calendario, Long> {

}
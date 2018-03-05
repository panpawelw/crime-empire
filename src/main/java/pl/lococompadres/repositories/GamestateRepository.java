package pl.lococompadres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lococompadres.entities.Gamestate;

public interface GamestateRepository extends JpaRepository<Gamestate, Long> {
	Gamestate findById(long id);
}

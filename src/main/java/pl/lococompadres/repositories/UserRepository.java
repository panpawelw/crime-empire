package pl.lococompadres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lococompadres.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findFirstByUserName(String login);

}

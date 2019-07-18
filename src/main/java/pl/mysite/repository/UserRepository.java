package pl.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mysite.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByLogin(String login);
}

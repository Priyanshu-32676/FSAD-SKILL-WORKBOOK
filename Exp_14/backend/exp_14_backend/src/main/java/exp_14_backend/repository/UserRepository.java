package exp_14_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import exp_14_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
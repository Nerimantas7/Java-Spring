package lt.techin.ketvirtasblynas.repositories;

import lt.techin.ketvirtasblynas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

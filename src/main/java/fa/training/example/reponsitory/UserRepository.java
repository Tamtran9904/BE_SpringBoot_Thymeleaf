package fa.training.example.reponsitory;

import fa.training.example.entity.Fresher;
import fa.training.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByName(String name);
}

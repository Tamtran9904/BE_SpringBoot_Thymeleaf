package fa.training.example.reponsitory;

import fa.training.example.entity.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FresherRepository extends JpaRepository<Fresher, Integer> {

}

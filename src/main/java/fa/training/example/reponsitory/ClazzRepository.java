package fa.training.example.reponsitory;

import fa.training.example.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {

}

package fa.training.example.service;

import fa.training.example.entity.Clazz;
import java.util.List;
import org.springframework.data.domain.Page;

public interface ClazzService {

  List<Clazz> getAllClazz();

  Clazz saveClazz(Clazz clazzDto);

  Clazz updateClazzById(Clazz newClazz);

  Clazz getClazzById(Integer id);

  Boolean deleteClazzById(Integer id);

}

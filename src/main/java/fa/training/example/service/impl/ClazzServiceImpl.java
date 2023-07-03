package fa.training.example.service.impl;

import fa.training.example.entity.Clazz;
import fa.training.example.reponsitory.ClazzRepository;
import fa.training.example.service.ClazzService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClazzServiceImpl implements ClazzService {

  @Autowired
  private ClazzRepository clazzRepository;

  @Override
  public List<Clazz> getAllClazz() {
    return clazzRepository.findAll();
  }

  @Override
  public Clazz saveClazz(Clazz clazz) {
    return clazzRepository.save(clazz);
  }

  @Override
  public Clazz updateClazzById(Clazz newClazz) {
    Optional<Clazz> oldClazz = clazzRepository.findById(newClazz.getId());
    if (oldClazz.isPresent()) {
      return clazzRepository.save(newClazz);
    } else {
      return null;
    }
  }

  @Override
  public Clazz getClazzById(Integer id) {
    Optional<Clazz> clazz = clazzRepository.findById(id);
    if (clazz.isPresent()) {
      return clazz.get();
    } else {
      return null;
    }
  }

  @Override
  public Boolean deleteClazzById(Integer id) {
    Optional<Clazz> clazz = clazzRepository.findById(id);
    if (clazz.isPresent()) {
      clazzRepository.delete(clazz.get());
      return true;
    } else {
      return false;
    }
  }
}

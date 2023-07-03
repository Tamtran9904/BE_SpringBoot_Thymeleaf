package fa.training.example.service;

import fa.training.example.dto.FresherDto;
import fa.training.example.entity.Fresher;
import java.util.List;
import org.springframework.data.domain.Page;

public interface FresherService {
  List<FresherDto> getAllFresher();

  FresherDto saveFresher(FresherDto fresherDto);

  FresherDto updateFresherById(FresherDto newFresher);

  FresherDto getFresherById(Integer id);

  Boolean deleteFresherById(Integer id);

  Fresher convertToEntity(FresherDto fresherDto);

  FresherDto convertToDto(Fresher fresher);
}

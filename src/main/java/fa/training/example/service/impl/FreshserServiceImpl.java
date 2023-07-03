package fa.training.example.service.impl;

import fa.training.example.dto.FresherDto;
import fa.training.example.entity.Fresher;
import fa.training.example.reponsitory.FresherRepository;
import fa.training.example.service.FresherService;
import fa.training.example.util.LocalDateToStringConverter;
import fa.training.example.util.StringToLocalDateConverter;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreshserServiceImpl implements FresherService {

  @Autowired
  private FresherRepository fresherRepository;

  @Autowired
  private StringToLocalDateConverter stringToLocalDateConverter;

  @Autowired
  private LocalDateToStringConverter localDateToStringConverter;

  @Autowired
  private ModelMapper modelMapper;

  @PostConstruct
  public void init() {
    modelMapper.addConverter(stringToLocalDateConverter);
    modelMapper.addConverter(localDateToStringConverter);
  }

  @Override
  public List<FresherDto> getAllFresher() {
    List<FresherDto> ListDto = fresherRepository.findAll().stream().map(entity -> convertToDto(entity)).collect(Collectors.toList());
    return ListDto;
  }

  @Override
  public FresherDto saveFresher(FresherDto fresherDto) {
    Fresher fresher = convertToEntity(fresherDto);
    return convertToDto(fresherRepository.save(fresher));
  }

  @Override
  public FresherDto updateFresherById(FresherDto newFresher) {
    Optional<Fresher> oldFresher = fresherRepository.findById(newFresher.getId());
    if (oldFresher.isPresent()) {
      return convertToDto(fresherRepository.save(convertToEntity(newFresher)));
    } else {
      return null;
    }
  }

  @Override
  public FresherDto getFresherById(Integer id) {
    Optional<Fresher> fresher = fresherRepository.findById(id);
    if (fresher.isPresent()) {
      return convertToDto(fresher.get());
    } else {
      return null;
    }
  }

  @Override
  public Boolean deleteFresherById(Integer id) {
    Optional<Fresher> fresher = fresherRepository.findById(id);
    if (fresher.isPresent()) {
      fresherRepository.delete(fresher.get());
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Fresher convertToEntity(FresherDto fresherDto) {
    Fresher fresher = modelMapper.map(fresherDto, Fresher.class);
    return fresher;
  }

  @Override
  public FresherDto convertToDto(Fresher fresher) {
    FresherDto fresherDto = modelMapper.map(fresher, FresherDto.class);
    return fresherDto;
  }
}

package fa.training.example.controller;


import fa.training.example.entity.Clazz;
import fa.training.example.service.impl.ClazzServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example/clazz")
public class ClazzController {

  @Autowired
  private ClazzServiceImpl clazzService;

  @GetMapping("/find-all")
  public List<Clazz> findAll() {
    return clazzService.getAllClazz();
  }

  @PostMapping("/create")
  public Clazz create(@RequestBody Clazz Clazz) {
    return clazzService.saveClazz(Clazz);
  }

  @PutMapping("/update")
  public Clazz update(@RequestBody Clazz Clazz) {
    return clazzService.updateClazzById(Clazz);
  }

  @GetMapping("/read/{id}")
  public Clazz read(@PathVariable(value = "id") Integer id) {
    if (clazzService.getClazzById(id) != null) {
      return clazzService.getClazzById(id);
    } else {
      return null;
    }
  }
}

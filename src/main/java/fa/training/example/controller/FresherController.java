package fa.training.example.controller;

import fa.training.example.dto.FresherDto;
import fa.training.example.entity.User;
import fa.training.example.reponsitory.UserRepository;
import fa.training.example.service.impl.ClazzServiceImpl;
import fa.training.example.service.impl.FreshserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example/fresher")
public class FresherController {

  @Autowired
  private FreshserServiceImpl freshserService;

  @Autowired
  private ClazzServiceImpl clazzService;

  @Autowired
  private SecurityContextLogoutHandler securityContextLogoutHandler;

  @GetMapping("/find-all")
  public String findAll(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    model.addAttribute("userName", username);
    model.addAttribute("freshers", freshserService.getAllFresher());
    return "index";
  }

  @PostMapping("/create")
  public String create(FresherDto fresherDto) {
    freshserService.saveFresher(fresherDto);
    return "redirect:/example/fresher/find-all";
  }

  @PostMapping("/update")
  public String update(FresherDto fresherDtoOld) {
    freshserService.updateFresherById(fresherDtoOld);
    return "redirect:/example/fresher/find-all";
  }

  @GetMapping("/read/{id}")
  public FresherDto read(@PathVariable(value = "id") Integer id) {
    if (freshserService.getFresherById(id) != null) {
      return freshserService.getFresherById(id);
    }
    else {
      return null;
    }
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable(value = "id") Integer id) {
    freshserService.deleteFresherById(id);
    return "redirect:/example/fresher/find-all";
  }
  @GetMapping("/add")
  public String showAddFresher(Model model) {
    model.addAttribute("fresherDto", new FresherDto());
    model.addAttribute("classList", clazzService.getAllClazz());
    return "add";
  }
  @GetMapping("/showUpdate/{id}")
  public String showUpdateFresher(@PathVariable(value = "id") Integer id,Model model) {
    model.addAttribute("fresherDtoOld", freshserService.getFresherById(id));
    model.addAttribute("classList", clazzService.getAllClazz());
    return "update";
  }
  @GetMapping("/login")
  public String login(){
    return "login";
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      securityContextLogoutHandler.logout(request, response, authentication);
    }
    return "redirect:/example/fresher/login";
  }
}

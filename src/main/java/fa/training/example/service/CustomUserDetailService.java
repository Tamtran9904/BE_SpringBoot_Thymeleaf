package fa.training.example.service;

import fa.training.example.entity.User;
import fa.training.example.reponsitory.UserRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByName(username);
    GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
    if (user != null) {
      return new org.springframework.security.core.userdetails.User(user.getName(),
          passwordEncoder.encode(user.getPassword()), Collections.singletonList(authority));
    }
    return null;
  }

}

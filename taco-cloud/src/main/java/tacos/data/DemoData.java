package tacos.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import tacos.Authorities;
import tacos.Users;

@Component
public class DemoData {
  @Autowired
  private UsersRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @EventListener
  public void appReady(ApplicationReadyEvent event) {
	String password = "bhagwat";
	String username = "ganesh";
	
	Users user = new Users();
	user.setEnabled(true);
	user.setUsername(username);
	user.setPassword(passwordEncoder.encode(password));
	
	List<Authorities> listOfAuthorities = new ArrayList<>();
	Authorities auth1 = new Authorities(username, "ROLE_USER");
	Authorities auth2 = new Authorities(username, "ROLE_ADMIN");
	listOfAuthorities.add(auth1);
	user.getAuthorities().add(auth1);
	user.getAuthorities().add(auth2);	
	userRepository.save(user);
  }
}
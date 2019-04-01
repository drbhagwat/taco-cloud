package tacos.data;

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

	userRepository.save(new Users(username, passwordEncoder.encode(password), true,
		new Authorities(username, "ROLE_USER"), new Authorities(username, "ROLE_ADMIN")));
  }
}
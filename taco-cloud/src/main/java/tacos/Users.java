package tacos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Users {
  @Id
  @NonNull
  private String username;

  @NonNull
  private String password;

  private boolean enabled;

  @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
  private List<Authorities> authorities = new ArrayList<>();

  public Users(String username, String password, boolean enabled, Authorities... authorities) {
	this.username = username;
	this.password = password;
	this.enabled = enabled;
	this.authorities = Stream.of(authorities).collect(Collectors.toList());
	this.authorities.forEach(x -> x.setUsers(this));
  }
}
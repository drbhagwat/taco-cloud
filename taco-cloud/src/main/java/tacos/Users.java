package tacos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

  private boolean enabled = true;

  @OneToMany(/* mappedBy = "users", */cascade = CascadeType.ALL)
  @JoinColumn(name="username")
  private List<Authorities> authorities = new ArrayList<>(); 

  /*
   * public Users(String username, String password, Authorities... authorities) {
   * this.username = username; this.authorities =
   * Stream.of(authorities).collect(Collectors.toList());
   * this.authorities.forEach(x -> x.setUsers(this)); }
   */
}
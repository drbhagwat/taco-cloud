package tacos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Authorities {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  @NonNull
  private String username;

  @NonNull
  private String authority;
}
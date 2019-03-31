package tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
}
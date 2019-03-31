package tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
}
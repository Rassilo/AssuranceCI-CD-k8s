package pfe.micro.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

import pfe.micro.auth.model.Role;
import pfe.micro.auth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public User findByUserNameAndPassword(String userName, String password);
    public User findByUserName(String username);
    public User findUserById(Integer id);
    Set<User> findByRole(Role role);
    

}

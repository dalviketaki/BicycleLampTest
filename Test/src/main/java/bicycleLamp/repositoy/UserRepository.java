package bicycleLamp.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import bicycleLamp.dto.UserDataDTO;
import bicycleLamp.model.User;


public interface UserRepository extends JpaRepository<UserDataDTO, Integer> {

  User findByUserName(String userName);
  
  User saveUser(UserDataDTO userDataDTO);
  
  User updateUser(UserDataDTO userDataDTO);

} 
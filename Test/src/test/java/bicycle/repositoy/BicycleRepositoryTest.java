package bicycle.repositoy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import bicycleLamp.dto.UserDataDTO;
import bicycleLamp.model.User;
import bicycleLamp.repositoy.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BicycleRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void testFindByUserName() {
		User user = repository.findByUserName("KETAKI");
		assertEquals("KETAKI",user.getUsername());
	}

	@Test
	public void testSaveUser() {
		UserDataDTO userDataDTO = new UserDataDTO();
		userDataDTO.setUsername("KETAKI");
		userDataDTO.setBicycleId(1);
		userDataDTO.setEmail("KETAKI080990@GMAILCOM");
		userDataDTO.setIsLampFlash(Boolean.FALSE);
		userDataDTO.setLampColour("RED");
		userDataDTO.setLampCount(1);
		userDataDTO.setLampStatus("ON");
		
		User user = repository.saveUser(userDataDTO);
		
		assertEquals("KETAKI",user.getUsername());
	}

}
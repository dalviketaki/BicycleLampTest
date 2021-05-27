package bicycleLamp.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bicycleLamp.dto.UserDataDTO;
import bicycleLamp.model.User;
import bicycleLamp.payload.RequestPayload;
import bicycleLamp.repositoy.UserRepository;

@Service
public class BicycleService {

	@Autowired
	private UserRepository userRepository;

	private Integer button1Counter = 0;

	public User ButtonOneLogic(RequestPayload requestPayload) {
		User user = userRepository.findByUserName(requestPayload.getUsername());
		UserDataDTO userDataDTO = new UserDataDTO();
		if (user == null) {
			userDataDTO.setBicycleId(1);
			userDataDTO.setEmail(requestPayload.getEmail());
			userDataDTO.setUsername(requestPayload.getUsername());
			userDataDTO.setIsLampFlash(Boolean.FALSE);
			userDataDTO.setLampColour("RED");
			userDataDTO.setLampCount(1);
			userDataDTO.setLampStatus("ON");

			user = userRepository.saveUser(userDataDTO);
			redOn();
			// Calling redOn() API for Red
		} else {
			if (button1Counter == 0) {
				button1Counter++;
				userDataDTO.setBicycleId(1);
				userDataDTO.setEmail(requestPayload.getEmail());
				userDataDTO.setUsername(requestPayload.getUsername());
				userDataDTO.setIsLampFlash(Boolean.FALSE);
				userDataDTO.setLampColour("RED");
				userDataDTO.setLampCount(1);
				userDataDTO.setLampStatus("ON");
				user = userRepository.updateUser(userDataDTO);
				redOn();
				// Calling redOn() API for Red
			} else if (button1Counter == 1) {
				button1Counter++;
				userDataDTO.setBicycleId(1);
				userDataDTO.setEmail(requestPayload.getEmail());
				userDataDTO.setUsername(requestPayload.getUsername());
				userDataDTO.setIsLampFlash(Boolean.FALSE);
				userDataDTO.setLampColour("REDFLASH");
				userDataDTO.setLampCount(2);
				userDataDTO.setLampStatus("ON");
				user = userRepository.updateUser(userDataDTO);
				redFlash();
				// Calling redOn() API for Red
			} else if (button1Counter == 2) {
				button1Counter++;
				userDataDTO.setBicycleId(1);
				userDataDTO.setEmail(requestPayload.getEmail());
				userDataDTO.setUsername(requestPayload.getUsername());
				userDataDTO.setIsLampFlash(Boolean.TRUE);
				userDataDTO.setLampColour("WHITE");
				userDataDTO.setLampCount(2);
				userDataDTO.setLampStatus("OFF");
				user = userRepository.updateUser(userDataDTO);
				ledOff();
				// Calling redOn() API for Red
			}

		}
		return user;

	}

	public User ButtonTwoLogic(RequestPayload requestPayload) {
		User user = userRepository.findByUserName(requestPayload.getUsername());
		UserDataDTO userDataDTO = new UserDataDTO();
		if (user == null || user.getBicycle().getLampStatus() == "OFF") {
			// no tasks
			// Calling redOn() API for Red
		} else {
			if (user.getBicycle().getLampColour() == "WHITE") {
				userDataDTO.setLampColour("RED");
				redOn();
				// Calling redOn() API for Red
			} else if (user.getBicycle().getLampColour() == "RED") {
				userDataDTO.setLampColour("RED");
				whiteOn();
				// Calling redOn() API for Red
			}

		}
		return user;

	}

	// APIS
	private void redOn() {
	}

	private void whiteOn() {

	}

	private void ledOff() {

	}

	private void redFlash() {

	}

	private void WhiteFlash() {

	}

}
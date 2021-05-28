package bicycleLamp.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.sjavac.Log;

import bicycleLamp.dto.UserDataDTO;
import bicycleLamp.model.User;
import bicycleLamp.payload.RequestPayload;
import bicycleLamp.repositoy.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BicycleService {
	
	public enum Colours{
		  RED, 
		  WHITE
	}

	@Autowired
	private UserRepository userRepository;

	private Integer button1Counter = 0;
	
	private Colours colours;

	public User ButtonOneLogic(RequestPayload requestPayload) {
		Log.info("Logic first button one");
		
		Log.info("Searching use if there is previous recod present");
		User user = userRepository.findByUserName(requestPayload.getUsername());
		UserDataDTO userDataDTO = new UserDataDTO();
		if (user == null) {
			userDataDTO.setBicycleId(1);
			userDataDTO.setEmail(requestPayload.getEmail());
			userDataDTO.setUsername(requestPayload.getUsername());
			userDataDTO.setIsLampFlash(Boolean.FALSE);
			userDataDTO.setLampColour((colours.RED).toString());
			userDataDTO.setLampCount(1);
			userDataDTO.setLampStatus("ON");

			user = userRepository.saveUser(userDataDTO);
			redOn();
			// Calling redOn() API for Red
		} else {
			if (requestPayload.getButtonClicks() == 1) {
				button1Counter++;
				userDataDTO.setBicycleId(1);
				userDataDTO.setEmail(requestPayload.getEmail());
				userDataDTO.setUsername(requestPayload.getUsername());
				userDataDTO.setIsLampFlash(Boolean.FALSE);
				userDataDTO.setLampColour((colours.RED).toString());
				userDataDTO.setLampCount(1);
				userDataDTO.setLampStatus("ON");
				user = userRepository.updateUser(userDataDTO);
				redOn();
				// Calling redOn() API for Red
			} else if (requestPayload.getButtonClicks() == 2) {
				button1Counter++;
				userDataDTO.setIsLampFlash(Boolean.FALSE);
				userDataDTO.setLampColour((colours.RED).toString());
				userDataDTO.setLampCount(2);
				userDataDTO.setLampStatus("ON");
				user = userRepository.updateUser(userDataDTO);
				redFlash();
				// Calling redOn() API for Red
			} else if (requestPayload.getButtonClicks() == 3) {
				button1Counter++;
				userDataDTO.setIsLampFlash(Boolean.TRUE);
				userDataDTO.setLampColour((colours.WHITE).toString());
				userDataDTO.setLampCount(0);
				userDataDTO.setLampStatus("OFF");
				user = userRepository.updateUser(userDataDTO);
				ledOff();
				// Calling redOn() API for Red
			}

		}
		return user;

	}

	public User ButtonTwoLogic(RequestPayload requestPayload) {
		Log.info("Logic Second button one");
		
		User user = userRepository.findByUserName(requestPayload.getUsername());
		UserDataDTO userDataDTO = new UserDataDTO();
		if (user == null || user.getBicycle().getLampStatus() == "OFF") {
			userDataDTO.setBicycleId(1);
			userDataDTO.setEmail(requestPayload.getEmail());
			userDataDTO.setUsername(requestPayload.getUsername());
			userDataDTO.setLampStatus("OFF");
		} else {
			if (user.getBicycle().getLampColour() == "WHITE") {
				userDataDTO.setLampColour("RED");
				redOn();
				// Calling redOn() API for Red
			} else if (user.getBicycle().getLampColour() == "RED") {
				userDataDTO.setLampColour("RED");
				whiteOn();
				// Calling whiteOn() API 
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
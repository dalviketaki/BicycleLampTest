package bicycleLamp.contoller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.sjavac.Log;

import bicycleLamp.model.User;
import bicycleLamp.payload.RequestPayload;
import bicycleLamp.security.JwtUtils;
import bicycleLamp.security.UserDetailsImpl;
import bicycleLamp.sevice.BicycleService;
import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Slf4j
public class BicycleController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	BicycleService bicycleService;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/bicycleLampPostStatus/ButtonOne")
	public User ButtonOneLogic(@Valid @RequestBody RequestPayload requestPayload) {
		
		Log.info("Logic first button one and customer is authenticated");

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(requestPayload.getUsername(), requestPayload.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		Log.info("Sevice layer is called");
		return bicycleService.ButtonOneLogic(requestPayload);
	}
	
	@PostMapping("/bicycleLampPostStatus/ButtonTwo")
	public User ButtonTwoLogic(@Valid @RequestBody RequestPayload requestPayload) {

		Log.info("Logic first button two and customer is authenticated");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(requestPayload.getUsername(), requestPayload.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		Log.info("Sevice layer is called");
		return bicycleService.ButtonTwoLogic(requestPayload);
	}
}
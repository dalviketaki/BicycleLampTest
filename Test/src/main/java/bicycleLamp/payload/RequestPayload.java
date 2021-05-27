package bicycleLamp.payload;

import javax.validation.constraints.NotBlank;

public class RequestPayload {
	@NotBlank
	private String username;

	@NotBlank
	private String password;
	
	@NotBlank
	private String email;
	
	private Integer buttonClicks;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getButtonClicks() {
		return buttonClicks;
	}

	public void setButtonClicks(Integer buttonClicks) {
		this.buttonClicks = buttonClicks;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

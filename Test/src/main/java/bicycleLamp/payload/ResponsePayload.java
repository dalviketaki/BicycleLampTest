package bicycleLamp.payload;

public class ResponsePayload {
	private Integer id;
	private String username;
	private String email;
	private String lampPostStatus;
	private String lampPostColour;
	private String message;
	
	public ResponsePayload(Integer id, String username, String email, String lampPostStatus, String lampPostColour, String message) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.lampPostStatus = lampPostStatus;
		this.lampPostColour = lampPostColour;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLampPostStatus() {
		return lampPostStatus;
	}

	public void setLampPostStatus(String lampPostStatus) {
		this.lampPostStatus = lampPostStatus;
	}

	public String getLampPostColour() {
		return lampPostColour;
	}

	public void setLampPostColour(String lampPostColour) {
		this.lampPostColour = lampPostColour;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
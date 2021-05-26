package bicycleLamp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bicycle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String lampStatus;

	private String lampColour;

	private Integer lampCount;

	private Boolean isLampFlash;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLampStatus() {
		return lampStatus;
	}

	public void setLampStatus(String lampStatus) {
		this.lampStatus = lampStatus;
	}

	public String getLampColour() {
		return lampColour;
	}

	public void setLampColour(String lampColour) {
		this.lampColour = lampColour;
	}

	public Integer getLampCount() {
		return lampCount;
	}

	public void setLampCount(Integer lampCount) {
		this.lampCount = lampCount;
	}

	public Boolean getIsLampFlash() {
		return isLampFlash;
	}

	public void setIsLampFlash(Boolean isLampFlash) {
		this.isLampFlash = isLampFlash;
	}

}
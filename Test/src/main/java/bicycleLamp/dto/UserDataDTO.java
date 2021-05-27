package bicycleLamp.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserDataDTO {
  
  @ApiModelProperty(position = 0)
  private String username;
  @ApiModelProperty(position = 1)
  private String email;
  @ApiModelProperty(position = 2)
  private Integer bicycleId;
  @ApiModelProperty(position = 3)
  private String lampStatus;
  @ApiModelProperty(position = 4)
  private String lampColour;
  @ApiModelProperty(position = 5)
  private Integer lampCount;
  @ApiModelProperty(position = 6)
  private Boolean isLampFlash;

  
  
  public Integer getBicycleId() {
	return bicycleId;
}

public void setBicycleId(Integer bicycleId) {
	this.bicycleId = bicycleId;
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
}
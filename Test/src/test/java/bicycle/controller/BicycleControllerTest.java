package bicycle.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import bicycleLamp.contoller.BicycleController;
import bicycleLamp.model.Bicycle;
import bicycleLamp.model.User;
import bicycleLamp.sevice.BicycleService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = BicycleController.class)
@WithMockUser
public class BicycleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BicycleService bicycleService;

	@Test
	public void ButtonOneLogic() throws Exception {
		
		User user = new User();
		Bicycle bicycle = new Bicycle();
		bicycle.setId(1);bicycle.setIsLampFlash(Boolean.FALSE);
		bicycle.setLampColour("RED");bicycle.setLampCount(1);
		bicycle.setLampStatus("ON");
		user.setId(1);user.setUsername("KETAKI");user.setPassword("12345");
		user.setEmail("KETAKI080990@GMAIL.COM");user.setBicycle(bicycle);

		Mockito.when(
				bicycleService.ButtonOneLogic(Mockito.any())).thenReturn(user);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/bicycleLampPostStatus/ButtonOne")
				.accept(MediaType.APPLICATION_JSON).content(user.toString())
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		JSONAssert.assertEquals(user.toString(), result.getResponse()
				.getContentAsString(), false);
	}

}

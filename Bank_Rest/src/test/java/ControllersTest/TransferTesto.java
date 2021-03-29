package ControllersTest;


import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Transfer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransferTesto {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@org.junit.Test
	public void addUserTest() throws Exception {
	//this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	
	Transfer user = new Transfer(1, 200);

	
	String JsonRequest = objectMapper.writeValueAsString(user);
	
	 mockMvc.perform(post("/transfers").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk());
	
//	String resultContext = result.getResponse().getContentAsString();
	
//	Transfer response = objectMapper.readValue(resultContext, Transfer.class);
	
//	assertEquals(1, response.getId());;
		
	}


}

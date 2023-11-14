package com.m01libDEN.ForAnInternship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ForAnInternshipApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void DefaultMessage() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("")));
	}

	@Test
	void OneCharMessage() throws Exception {
		this.mockMvc.perform(get("/?string=a"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("\"a\" : 1")));
	}

	@Test
	void MessageFromTQ() throws Exception {
		this.mockMvc.perform(get("/?string=aaaaabcccc"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("\"a\" : 5, \"c\" : 4, \"b\" : 1")));
	}

}

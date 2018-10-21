package com.example.samplerestsv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;

import com.example.samplerestsv.app.SampleResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleRestSvApplicationTests {
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	private RestOperations restOperations;

	private static final String BASE_URI = "http://localhost:8080/api/sample/";

	@Before
	public void setUp() {
		restOperations = restTemplateBuilder.build();
	}

	@Test
	public void contextLoads() throws URISyntaxException {

		URI url = new URI(BASE_URI + "user/1");

		SampleResource sr = restOperations.getForObject(url, SampleResource.class);

		assertThat(sr.getMessage(), is("Taro is 21 years old."));
	}

}

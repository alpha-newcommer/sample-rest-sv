package com.example.samplerestsv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
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
	
	@Value("${host.address}")
	private String hostAddr;
	
	private RestOperations restOperations;

	private String baseUrl;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		SpringApplication.run(SampleRestSvApplication.class, new String[] {});
	}

	@Before
	public void setUp() {
		restOperations = restTemplateBuilder.build();
		baseUrl = "http://" + hostAddr + "/api/sample/";
	}
	
	@Test
	public void testHello() throws URISyntaxException {
		URI url = new URI(baseUrl + "hello");
		
		SampleResource sr = restOperations.getForObject(url, SampleResource.class);

		assertThat(sr.getMessage(), is("hello world"));
	}

	@Test
	public void testUser() throws URISyntaxException {

		URI url = new URI(baseUrl + "user/1");

		SampleResource sr = restOperations.getForObject(url, SampleResource.class);

		assertThat(sr.getMessage(), is("kojiro is 20 years old."));
	}

}

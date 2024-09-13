package com.sudjoao.screenmatch;

import com.sudjoao.screenmatch.models.SerieDataOMBDDTO;
import com.sudjoao.screenmatch.services.OMBDApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SerieDataOMBDDTO serieDataOMBDDTO = OMBDApiService.getSerie("lost");
		System.out.println(serieDataOMBDDTO);
	}
}

package pl.kz.championshipsfootballapp;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import de.codecentric.boot.admin.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class ChampionshipsFootballAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChampionshipsFootballAppApplication.class, args);
	}
}

package rc.persistence;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import rc.domain.Hotel;

@Component
public class DbSeeder implements CommandLineRunner {
	@Autowired
	private HotelRepository hotelRepository;

	// if I have a constructor, i dont have to add @Autowired starting spring 1.4

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("EJECUCION COMPONENT ");
		Hotel marriot = new Hotel("Marriot", 5, true);
		Hotel ibis = new Hotel("Ibis", 3, false);
		Hotel goldenTulip = new Hotel("Golden Tulip", 4, true);

		List<Hotel> hotels = Arrays.asList(marriot, ibis, goldenTulip);
		hotelRepository.saveAll(hotels);

	}

}

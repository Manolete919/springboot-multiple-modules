package rc.web;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import rc.domain.Hotel;
import rc.persistence.HotelRepository;

@Controller
public class HotelController {

	private HotelRepository hotelRepository;

	// with this it is not necessary to add @Autorwired, since Spring 1.4
	public HotelController(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	// @RequestMapping(value = "/hotels",method = RequestMethod.GET)
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getHotels() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("message", "OK");
		List<Hotel> hotels = this.hotelRepository.findAll();
		return new ResponseEntity<List<Hotel>>(hotels, responseHeaders, HttpStatus.OK);
	}

}

package de.rwth.idsg.steve.WaBu;

import de.rwth.idsg.steve.repository.ReservationRepository;
import de.rwth.idsg.steve.repository.UserRepository;
import de.rwth.idsg.steve.repository.dto.InsertReservationParams;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/newreservation_2")

public class RestController_1_main {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{idTag}/{chargeBoxId}/{connectorId}/{starttime}/{expirytime}/")
    //IDEE: id in parmas-dummy legen und diesen als Paramter verwenden
    public void writeReservation(@PathVariable String idTag,
                                 @PathVariable String chargeBoxId,
                                 @PathVariable String connectorId) {

        DateTimeFormatter pattern = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

        InsertReservationParams test_params = new InsertReservationParams(
                idTag,
                chargeBoxId,
                99,
                DateTime.parse("04/02/2011 20:27:05", pattern),
                DateTime.parse("04/02/2011 20:27:05", pattern));

        reservationRepository.insert(test_params);
    }

    @GetMapping("/{test}")

    public String testcmd(){
        String testcmd = "Test erfolgreich";
        return testcmd;

    }



    //TODO: test methode schreiben
    //TODO: WaBu DateTime-Translator
}


//https://www.baeldung.com/spring-request-param
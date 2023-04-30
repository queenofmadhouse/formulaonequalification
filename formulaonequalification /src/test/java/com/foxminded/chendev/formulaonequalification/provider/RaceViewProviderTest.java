package com.foxminded.chendev.formulaonequalification.provider;

import com.foxminded.chendev.formulaonequalification.entity.Racer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceViewProviderTest {

    private RaceViewProvider raceViewProvider;

    @BeforeEach
    void setUp() {
        raceViewProvider = new RaceViewProvider();
    }

    @Test
    void testProvideView() {
        Set<Racer> racers = new TreeSet<>();

        racers.add(Racer.builder()
                .withRacerName("Sebastian Vettel")
                .withRacerTeam("FERRARI")
                .withRacerBestTime(Duration.parse("PT1M4.415S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Daniel Ricciardo")
                .withRacerTeam("RED BULL RACING TAG HEUER")
                .withRacerBestTime(Duration.parse("PT1M12.013S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Valtteri Bottas")
                .withRacerTeam("MERCEDES")
                .withRacerBestTime(Duration.parse("PT1M12.434S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Lewis Hamilton")
                .withRacerTeam("MERCEDES")
                .withRacerBestTime(Duration.parse("PT1M12.460S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Stoffel Vandoorne")
                .withRacerTeam("MCLAREN RENAULT")
                .withRacerBestTime(Duration.parse("PT1M12.463S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Kimi Raikkonen")
                .withRacerTeam("FERRARI")
                .withRacerBestTime(Duration.parse("PT1M12.639S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Fernando Alonso")
                .withRacerTeam("MCLAREN RENAULT")
                .withRacerBestTime(Duration.parse("PT1M12.657S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Sergey Sirotkin")
                .withRacerTeam("WILLIAMS MERCEDES")
                .withRacerBestTime(Duration.parse("PT1M12.706S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Charles Leclerc")
                .withRacerTeam("SAUBER FERRARI")
                .withRacerBestTime(Duration.parse("PT1M12.829S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Sergio Perez")
                .withRacerTeam("FORCE INDIA MERCEDES")
                .withRacerBestTime(Duration.parse("PT1M12.848S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Romain Grosjean")
                .withRacerTeam("HAAS FERRARI")
                .withRacerBestTime(Duration.parse("PT1M12.930S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Pierre Gasly")
                .withRacerTeam("SCUDERIA TORO ROSSO HONDA")
                .withRacerBestTime(Duration.parse("PT1M12.941S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Carlos Sainz")
                .withRacerTeam("RENAULT")
                .withRacerBestTime(Duration.parse("PT1M12.950S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Esteban Ocon")
                .withRacerTeam("FORCE INDIA MERCEDES")
                .withRacerBestTime(Duration.parse("PT1M13.028S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Nico Hulkenberg")
                .withRacerTeam("RENAULT")
                .withRacerBestTime(Duration.parse("PT1M13.065S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Brendon Hartley")
                .withRacerTeam("SCUDERIA TORO ROSSO HONDA")
                .withRacerBestTime(Duration.parse("PT1M13.179S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Marcus Ericsson")
                .withRacerTeam("SAUBER FERRARI")
                .withRacerBestTime(Duration.parse("PT1M13.265S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Lance Stroll")
                .withRacerTeam("WILLIAMS MERCEDES")
                .withRacerBestTime(Duration.parse("PT1M13.323S"))
                .build());
        racers.add(Racer.builder()
                .withRacerName("Kevin Magnussen")
                .withRacerTeam("HAAS FERRARI")
                .withRacerBestTime(Duration.parse("PT1M13.393S"))
                .build());
        
        String expectedView = "1.  Sebastian Vettel  | FERRARI                   | 01:04.415\n"
                + "2.  Daniel Ricciardo  | RED BULL RACING TAG HEUER | 01:12.013\n"
                + "3.  Valtteri Bottas   | MERCEDES                  | 01:12.434\n"
                + "4.  Lewis Hamilton    | MERCEDES                  | 01:12.460\n"
                + "5.  Stoffel Vandoorne | MCLAREN RENAULT           | 01:12.463\n"
                + "6.  Kimi Raikkonen    | FERRARI                   | 01:12.639\n"
                + "7.  Fernando Alonso   | MCLAREN RENAULT           | 01:12.657\n"
                + "8.  Sergey Sirotkin   | WILLIAMS MERCEDES         | 01:12.706\n"
                + "9.  Charles Leclerc   | SAUBER FERRARI            | 01:12.829\n"
                + "10. Sergio Perez      | FORCE INDIA MERCEDES      | 01:12.848\n"
                + "11. Romain Grosjean   | HAAS FERRARI              | 01:12.930\n"
                + "12. Pierre Gasly      | SCUDERIA TORO ROSSO HONDA | 01:12.941\n"
                + "13. Carlos Sainz      | RENAULT                   | 01:12.950\n"
                + "14. Esteban Ocon      | FORCE INDIA MERCEDES      | 01:13.028\n"
                + "15. Nico Hulkenberg   | RENAULT                   | 01:13.065\n"
                + "-------------------------------------------------------------\n"
                + "16. Brendon Hartley   | SCUDERIA TORO ROSSO HONDA | 01:13.179\n"
                + "17. Marcus Ericsson   | SAUBER FERRARI            | 01:13.265\n"
                + "18. Lance Stroll      | WILLIAMS MERCEDES         | 01:13.323\n"
                + "19. Kevin Magnussen   | HAAS FERRARI              | 01:13.393\n";


        String actualView = raceViewProvider.provideView(racers);

        assertEquals(expectedView, actualView);
    }
}

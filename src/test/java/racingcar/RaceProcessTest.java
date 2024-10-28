package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;
import racingcar.model.RaceProcess;

class RaceProcessTest {

    private Race race;
    private RaceProcess raceProcess;

    @BeforeEach
    void setUp() {
        race = new Race(List.of("pobi", "crong", "honux"), 3);
        raceProcess = new RaceProcess(race);
    }

    @Test
    void startRaceTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        raceProcess.startRace(race.getTryCount());

        // then
        String output = outputStream.toString().trim();
        assertThat(output).contains("실행 결과");

        race.getCars().forEach(car -> assertThat(output).contains(car.getName()));
    }
}
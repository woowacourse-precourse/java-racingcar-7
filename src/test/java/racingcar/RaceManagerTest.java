package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RaceCars;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceManagerTest {

    @DisplayName("최종 우승자는 가장 높은 경주 기록을 가진 사람이다.")
    @Test
    void calculateWinners() {

        //given
        RaceManager raceManager = new RaceManager();

        String inputRaceCars = "pobi,woni,jun";
        String[] splitedInputRaceCars = inputRaceCars.split(",");
        RaceCars raceCars = RaceCars.addCars(splitedInputRaceCars);
        int raceCount = 5;
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        raceCars.initializeRaceRecords(raceCount);
        for (int round = 0; round < raceCount - 1; round++) {
            race(raceCars, round);
        }

        Car junCar = raceCars.getCarByIndex(2);
        savePrevRecordToCurrentRound(junCar, raceCount - 1);
        junCar.moveForward(raceCount - 1);

        raceManager.calculateWinners(raceCars, raceCount);

        //when
        List<String> winners = raceManager.calculateWinners(raceCars, raceCount);

        //then
        assertThat(winners).hasSize(1);
        assertThat(winners).contains("jun");
    }

    private void race(RaceCars raceCars, int round) {
        for (int index = 0; index < raceCars.size(); index++) {
            Car car = raceCars.getCarByIndex(index);
            savePrevRecordToCurrentRound(car, round);
            car.moveForward(round);
        }
    }

    private void savePrevRecordToCurrentRound(Car car, int round) {
        if (round > 0) {
            car.recordPrevRaceByRound(round);
        }
    }
}
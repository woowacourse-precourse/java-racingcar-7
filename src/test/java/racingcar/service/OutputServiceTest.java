package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Results;

class OutputServiceTest {

    private final RacingService racingService = new RacingService();
    private final OutputService outputService = new OutputService();

    @Test
    @DisplayName("실행 결과 메시지 생성")
    void generateResultMessage() {
        //given
        final List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        final CarNames carNames = new CarNames(names);
        final Cars cars = Cars.from(carNames);

        final int roundCount = 5;
        final Results results = racingService.startRace(cars, roundCount);

        //when
        String resultMessage = outputService.generateResultMessage(results);

        //then
        assertThat(resultMessage).contains("a : ", "b : ", "c : ");
    }

    @Test
    @DisplayName("우승자 출력 메시지 생성")
    void generateWinnerMessage() {
        //given
        final List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        final CarNames carNames = new CarNames(names);
        final Cars cars = Cars.from(carNames);

        final int roundCount = 5;
        racingService.startRace(cars, roundCount);

        //when
        String winnerMessage = outputService.generateWinnerMessage(cars);

        //then
        assertThat(winnerMessage).isNotEmpty();
    }
}
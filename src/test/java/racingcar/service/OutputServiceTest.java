package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Result;

class OutputServiceTest {

    private final RacingService racingService = new RacingService();
    private final OutputService outputService = new OutputService();

    @Test
    @DisplayName("실행 결과 메시지 생성")
    void generateResultMessage() {
        //given
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));

        final int roundCount = 5;
        final List<Result> results = racingService.startRace(cars, roundCount);

        //when
        String resultMessage = outputService.generateResultMessage(results);

        //then
        Assertions.assertThat(resultMessage).contains("a : ", "b : ", "c : ");
    }

    @Test
    @DisplayName("우승자 출력 메시지 생성")
    void generateWinnerMessage() {
        //given
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));

        final int roundCount = 5;
        racingService.startRace(cars, roundCount);

        //when
        String winnerMessage = outputService.generateWinnerMessage(cars);

        //then
        Assertions.assertThat(winnerMessage).isNotEmpty();
    }
}
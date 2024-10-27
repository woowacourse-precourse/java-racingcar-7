package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Message;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Result;
import racingcar.domain.race.RoundCount;

class MessageServiceTest {

    private final RacingService racingService = new RacingService();
    private final MessageService messageService = new MessageService();

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
        final RoundCount roundCount = RoundCount.from("5");
        final Result result = racingService.startRace(cars, roundCount);

        //when
        Message resultMessage = messageService.generateResultMessage(result);

        //then
        assertThat(resultMessage.getMessage()).contains("a : ", "b : ", "c : ");
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
        final RoundCount roundCount = RoundCount.from("5");
        racingService.startRace(cars, roundCount);

        //when
        Message winnerMessage = messageService.generateWinnerMessage(cars);

        //then
        assertThat(winnerMessage.getMessage()).contains("최종 우승자 : ");
    }
}
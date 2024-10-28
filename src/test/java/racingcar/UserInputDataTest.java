package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.UserInputData;

class UserInputDataTest {

    @Test
    @DisplayName("최종 우승자를 추출하는 기능 테스트")
    void getWinners() {
        //given
        List<Car> cars = List.of(new Car("dodo"), new Car("ho"), new Car("qwer123"));
        int trialCount = 4;
        UserInputData userInputData = new UserInputData(cars,trialCount);
        //when
        cars.get(0).moveRandomly(true);
        cars.get(0).moveRandomly(true);
        cars.get(1).moveRandomly(true);
        cars.get(1).moveRandomly(true);
        cars.get(2).moveRandomly(false);
        List<String> winners = userInputData.getWinners();
        //then
        Assertions.assertThat(winners).containsExactly("dodo","ho");
    }
}
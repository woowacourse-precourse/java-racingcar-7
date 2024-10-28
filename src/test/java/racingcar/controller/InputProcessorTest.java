package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.ErrorCode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class InputProcessorTest {

    private InputProcessor inputProcessor;
    private Race race;

    @BeforeEach
    void setUp() {
        inputProcessor = new InputProcessor();
        race = new Race();
    }


    @Test
    void 자동차_이름이_5자_이상() {
        // given
        String stringCarList = "123456";

        // when & then
        assertThatThrownBy(() -> inputProcessor.setCarList(race, stringCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_CAR_NAME.getMessage());
    }

    @Test
    void 자동차가_1000대_초과() {
        // given
        String stringCarList = IntStream.rangeClosed(1, 1001)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        // when & then
        assertThatThrownBy(() -> inputProcessor.setCarList(race, stringCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.CAR_LIMIT_EXCEEDED.getMessage());
    }

    @Test
    void 자동차_이름_중복() {
        // given
        String stringCarList = "a,a,b";

        // when & then
        assertThatThrownBy(() -> inputProcessor.setCarList(race, stringCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    void 자동차_이름_앞뒤에_공백() {
        // given
        String stringCarList = " car  ,       car2   , car3  ";

        // when
        inputProcessor.setCarList(race, stringCarList);

        // then
        List<Car> carList = race.getCarList();
        assertThat(carList).extracting(Car::getName)
                .containsExactly("car", "car2", "car3");
    }

    @Test
    void 연속된_구분자는_통과() {
        // given
        String stringCarList = "car,,,,,car2,,";

        // when
        inputProcessor.setCarList(race, stringCarList);

        // then
        List<Car> carList = race.getCarList();
        assertThat(carList).extracting(Car::getName)
                .containsExactly("car", "car2");
    }

    @Test
    void 이동_횟수_음수() {
        // given
        String totalRound = "-1";

        // when & then
        assertThatThrownBy(() -> inputProcessor.setTotalRound(race, totalRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_MOVE_COUNT.getMessage());
    }

    @Test
    void 이동_횟수_1000_초과() {
        // given
        String totalRound = "1001";

        // when & then
        assertThatThrownBy(() -> inputProcessor.setTotalRound(race, totalRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_MOVE_COUNT.getMessage());
    }

    @Test
    void 이동_횟수가_문자열() {
        // given
        String totalRound = "abc";

        // when & then
        assertThatThrownBy(() -> inputProcessor.setTotalRound(race, totalRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_MOVE_COUNT.getMessage());
    }

    @Test
    void 이동_횟수_정상() {
        // given
        String totalRound = "503";

        // when
        inputProcessor.setTotalRound(race, totalRound);

        // then
        assertThat(race.getTotalRound()).isEqualTo(503);
    }

}
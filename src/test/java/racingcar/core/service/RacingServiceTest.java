package racingcar.core.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.core.view.RacingView;
import racingcar.domain.RacingCar;
import racingcar.properties.RacingProperties;
import racingcar.properties.function.CarNameFilter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.RacingConstant.RACING_CAR_MOVE_LIMIT;

class RacingServiceTest {

    RacingService racingService;
    RacingView racingView;

    @BeforeEach
    void before() {
        racingView = new RacingView();
        racingService = new RacingService();
    }

    private RacingProperties getRacingPropertiesWithoutFilter() {
        return getPropertiesWithCarNameFilter(car -> true);
    }

    private RacingProperties getPropertiesWithCarNameFilter(CarNameFilter carNameFilter) {
        return RacingProperties.builder()
                .carNameFilter(carNameFilter)
                .carMoveNumberPicker(() -> RACING_CAR_MOVE_LIMIT)
                .carPositionPrinter(cars -> racingView.printCarsPosition(cars))
                .build();
    }

    private void assertThatWinners(List<RacingCar> winners, String ... carNames) {
        assertThat(winners).extracting(RacingCar::getName).containsExactly(carNames);
    }

    private List<RacingCar> race(RacingProperties properties, String cars, String tryCount) {
        return racingService.properties(properties).raceStartAndGetWinners(cars, tryCount);
    }

    @Test
    void 자동차_빈문자열_이름예외() {
        //given
        String cars = " ,woni";
        String tryCount = "5";
        RacingProperties properties = getRacingPropertiesWithoutFilter();

        //when
        assertThatThrownBy(() -> race(properties, cars, tryCount));
    }

    @Test
    void 자동차_초과_이름예외() {
        //given
        String cars = "spring,woni";
        String tryCount = "5";
        RacingProperties properties = getRacingPropertiesWithoutFilter();

        //when
        assertThatThrownBy(() -> race(properties, cars, tryCount));
    }

    @Test
    void 자동차_최소_수_예외() {
        //given
        String cars = "pobi";
        String tryCount = "5";
        RacingProperties properties = getRacingPropertiesWithoutFilter();

        //when
        assertThatThrownBy(() -> race(properties, cars, tryCount));
    }

    @Test
    void 자동차_실행_횟수_문자_예외() {
        //given
        String cars = "pobi,woni";
        String tryCount = "a";
        RacingProperties properties = getRacingPropertiesWithoutFilter();

        //when
        assertThatThrownBy(() -> race(properties, cars, tryCount));
    }

    @Test
    void 자동차_실행_횟수_정수_예외() {
        //given
        String cars = "pobi,woni";
        String tryCount = "0";
        RacingProperties properties = getRacingPropertiesWithoutFilter();

        //when
        assertThatThrownBy(() -> race(properties, cars, tryCount));
    }

    @Test
    void 자동차_이름_중복_예외() {
        //given
        String cars = "pobi,pobi,pobi";
        String tryCount = "5";
        RacingProperties properties = getRacingPropertiesWithoutFilter();

        //when
        assertThatThrownBy(() -> race(properties, cars, tryCount));
    }

    @Test
    void pobi_우승자_테스트() {
        //given
        String cars = "            pobi       ,woni,pobi";
        String tryCount = "5";
        RacingProperties properties = getPropertiesWithCarNameFilter(car -> car.getName().equals("pobi"));

        //when
        List<RacingCar> winners = race(properties, cars, tryCount);

        //then
        assertThatWinners(winners, "pobi");
    }

    @Test
    void pobi_woni_우승자_테스트() {
        //given
        String cars = "pobi,woni";
        String tryCount = "5";
        RacingProperties properties = getRacingPropertiesWithoutFilter();

        //when
        List<RacingCar> winners = race(properties, cars, tryCount);

        //then
        assertThatWinners(winners, "pobi", "woni");
    }

    @Test
    void woni_pobi_우승자_테스트() {
        //given
        String cars = "woni,pobi";
        String tryCount = "5";
        RacingProperties properties = getRacingPropertiesWithoutFilter();

        //when
        List<RacingCar> winners = race(properties, cars, tryCount);

        //then
        assertThatWinners(winners, "woni", "pobi");
    }

    @Test
    void woni_pobi_참여자_여러명_우승자_테스트() {
        //given
        String cars = "woni,pobi,java,apple,hello,world";
        String tryCount = "5";
        RacingProperties properties = getPropertiesWithCarNameFilter(car ->
                car.getName().equals("pobi") || car.getName().equals("woni"));

        //when
        List<RacingCar> winners = race(properties, cars, tryCount);

        //then
        assertThatWinners(winners, "woni", "pobi");
    }
}
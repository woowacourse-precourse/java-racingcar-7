package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.*;
import racingcar.race.RaceResult;
import racingcar.race.Stadium;

import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StadiumTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("모든 차가 4번 이동했는지 검증")
    void verifyAllCarsMoveFourTimes() {
        // Given
        CarFactory carFactory = new CarFactory();
        CarRegistry carRegistry = new CarRegistry(carFactory.createCars("pobi,woni,jun"));
        RaceResult result = new RaceResult(new StringBuilder(), carRegistry);
        Stadium stadium = new Stadium(carRegistry, result);

        String pobiString = "pobi : ----";
        String woniString = "woni : ----";
        String junString = "jun : ----";

        // When & Then
        assertRandomNumberInRangeTest(() -> {
            stadium.raceEachRounds(4);
            Set<Car> cars = carRegistry.getCars();
            String actualString = "";
            for (Car car : cars) {
                actualString += car.toString() + "\n";
            }
            assertThat(actualString).contains(pobiString).contains(woniString).contains(junString);
        }, MOVING_FORWARD);
    }

    @Test
    @DisplayName("모든 차가 랜덤 숫자가 3이 나왔을 때 멈추는지 검증")
    void verifyCarsDoNotMoveWhenRandomNumberIsBelowThreshold() {
        // Given

        CarFactory carFactory = new CarFactory();
        CarRegistry carRegistry = new CarRegistry(carFactory.createCars("pobi,woni,jun"));
        RaceResult result = new RaceResult(new StringBuilder(), carRegistry);
        Stadium stadium = new Stadium(carRegistry, result);

        String pobiString = "pobi : ";
        String woniString = "woni : ";
        String junString = "jun : ";

        // When & Then
        assertRandomNumberInRangeTest(() -> {
            stadium.raceEachRounds(4);
            Set<Car> cars = carRegistry.getCars();
            String actualString = "";
            for (Car car : cars) {
                actualString += car.toString() + "\n";
            }
            assertThat(actualString).contains(pobiString).contains(woniString).contains(junString);
        }, STOP);
    }

    @Test
    @DisplayName("모든 차가 CarRegistry에 이름이 중복으로 생기는지 검증")
    void verifyAllCarsAreUniqueInCarRegistry() {
        // Given
        CarFactory carFactory = new CarFactory();
        CarRegistry carRegistry = new CarRegistry(carFactory.createCars("pobi,woni,woni"));

        // When
        Set<Car> cars = carRegistry.getCars();

        // Then
        assertThat(cars).hasSize(2);
        assertThat(cars).extracting("name").containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    @DisplayName("한명의 이름이 너무 길 때 오류 반환하는지 검증")
    void validateCarNamesCannotExceedLength() {
        // Given
        String input = "pobi,woni,pobiMaguire"; // Name too long
        CarFactory carFactory = new CarFactory();

        // When & Then
        assertThatThrownBy(() -> carFactory.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car name has to be 5 or under 5.");
    }

}

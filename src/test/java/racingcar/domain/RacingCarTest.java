package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
    private static final String RACING_CAR_NAME_1 = "ini";
    private static final String RACING_CAR_NAME_2 = "yoni";
    private static final String RACING_CAR_NAME_3 = "yuni";

    @DisplayName("자동차는 랜덤 값에 따라 전진 또는 멈출 수 있습니다.")
    @ParameterizedTest
    @CsvSource({"4,1", "5,1", "6,1",
            "0,0", "1,0", "3,0"})
    void carMoveOrStopByRandomNumber(int givenPower, int curLocation) {
        // given
        int startLocation = 0;
        RacingCar car = createCar(RACING_CAR_NAME_1, startLocation);

        // when
        car.move(givenPower);

        // then
        assertThat(car.getLocation()).isEqualTo(curLocation);
    }

    @DisplayName("같은 위치의 자동차가 존재하는지 확인할 수 있습니다.")
    @ParameterizedTest
    @CsvSource({"2,2,true","2,1,false"})
    void isSameLocationOfCar(int myCarLocation,
                             int competeCarLocation,
                             boolean sameDistanceCheck) throws Exception{
        //given
        RacingCar myCar = createCar(RACING_CAR_NAME_1, myCarLocation);
        RacingCar competeCar = createCar(RACING_CAR_NAME_2, competeCarLocation);
        //when
        boolean sameDistance = myCar.isSameLocation(competeCar);
        //then
        assertThat(sameDistance).isEqualTo(sameDistanceCheck);
    }

    @DisplayName("전진한 자동차들의 거리들을 비교할 수 있습니다.")
    @Test
    void compareLocationToCar() throws Exception{
        //given
        RacingCar myCar = createCar(RACING_CAR_NAME_1, 4);
        RacingCar competeCar = createCar(RACING_CAR_NAME_2, 2);
        //when
        int compare = myCar.compareTo(competeCar);
        //then
        assertThat(compare).isGreaterThan(0);
    }

    @DisplayName("자동차 경주 게임의 우승자를 확인할 수 있습니다.")
    @Test
    void findWinners() throws Exception {
        //given
        RacingCar myCar = createCar(RACING_CAR_NAME_1, 3);
        RacingCar competeCar1 = createCar(RACING_CAR_NAME_2, 2);
        RacingCar competeCar2 = createCar(RACING_CAR_NAME_3, 3);
        RacingCars cars = new RacingCars(List.of(myCar, competeCar1, competeCar2));
        //when
        List<String> winners = cars.findRacingWinners();
        //then
        Assertions.assertThat(winners).hasSize(2)
                .containsExactly(RACING_CAR_NAME_1, RACING_CAR_NAME_3);
    }

    private static RacingCar createCar(String carName, int location) {
        return new RacingCar(carName, location);
    }

}
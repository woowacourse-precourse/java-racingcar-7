package racingcar.racingCarManger;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.List;

import static racingcar.exception.ExceptionMessage.CAR_NAME_NOT_DUPLICATION;

class RacingCarManagerImplTest {

    @Test
    @DisplayName("레이싱 게임 자동차 초기 셋업")
    void 레이싱_게임_자동차_초기_셋업_TEST(){
        List<String> carsName = List.of("kang","su","min");
        RacingCarManager racingCarManager = new RacingCarManagerImpl(carsName);

        Assertions.assertThat(racingCarManager.getNumberOfRacingCars()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름은 중복되면 안된다.")
    void 자동차_이름_중복_테스트(){
        List<String> carsName = List.of("sumin","sumin","sumin");
        Assertions.assertThatThrownBy(() -> new RacingCarManagerImpl(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_NOT_DUPLICATION);
    }

    @Test
    @DisplayName("자동차를 이동시킬 수 있다.")
    void 자동차_이동_TEST(){
        List<String> carsName = List.of("kang","su","min");
        RacingCarManager racingCarManager = new RacingCarManagerImpl(carsName);

        List<Integer> randomNumbers = List.of(5,3,3);

        List<Car> cars = racingCarManager.moveRacingCars(randomNumbers);

        Assertions.assertThat(cars.get(0).getPosition()).isEqualTo(1);
        Assertions.assertThat(cars.get(1).getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("우승자를 알 수 있다.")
    void 레이싱_게임_우승자_조회_TEST(){
        List<String> carsName = List.of("kang","su","min");
        RacingCarManager racingCarManager = new RacingCarManagerImpl(carsName);

        List<Integer> try1 = List.of(5,3,3);
        List<Integer> try2 = List.of(5,5,3);
        List<Integer> try3 = List.of(3,5,3);

        racingCarManager.moveRacingCars(try1);
        racingCarManager.moveRacingCars(try2);
        racingCarManager.moveRacingCars(try3);

        List<Car> winners = racingCarManager.getWinners();

        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners.get(0).getCarName()).isEqualTo("kang");
        Assertions.assertThat(winners.get(1).getCarName()).isEqualTo("su");
    }

}
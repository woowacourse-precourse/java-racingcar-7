package racingcar.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

class RaceCarsTest {
    @Test
    @DisplayName("RaceCars 객체를 생성할 수 있다.")
    void createRaceCars() {
        //given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car = new Car(name1);
        Car car2 = new Car(name2);
        List<Car> cars = Arrays.asList(car, car2);
        //when
        RaceCars raceCars = new RaceCars(cars);
        //then
        Assertions.assertThat(raceCars).isNotNull();
    }

    @Test
    @DisplayName("2대 미만의 자동차로 RaceCars 객체 생성시 예외가 발생한다.")
    void createRaceCarsWithLessThanTwoCars() {
        //given
        Name name = new Name("우테코");
        Car car = new Car(name);
        List<Car> cars = Arrays.asList(car);
        //when, then
        Assertions.assertThatThrownBy(() -> new RaceCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RACINGCAR_NUMBER.getMessage());
    }

    @Test
    @DisplayName("경주에 같은 이름을 가지는 자동차가 참여하면 예외를 발생한다.")
    void createRaceCarsWithDuplicatedCars() {
        //given
        Name name = new Name("우테코");

        Car car1 = new Car(name);
        Car car2 = new Car(name);
        List<Car> cars = Arrays.asList(car1, car2);
        //when, then
        Assertions.assertThatThrownBy(() -> new RaceCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_RACINGCAR.getMessage());
    }

    @Test
    @DisplayName("모든 자동차를 이동시킬 수 있다.")
    void moveAllCars() {
        //given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car = new Car(name1);
        Car car2 = new Car(name2);
        List<Car> cars = Arrays.asList(car, car2);
        RaceCars raceCars = new RaceCars(cars);
        List<Car> beforeMovement = raceCars.getCars();
        Movement alwaysTrueMovement = () -> true;
        //when
        raceCars.moveAllCars(alwaysTrueMovement);
        List<Car> afterMovement = raceCars.getCars();
        //then
        for (int i = 0; i < cars.size(); i++) {
            Assertions.assertThat(afterMovement.get(i).hasBiggerPositionThan(beforeMovement.get(i))).isTrue();
        }
    }
}
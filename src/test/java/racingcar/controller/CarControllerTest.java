package racingcar.controller;

import static racingcar.controller.CarController.makeCarNameList;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class CarControllerTest {

    @Test
    void makeCarNameList_containsExactly() {
        String userInput = ("car1, car2 ,   car3, 4");
        List<String> carNameList = makeCarNameList(userInput);

        Assertions.assertThat(carNameList).containsExactly("car1", "car2", "car3", "4");
    }

    @Test
    void makeCarNameList_carLengthException() {
        String userInput = "hardy1, d, q";
        AssertionsForClassTypes.assertThatThrownBy(() -> makeCarNameList(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5글자만 가능합니다.");
    }

    @Test
    void makeCarList_containsExactly() {
        List<Car> carList = CarController.makeCarList(
                CarController.makeCarNameList("car1, car2, car3"));

        Assertions.assertThat(carList).containsExactly(
                carList.get(0), carList.get(1), carList.get(2));
    }

    @Test
    void makeCarList_setNameTest() {
        List<Car> carList = CarController.makeCarList(
                CarController.makeCarNameList("car1, car2, car3"));

        Assertions.assertThat(carList.get(0).getCarName()).isEqualTo("car1");
        Assertions.assertThat(carList.get(1).getCarName()).isEqualTo("car2");
        Assertions.assertThat(carList.get(2).getCarName()).isEqualTo("car3");
    }

    @Test
    void makeCarList_putRandomNumberTest() {
        List<Car> carList = CarController.makeCarList(
                CarController.makeCarNameList("car1, car2, car3"));

        for (Car car : carList) {
            CarController.putRandomNumber(car);
        }

        Assertions.assertThat(carList.get(0).getRandomNumber()).isBetween(0, 9);
        Assertions.assertThat(carList.get(1).getRandomNumber()).isBetween(0, 9);
        Assertions.assertThat(carList.get(2).getRandomNumber()).isBetween(0, 9);
    }

    @Test
    void addMoveCount() {
        List<Car> carList = CarController.makeCarList(
                CarController.makeCarNameList("car1, car2, car3"));

        for (Car car : carList) {
            car.setRandomNumber(3);
            CarController.addMoveCount(car);
        }

        Assertions.assertThat(carList.getFirst().getMoveCount()).isEmpty();
    }

    @Test
    void convertListToString() {
        List<Character> moveCount = new ArrayList<>();

        moveCount.add('-');
        moveCount.add('-');
        moveCount.add('-');

        String testString = CarController.convertListToString(moveCount);

        Assertions.assertThat(testString).isEqualTo("---");
    }
}

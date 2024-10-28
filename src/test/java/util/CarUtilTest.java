package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class CarUtilTest {

    @DisplayName("makeRandomInt의 결과값이 0~9 사이인지 확인한다")
    @Test
    void getRandomIntShouldReturnNumberBetween0And9() {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < 1000; i++) {
            set.add(CarUtil.makeRandomInt());
        }

        assertThat(0).isEqualTo(set.getFirst());
        assertThat(9).isEqualTo(set.getLast());
        assertThat(CarUtil.makeRandomInt()).isBetween(0, 9);
    }

    @DisplayName("Toyota,Honda,Ford,Nissan을 입력하면 해당 ArrayList<Car>만 만들어지는지 확인")
    @Test
    public void testMakeCarListSplitInputCorrectly() {
        String input = "Toyota,Honda,Ford,Nissan";

        ArrayList<Car> result = CarUtil.makeCarList(input);

        assertThat(result).hasSize(4);
        assertThat(result.get(0).getName()).isEqualTo("Toyota");
        assertThat(result.get(1).getName()).isEqualTo("Honda");
        assertThat(result.get(2).getName()).isEqualTo("Ford");
        assertThat(result.get(3).getName()).isEqualTo("Nissan");
    }

    @DisplayName("랜덤으로 만든 숫자가 4 이상이면 자동차가 전진했는지 확인")
    @Test
    void over4ShouldAdvance() {
        int advanceCount = 0;
        Car car = new Car("testCar");

        for (int i = 0; i < 1000; i++) {
            int randomInt = CarUtil.advanceSixTimesOutOfTen(car);
            if (randomInt >= 4) {
                advanceCount++;
                assertThat(advanceCount).isEqualTo(car.getAdvanceCount());
            } else {
                assertThat(advanceCount).isEqualTo(car.getAdvanceCount());
            }
        }
    }

    @DisplayName("getMaxAdvanceCount : 자동차 중 전진횟수의 최대값이 8일때 8을 반환하는지 확인")
    @Test
    void if8EqualsMaxValueShouldReturn8() {
        ArrayList<Car> carList = new ArrayList<>();
        Car car = new Car("testCar");
        while (true) {
            CarUtil.advanceSixTimesOutOfTen(car);
            if (8 == car.getAdvanceCount()) {
                carList.add(car);
                break;
            } else if (car.getAdvanceCount() < 8) {
                carList.add(car);
            }
        }

        int maxAdvanceCount = CarUtil.getMaxAdvanceCount(carList);

        assertThat(8).isEqualTo(maxAdvanceCount);
    }

    @DisplayName("우승자 이름이 Toyota일때 정상적으로 잘 출력하는지 확인")
    @Test
    void winnerIsToyotaShouldReturnToyota() {
        ArrayList<Car> cars = new ArrayList<>();
        Car toyota = new Car("Toyota");
        Car honda = new Car("Honda");
        toyota.setAdvanceCount(9);
        honda.setAdvanceCount(7);

        cars.add(toyota);
        cars.add(honda);

        assertThat("Toyota").isEqualTo(CarUtil.getWinnerNames(cars));
    }

    @DisplayName("우승자 이름이 Toyota, Honda, Ford 일때 정상적으로 잘 출력하는지 확인")
    @Test
    void winnerIsToyotaHondaFordShouldReturnToyotaHondaFord() {
        ArrayList<Car> cars = new ArrayList<>();
        Car toyota = new Car("Toyota");
        Car honda = new Car("Honda");
        Car ford = new Car("Ford");
        toyota.setAdvanceCount(9);
        honda.setAdvanceCount(9);
        ford.setAdvanceCount(9);

        cars.add(toyota);
        cars.add(honda);
        cars.add(ford);

        assertThat("Toyota, Honda, Ford").isEqualTo(CarUtil.getWinnerNames(cars));
    }
}
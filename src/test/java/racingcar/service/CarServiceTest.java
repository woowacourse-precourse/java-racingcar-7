package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarServiceTest {

    private List<Car> cars;
    @BeforeEach
    void init(){
        cars = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Car car = new Car(""+i);
            car.advanceCar();
            cars.add(car);
        }
    }

    @DisplayName("우승자 찾는 메서드")
    @Test
    void findWinner() {
        CarService carService = new CarService();
        List<String> winner = carService.findWinner(cars);
        assertEquals(4, winner.size());
    }

    @DisplayName("자동차 이름이 6이상이면 에러발생")
    @Test
    void largeNameCar(){
        String name = "일이삼사오육";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
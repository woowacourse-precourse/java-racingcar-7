package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarRacingTest {

    @Test
    @DisplayName("차량 세팅 테스트")
    void car_setting_test() {
        CarRacing carRacing = new CarRacing();

        String[] carNames = {"car1", "car2", "car3"};

        List<Car> carList = carRacing.settingCar(carNames);

        Assertions.assertThat(carList.get(0).getName()).isEqualTo("car1");
        Assertions.assertThat(carList.get(1).getName()).isEqualTo("car2");
        Assertions.assertThat(carList.get(2).getName()).isEqualTo("car3");
    }

    @Test
    @DisplayName("차량 이동 테스트")
    void car_move_test(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        for (int i = 0; i < 3; i++) {
            car1.move();
        }
        for (int i = 0; i < 2; i++) {
            car2.move();
        }
        for (int i = 0; i < 5; i++) {
            car3.move();
        }

        Assertions.assertThat(car1.getLocation()).isEqualTo(3);
        Assertions.assertThat(car2.getLocation()).isEqualTo(2);
        Assertions.assertThat(car3.getLocation()).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자 반환 테스트")
    void winner_Test() {
        CarRacing carRacing = new CarRacing();

        String[] carNames = {"car1", "car2", "car3"};

        List<Car> carList = carRacing.settingCar(carNames);

        carList.get(0).move();
        carList.get(2).move();

        Assertions.assertThat(carRacing.getCarNamesAtLocation(carList, 1).size()).isEqualTo(2);
        Assertions.assertThat(carRacing.getCarNamesAtLocation(carList, 1).get(0)).isEqualTo("car1");
        Assertions.assertThat(carRacing.getCarNamesAtLocation(carList, 1).get(1)).isEqualTo("car3");
    }
}

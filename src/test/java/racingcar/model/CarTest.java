package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_객체가_올바르게_생성되는지_테스트() {
        String carName = "pobi";
        Car car = new Car(carName);

        assertThat(car.getCarName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 랜덤_값에_따라_올바르게_전진하는지_테스트() {
        Car car = new Car("pobi");
        int randomNumber = 4;

        car.goForward(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_값에_따라_올바르게_멈춰있는지_테스트() {
        Car car = new Car("pobi");
        int randomNumber = 3;

        assertThat(car.getPosition()).isEqualTo(0);
        car.goForward(randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}

package racingcar.model.Car;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 이름이 정상적으로 생성이 된다.")
    public void setCarNames() {
        String[] tempCarName = {"crong", ":woni"};
        Cars cars = new Cars(tempCarName);

        Assertions.assertThat(cars.getCarListSize()).isEqualTo(2);
    }
}
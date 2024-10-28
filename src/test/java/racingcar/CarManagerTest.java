package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarManagerTest {

    @DisplayName("조건이 참이면 차가 한칸 전진 한다.")
    @Test
    void moveCarTest() {
        // given
        Car car = new Car("test");
        CarManager manager = new CarManager(() -> true);

        // when
        manager.moveCarsForward(List.of(car));

        // then
        assertThat(car.isPositionSameAs(1)).isTrue();
    }

    @DisplayName("조건이 거짓이면 차는 전진하지 않는다.")
    @Test
    void stopCarTest() {
        // given
        Car car = new Car("test");
        CarManager manager = new CarManager(() -> false);

        // when
        manager.moveCarsForward(List.of(car));

        // then
        assertThat(car.isPositionSameAs(0)).isTrue();
    }

    @DisplayName("쉼표를 기준으로 문자열에서 자동차 이름을 부여한다.")
    @Test
    void makeCarsTest() {
        // given
        String text = "pobi,woni,jun";
        CarManager manager = new CarManager(null);

        // when
        List<Car> cars = manager.makeCarsFromText(text);

        // then
        assertThat(cars.get(0).toString()).hasToString("pobi");
        assertThat(cars.get(1).toString()).hasToString("woni");
        assertThat(cars.get(2).toString()).hasToString("jun");
    }
}
package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.DUPLICATE_NAME;

class GameUtilTest {

    @Test
    @DisplayName("자동차 이름이 3개인 경우")
    public void test1(){
        String inputCarName = "a,b,c";
        List<String> carNames = GameUtil.prepareCarNames(inputCarName);

        assertThat(List.of("a","b","c")).isEqualTo(carNames);
    }

    @Test
    @DisplayName("자동차 이름이 중복 되는 경우")
    public void test2(){
        String inputCarName = "a,a,a";

        assertThatThrownBy(() -> GameUtil.prepareCarNames(inputCarName))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(DUPLICATE_NAME.getMessage());
    }

    @Test
    @DisplayName("우승자가 한명인 경우")
    public void test3(){
        List<Car> cars = List.of(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        );
        cars.get(0).move(5);
        cars.get(1).move(0);
        cars.get(2).move(0);

        List<String> winners = GameUtil.calculateWinners(cars);
        assertThat(List.of("car1")).isEqualTo(winners);
    }

    @Test
    @DisplayName("우승자가 여러명인 경우")
    public void test4(){
        List<Car> cars = List.of(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        );
        cars.get(0).move(5);
        cars.get(1).move(5);
        cars.get(2).move(0);

        List<String> winners = GameUtil.calculateWinners(cars);
        assertThat(List.of("car1", "car2")).isEqualTo(winners);
    }

}
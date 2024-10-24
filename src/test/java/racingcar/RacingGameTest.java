package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    static RacingGame racingGame;
    static List<Car> cars;



    @BeforeEach
    void init() {
        racingGame = new RacingGame();
        cars = new ArrayList<>();
        cars.add(new Car("abc", 0));
        cars.add(new Car("abcde", 0));
    }


    @Test
    @DisplayName("이름의 길이가 5를 초과하는 경우 예외 발생")
    @Order(1)
    void nameCheck() {
        cars.add(new Car("abcdef", 0));
        assertThatThrownBy(() -> racingGame.nameCheck(cars)).isInstanceOf(IllegalArgumentException.class);
    }


}
package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void 자동차_객체_생성_예외(String name){
        assertThrows(IllegalArgumentException.class, ()->new Car(name, ()-> Randoms.pickNumberInRange(0, 9)));
    }
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void 자동차_객체_생성_성공(String name){
        //when
        Car car = new Car(name, () -> Randoms.pickNumberInRange(0, 9));

        //then
        assertEquals(name, car.getCarName());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10})
    void move_실패(int pick){
        //given
        Car car = new Car("test", () -> pick);

        //when
        car.move();

        //then
        assertEquals(0, car.getPlace());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_성공(int pick){
        //given
        Car car = new Car("test", () -> pick);

        //when
        car.move();

        //then
        assertEquals(1, car.getPlace());
    }
}
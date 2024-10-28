package racingcar.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("차량 전진 확인")
    void test1() {
        Car car = new Car("A", 5);

        car.move(10);

        assertEquals(car.getLocation(), 5 + 10);
    }

    @Test
    @DisplayName("차량이 다른 차량 앞에 있는지 확인")
    void test2() {
        assertTrue(new Car("A", 5).isAhead(new Car("A", 0)));
        assertFalse(new Car("A", 0).isAhead(new Car("A", 5)));
        assertFalse(new Car("A", 5).isAhead(new Car("A", 5)));
    }


    @ParameterizedTest(name = "{2}")
    @MethodSource("constructorOptions")
    @DisplayName("생성자 예외")
    void test3(String name, int location, String testTitle) {
        assertThrows(IllegalArgumentException.class, () -> new Car("ABCDEF", 0));
    }

    static Stream<Arguments> constructorOptions() {
        return Stream.of(
                // 단일 페이즈 면접
                Arguments.arguments("ABCDEF", 0, "이름 길이가 5를 초과할 수 없음"),
                Arguments.arguments("A", -1, "location은 0보다 작을 수 없음")
        );
    }

    @Test
    @DisplayName("이동 시 location이 음수가 되면 예외 발생")
    void test4() {
        Car car = new Car("ABC", 0);
        assertThrows(IllegalArgumentException.class, () -> car.move(-1));
    }
}

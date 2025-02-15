package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    void nameMaxLength() {
        cars.add(new Car("abcdef", 0));
        assertThatThrownBy(() -> racingGame.nameCheck(cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 null일 경우 예외 발생")
    @Order(2)
    void nameIsNull() {
        cars.add(new Car(null, 0));
        assertThatThrownBy(() -> racingGame.nameCheck(cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 공백 문자로 입력할 경우 예외 발생")
    @Order(3)
    void nameIsBlank() {
        cars.add(new Car(" ", 0));
        assertThatThrownBy(() -> racingGame.nameCheck(cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 빈 문자열로 입력할 경우 예외 발생")
    @Order(4)
    void nameIsEmpty() {
        cars.add(new Car("", 0));
        assertThatThrownBy(() -> racingGame.nameCheck(cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("횟수를 0 이하의 숫자 또는 문자로 입력할 경우 예외 발생")
    @ValueSource(strings = {"0", "-1", "a"})
    @Order(5)
    void countCheck(String input) {
        assertThatThrownBy(() -> racingGame.countCheck(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4 이상일 경우 전진")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @Order(6)
    void movingCar(int num) {
        Car car = cars.get(0);
        car.move(num);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4 미만일 경우 전진 X")
    @ValueSource(ints = {0, 1, 2, 3})
    @Order(7)
    void findMovingCar(int num) {
        Car car = cars.get(0);
        car.move(num);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("실행 결과 출력 확인")
    @Order(8)
    void printGameResult() {
        cars.add(new Car("carA", 5));
        OutputStream output = getOutputStream();
        racingGame.printGameResult(cars);
        assertThat(output.toString()).contains("abc : ", "abcde : ", "carA : -----");
    }

    @Test
    @DisplayName("우승자가 1명인 경우")
    @Order(9)
    void printWinner() {
        cars.add(new Car("carA", 3));
        OutputStream output = getOutputStream();
        racingGame.printWinner(cars);
        assertThat(output.toString()).isEqualTo("최종 우승자 : carA");
    }


    @Test
    @DisplayName("우승자가 2명인 경우")
    @Order(10)
    void printWinners() {
        cars.add(new Car("carA", 5));
        cars.add(new Car("carB", 5));
        OutputStream output = getOutputStream();
        racingGame.printWinner(cars);
        assertThat(output.toString()).isEqualTo("최종 우승자 : carA, carB");
    }

    private OutputStream getOutputStream() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

}
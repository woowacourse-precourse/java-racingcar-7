package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @Order(1)
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    @Order(2)
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    @Order(3)
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @Order(4)
    @DisplayName("입력된 자동차 이름들을 올바르게 리스트로 반환한다")
    void getCarNamesTest() {
        // Given
        String input = "car1,car2,car3";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // When
        List<String> carNames = Application.getCarNames(input);

        // Then
        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @Test
    @Order(5)
    @DisplayName("5자를 초과하거나 공백인 자동차 이름을 입력하면 예외를 발생시킨다")
    void getCarNamesExceptionTest() {
        // Given
        String input = "car1234,car2,,car";

        // When & Then
        assertThatThrownBy(() -> Application.getCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(6)
    @DisplayName("입력된 이동 횟수를 올바르게 반환한다")
    void getMovementCountTest() {
        // Given
        String input = "5";

        // When
        Integer movementCount = Application.getMovementCount(input);

        // Then
        assertThat(movementCount).isEqualTo(5);
    }

    @Test
    @Order(7)
    @DisplayName("숫자가 아닌 이동 횟수를 입력하면 예외를 발생시킨다")
    void getMovementCountExceptionTest() {
        // Given
        String input = "five";

        // When & Then
        assertThatThrownBy(() -> Application.getMovementCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(8)
    @DisplayName("범위 내 랜덤 숫자를 생성한다")
    void getRandomNumberTest() {
        Integer randomNumber = Application.getRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @Order(9)
    @DisplayName("숫자가 4 이상인 경우 true를 반환하고, 그렇지 않으면 false를 반환한다")
    void isValidNumberTest() {
        assertThat(Application.isValidNumber(4)).isTrue();
        assertThat(Application.isValidNumber(3)).isFalse();
    }

    @Test
    @Order(10)
    @DisplayName("자동차 이름 리스트를 받아 자동차 객체 리스트를 생성한다")
    void createCarsTest() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        List<Car> cars = Application.createCars(carNames);

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @Test
    @Order(11)
    @DisplayName("가장 먼 거리를 이동한 자동차들을 우승자로 선정한다")
    void getWinnersTest() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.addDistance();
        car1.addDistance();
        car2.addDistance();
        car3.addDistance();
        car3.addDistance();

        List<Car> cars = Arrays.asList(car1, car2, car3);

        String winners = Application.getWinners(cars);
        assertThat(winners).isEqualTo("car1,car3");
    }

    @Test
    @DisplayName("유효한 무작위 숫자가 생성되면 자동차가 이동 거리를 증가시킨다")
    void moveCarsTest() {
        // Given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = List.of(car1, car2);

        // 무작위 숫자 리스트 (4 이상은 이동, 3 이하는 이동하지 않음)
        List<Integer> randomNumbers = List.of(4, 3);

        // When
        Application.moveCars(cars, randomNumbers);

        // Then
        assertThat(car1.getDistance()).isEqualTo(1);  // 유효한 숫자 4로 이동
        assertThat(car2.getDistance()).isEqualTo(0);  // 유효하지 않은 숫자 3으로 이동하지 않음
    }

    @Test
    @DisplayName("자동차 이름과 이동 거리를 출력 형식에 맞게 출력한다")
    void showCarDistancesTest() {
        // Given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.addDistance();
        car1.addDistance(); // 이동 거리 2
        car2.addDistance(); // 이동 거리 1
        List<Car> cars = List.of(car1, car2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        Application.showCarDistances(cars);

        // Then
        String output = outputStream.toString().trim();
        assertThat(output).isEqualTo("car1 : --\ncar2 : -");

        // Reset System.out
        System.setOut(System.out);
    }
}

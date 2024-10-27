package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
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
        List<String> carNames = Application.getCarNames();

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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5 글자 사이여야 합니다.");
    }

    @Test
    @Order(6)
    @DisplayName("입력된 이동 횟수를 올바르게 반환한다")
    void getMovementCountTest() {
        String input = "5";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        Integer movementCount = Application.getMovementCount();
        assertThat(movementCount).isEqualTo(5);
    }

    @Test
    @Order(7)
    @DisplayName("숫자가 아닌 이동 횟수를 입력하면 예외를 발생시킨다")
    void getMovementCountExceptionTest() {
        String input = "five";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(Application::getMovementCount)
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
}

package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.observer.CarMovePrinter;
import racingcar.output.OutputHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("pobi", "woni", "jjj");
        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("Cars 객체 생성 시, 올바른 개수의 Car 객체가 생성되어야 한다.")
    void createCars_correctNumberOfCars() {
        // then
        assertEquals(3, cars.size(), "자동차의 개수가 올바르게 설정되어야 합니다.");
    }

    @Test
    @DisplayName("moveAll 메서드가 올바르게 동작하여 자동차들이 이동해야 한다.")
    void moveAll_carsMoveCorrectly() {
        // given
        List<Integer> randomValues = List.of(4, 3, 5);

        // when
        cars.moveAll(randomValues);

        // then
        assertEquals(2, cars.getWinners().size(), "두 대의 자동차가 이동해야 합니다.");
        assertEquals(1, cars.getWinners().getFirst().getPosition(), "최대 한 번 움직일 수 있습니다.");
    }

    @Test
    @DisplayName("moveAll 호출 시, 랜덤 값의 개수와 자동차 개수가 다르면 예외가 발생한다.")
    void moveAll_throwsExceptionWhenRandomValuesSizeMismatch() {
        // given
        List<Integer> randomValues = List.of(4, 3); // 자동차 개수보다 적은 랜덤 값 개수

        // when & then
        assertThrows(IllegalStateException.class,
                () -> cars.moveAll(randomValues),
                "랜덤 값의 개수와 자동차 개수가 일치하지 않으면 예외가 발생해야 합니다.");
    }

    @Test
    @DisplayName("addObserverToAll 메서드를 올바른 매개변수로 호출하면 예외가 발생하지 않는다.")
    void addObserverToAll_noExceptionThrown() {
        // given
        OutputHandler outputHandler = new OutputHandler();

        // when & then
        assertDoesNotThrow(() -> cars.addObserverToAll(CarMovePrinter.class, outputHandler),
                "올바른 매개변수와 함께 addObserverToAll 호출 시 예외가 발생하지 않아야 합니다.");
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승자로 선택되어야 한다.")
    void getWinners_returnsCorrectWinners() {
        // given
        cars.moveAll(List.of(6, 5, 3)); // 두 대의 자동차가 이동

        // when
        List<Car> winners = cars.getWinners();

        // then
        assertEquals(2, winners.size(), "가장 멀리 이동한 자동차가 우승자로 선택되어야 합니다.");
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("pobi")), "pobi는 우승자여야 합니다.");
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("woni")), "woni는 우승자여야 합니다.");
    }
}
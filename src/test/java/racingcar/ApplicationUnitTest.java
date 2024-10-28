package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.*;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationUnitTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void testGetCarNames() {
        assertSimpleTest(() -> {
            // run 메서드에 입력을 순차적으로 전달
            run("pobi,woni,jun");
            List<String> carNames = Application.getCarNames();
            assertThat(carNames).containsExactly("pobi", "woni", "jun");
        });
    }

    @Test
    void testGetTotalRaceCount() {
        assertSimpleTest(() -> {
            // 두 번째 입력만 필요하므로 시도 횟수를 제공
            run("5");
            int totalRaceCount = Application.getTotalRaceCount();
            assertThat(totalRaceCount).isEqualTo(5);
        });
    }

    @Test
    void testIsValidCarNames() {
        assertSimpleTest(() -> {
            // 유효한 이름이 없는 경우 예외 발생
            assertThatThrownBy(() -> Application.isValidCarNames(null))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> Application.isValidCarNames(Collections.emptyList()))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> Application.isValidCarNames(Arrays.asList("", "", "")))
                    .isInstanceOf(IllegalArgumentException.class);

            // 중복된 이름이 있는 경우 예외 발생
            assertThatThrownBy(() -> Application.isValidCarNames(Arrays.asList("pobi", "pobi", "jun")))
                    .isInstanceOf(IllegalArgumentException.class);

            // 이름 길이가 잘못된 경우 예외 발생
            assertThatThrownBy(() -> Application.isValidCarNames(Arrays.asList("pobi", "longName", "jun")))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void testIsValidTotalRaceCount() {
        assertSimpleTest(() -> {
            // 숫자가 아닌 입력 테스트
            assertThatThrownBy(() -> Application.isValidTotalRaceCount("abc"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> Application.isValidTotalRaceCount(" "))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> Application.isValidTotalRaceCount("!@#"))
                    .isInstanceOf(IllegalArgumentException.class);

            // 음수 또는 0 입력 테스트
            assertThatThrownBy(() -> Application.isValidTotalRaceCount("-1"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> Application.isValidTotalRaceCount("0"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> Application.isValidTotalRaceCount("1.1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void testCreateCars() {
        assertSimpleTest(() -> {
            List<String> carNames = Arrays.asList("pobi", "woni", "jun");
            List<Car> cars = Application.createCars(carNames);
            assertThat(cars).hasSize(3);
            assertThat(cars).extracting(Car::getCarName)
                    .containsExactly("pobi", "woni", "jun");
        });
    }

    @Test
    void testMoveCar() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            Application.moveCar(car);
            assertThat(car.getCarPosition()).isEqualTo(1);
        }, MOVING_FORWARD);
    }

    @Test
    void testMoveCarStops() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            Application.moveCar(car);
            assertThat(car.getCarPosition()).isEqualTo(0);
        }, STOP);
    }

    @Test
    void testFindMaxPosition() {
        assertSimpleTest(() -> {
            Car car1 = new Car("pobi");
            Car car2 = new Car("woni");
            car2.moveOnePosition();
            List<Car> cars = Arrays.asList(car1, car2);
            int maxPosition = Application.findMaxPosition(cars);
            assertThat(maxPosition).isEqualTo(1);
        });
    }

    @Test
    void testFindWinners() {
        assertSimpleTest(() -> {
            Car car1 = new Car("pobi");
            Car car2 = new Car("woni");
            car2.moveOnePosition();
            Car car3 = new Car("jun");
            car3.moveOnePosition();
            List<Car> cars = Arrays.asList(car1, car2, car3);
            List<String> winners = Application.findWinners(cars);
            assertThat(winners).containsExactly("woni", "jun");
        });
    }

    @Test
    void testPrintWinners() {
        assertSimpleTest(() -> {
            List<String> winners = Arrays.asList("pobi", "woni");
            Application.printWinners(winners);
            assertThat(output()).contains("최종 우승자 : pobi, woni");
        });
    }

    @Override
    public void runMain() {

    }
}
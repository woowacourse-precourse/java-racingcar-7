package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력한 자동차 이름이 5자 이상일 경우 IllegalArgumentException가 발생해야한다.")
    void should_ThrowException_when_Over5Length() {
        String input = "pobiwoni, pobi, woni";
        assertThrows(IllegalArgumentException.class, () -> {
            Application.makeCars(input);
        });
    }

    @Test
    @DisplayName("입력 포맷이 적절하지 않을 경우 IllegalArgumentException가 발생해야한다.")
    void should_ThrowException_when_InvalidInputFormat() {
        assertAll(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        Application.setStage("abc");
                    });
                },
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        Application.setStage("-5");
                    });
                }
        );
    }

    @Test
    @DisplayName("4 이상의 숫자를 뽑으면 자동차가 전진해야 한다.")
    void should_MoveForward_When_RandomNumberIs4OrMore() {
        Car car = new Car("pobi");

        int initialStep = car.getStep();
        car.move(4);
        assertThat(initialStep + 1).isEqualTo(car.getStep());

        car.move(5);
        assertThat(initialStep + 2).isEqualTo(car.getStep());
    }

    @Test
    @DisplayName("4 미만의 숫자를 뽑으면 자동차가 전진하지 않아야 한다.")
    void should_NotMove_When_RandomNumberIsLessThan4() {
        Car car = new Car("woni");

        int initialStep = car.getStep();
        car.move(3);
        assertThat(initialStep).isEqualTo(car.getStep());

        car.move(0);
        assertThat(initialStep).isEqualTo(car.getStep());
    }

    @Test
    @DisplayName("전진횟수가 가장 많은 자동차의 이름을 반환해야 한다.")
    void should_ReturnWinners_When_CarsHaveDifferentSteps() {
        Car car1 = new Car("pobi");
        car1.move(4);
        car1.move(3); // 전진 횟수 1

        Car car2 = new Car("woni");
        car2.move(4);
        car2.move(4); // 전진 횟수 2

        Car car3 = new Car("jun");
        car3.move(3); // 전진 횟수 0

        List<Car> cars = Arrays.asList(car1, car2, car3);

        String winners = Application.getWinners(cars);

        assertThat(winners).isEqualTo("woni");
    }

    @Test
    @DisplayName("전진횟수가 가장 많은 자동차가 여러개라면 각각의 이름을 쉼표로 구분하여 반환해야 한다.")
    void should_ReturnWinners_When_MultipleCarsHaveMaxSteps() {
        Car car1 = new Car("pobi");
        car1.move(4);
        car1.move(4); // 전진 횟수 2

        Car car2 = new Car("woni");
        car2.move(4);
        car2.move(4); // 전진 횟수 2

        Car car3 = new Car("jun");
        car3.move(3); // 전진 횟수 0

        List<Car> cars = Arrays.asList(car1, car2, car3);

        String winners = Application.getWinners(cars);

        assertThat(winners).isEqualTo("pobi, woni");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final Separator separator = new Separator();
    private final Racing racing = new Racing();

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
    @DisplayName("이름이 5자 보다 크면 예외 발생")
    void 이름_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열을 분리한다")
    void 구분자_테스트() {
        String input = "pobi,woni,jun";

        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> result = separator.separate(input);

        assertThat(expected).isEqualTo(result);
    }

    @Test
    @DisplayName("이름과 이름 사이에 공백이 있을 경우 제거된 상태로 반환")
    void 이름_공백_테스트() {
        String input = " pobi , woni,    jun";

        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> result = separator.separate(input);

        assertThat(expected).isEqualTo(result);
    }

    @Test
    @DisplayName("이름 리스트를 Car 객체 리스트로 변환")
    void 자동차_초기화_테스트() {
        List<String> names = List.of("pobi", "woni");
        List<Car> cars = racing.initializeCars(names);

        assertThat(cars.size()).isEqualTo(2);

        Car firstCar = cars.get(0);
        assertThat(firstCar.getName()).isEqualTo("pobi");

        Car secondCar = cars.get(1);
        assertThat(secondCar.getName()).isEqualTo("woni");
    }

    @Test
    @DisplayName("4 이상일 떄 true를 반환하는지 확인")
    void 이동_조건_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThat(racing.isMovable()).isTrue(),
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("이동 횟수에 따라 대시를 생성 확인")
    void 대시_생성_테스트() {
        Car car = new Car("pobi");
        car.incrementMoveCount();
        car.incrementMoveCount();

        String dashLine = racing.generateDashLine(car);
        assertThat(dashLine).isEqualTo("--");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

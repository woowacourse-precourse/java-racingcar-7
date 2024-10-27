package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("쉼표로 구분된 문자열로 자동차들을 생성한다")
    @Test
    void createCarsFromInput() {
        Cars cars = new Cars("pobi,woni");
        List<String> names = cars.getCars().stream()
                .map(Car::getName)
                .toList();

        assertThat(names).containsExactly("pobi", "woni");
    }

    @DisplayName("쉼표만 있는 문자열은 예외를 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {",", ",,,", ", ,"})
    void createCarsWithOnlyComma(String input) {
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("우승자가 여러 명일 수 있다")
    @Test
    void multipleWinners() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars("pobi,woni");
                    cars.moveAll();
                    List<String> winners = cars.getWinners();

                    assertThat(winners).hasSize(2)
                            .containsExactlyInAnyOrder("pobi", "woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
}

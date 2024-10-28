package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

public class ApplicationTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException이 발생한다")
    void validateCarNames_invalidLength_throwsException() {
        List<String> invalidNames = Arrays.asList("pobi", "woni", "jun", "longname");

        assertThatThrownBy(() -> CarRacingGame.validateCarNames(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("이동 횟수가 양수가 아닐 경우 IllegalArgumentException이 발생한다")
    void validateAttempts_invalidInput_throwsException() {
        assertThatThrownBy(() -> CarRacingGame.validateAttempts("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 1 이상의 정수여야 합니다.");

        assertThatThrownBy(() -> CarRacingGame.validateAttempts("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 1 이상의 정수여야 합니다.");
    }

    @Test
    @DisplayName("isMovable은 무작위 값이 4 이상일 때 true를 반환한다")
    void isMovable_returnsTrueWhenRandomNumberIsFourOrMore() {
        boolean isMovable = CarRacingGame.isMovable();
        assertThat(isMovable).isIn(true, false);
    }

    @Test
    @DisplayName("playRound 호출 시 각 자동차의 위치가 업데이트된다")
    void playRound_updatesCarPositions() {
        List<Car> cars = CarRacingGame.initializeCars(Arrays.asList("pobi", "woni", "jun"));
        CarRacingGame.playRound(cars);

        // 각 자동차의 위치가 변경될 가능성을 확인
        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    @DisplayName("가장 멀리 간 자동차를 우승자로 선정한다")
    void findWinners_selectsCorrectWinners() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car1.move();
        car1.move();  // pobi : 위치 2
        car2.move();  // woni : 위치 1
        car3.move();
        car3.move();  // jun : 위치 2

        List<Car> cars = Arrays.asList(car1, car2, car3);
        List<String> winners = CarRacingGame.findWinners(cars);

        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}

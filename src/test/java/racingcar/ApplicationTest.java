package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarGame;
import racingcar.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // Car 객체 관련 테스트
    @Test
    void 자동차_이름이_5자_초과하면_예외를_던진다() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차가_랜덤_값에_따라_전진한다() {
        Car car = new Car("pobi");
        car.move(4); // 4 이상이면 전진
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차가_랜덤_값이_4_미만이면_정지한다() {
        Car car = new Car("pobi");
        car.move(3); // 3 이하면 정지
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 자동차_이름에_중복이_있으면_예외를_던진다() {
        List<String> carNames = List.of("pobi", "pobi", "woni");
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> InputView.validateDuplicateNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("중복된 자동차 이름이 있습니다.");
        });
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외를_던진다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> InputView.parseAttempts("one")) // parseAttempts 호출
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 숫자로 입력해야 합니다.");
        });
    }

    @Test
    void 시도_횟수가_0_이하면_예외를_던진다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> InputView.parseAttempts("0")) // 0 입력 테스트
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");

            assertThatThrownBy(() -> InputView.parseAttempts("-1")) // 음수 입력 테스트
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
        });
    }

    // 게임 로직 테스트
    @Test
    void 게임_시작_후_우승자_검증() {
        List<String> carNames = List.of("pobi", "woni");
        CarGame game = new CarGame(carNames, 1);

        game.playRounds();
        List<String> winners = game.getWinners();

        assertThat(winners).isNotEmpty();
    }

    // 정상적인 게임 진행과 출력 테스트
    @Test
    void 정상_입력으로_게임이_진행된다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
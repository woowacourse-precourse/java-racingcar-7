package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ConsoleView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameControllerTest extends NsTest {

    @DisplayName("정상적인 입력으로 게임이 완료된다")
    @Test
    void startGameWithValidInput() {
        assertSimpleTest(() -> {
            ConsoleView view = new ConsoleView();
            GameController controller = new GameController(view);

            runAndAssertInput("pobi,woni", "3");
            assertThat(output()).contains(
                    "실행 결과",
                    "pobi :",
                    "woni :",
                    "최종 우승자 :"
            );
        });
    }

    @DisplayName("잘못된 자동차 이름 입력시 예외가 발생한다")
    @Test
    void startGameWithInvalidCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runAndAssertInput("pobi,woni,javajava", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름이 5글자를 초과")
        );
    }

    @DisplayName("잘못된 시도 횟수 입력시 예외가 발생한다")
    @Test
    void startGameWithInvalidMovement() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runAndAssertInput("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도횟수가 0 이하")
        );
    }

    @DisplayName("중복된 자동차 이름 입력시 예외가 발생한다")
    @Test
    void startGameWithDuplicateNames() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runAndAssertInput("pobi,pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름이 중복")
        );
    }

    private void runAndAssertInput(String carNames, String movements) {
        run(carNames, movements);
    }

    @Override
    protected void runMain() {
        ConsoleView view = new ConsoleView();
        GameController controller = new GameController(view);
        controller.startGame();
    }
}
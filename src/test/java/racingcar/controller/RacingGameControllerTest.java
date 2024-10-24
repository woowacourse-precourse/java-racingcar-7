package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.view.ErrorMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameControllerTest {

    private TestInputView inputView;
    private TestOutputView outputView;
    private RacingGameController controller;

    @BeforeEach
    void setUp() {
        inputView = new TestInputView();
        outputView = new TestOutputView();
        controller = new RacingGameController(inputView, outputView);
    }

    @Test
    void testRun_WithValidInput() {
        // Given: 유효한 자동차 이름과 시도 횟수
        inputView.setInput("pobi,woni,jun\n5");

        // When: 게임 실행
        controller.run();

        // Then: 출력이 발생했는지 확인 (구체적인 내용은 검증하지 않음)
        String output = outputView.getPrintedOutput();
        assertTrue(output.contains("실행 결과"));
        assertTrue(output.contains("최종 우승자"));
    }

    @Test
    void testRun_WithCarNamesExceedingFiveCharacters_ShouldThrowException() {
        // Given: 자동차 이름이 5자를 초과할 경우
        inputView.setInput("Ferrari,pobi,woni\n5");

        // When & Then: 예외 발생 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.run();
        });

        assertEquals(ErrorMessage.NAME_TOO_LONG.getMessage(), exception.getMessage());
    }

    @Test
    void testRun_WithDuplicateCarNames_ShouldThrowException() {
        // Given: 중복된 자동차 이름
        inputView.setInput("pobi,woni,pobi\n5");

        // When & Then: 예외 발생 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.run();
        });

        assertEquals(ErrorMessage.DUPLICATE_NAME.getMessage(), exception.getMessage());
    }

    @Test
    void testRun_WithEmptyCarNames_ShouldThrowException() {
        // Given: 자동차 이름이 빈 경우
        inputView.setInput(" , , \n5");

        // When & Then: 예외 발생 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.run();
        });

        assertEquals(ErrorMessage.EMPTY_CAR_NAMES.getMessage(), exception.getMessage());
    }

    @Test
    void testRun_WithNegativeTryCount_ShouldThrowException() {
        // Given: 시도 횟수가 음수인 경우
        inputView.setInput("pobi,woni,jun\n-3");

        // When & Then: 예외 발생 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.run();
        });

        assertEquals(ErrorMessage.INVALID_TRY_COUNT.getMessage(), exception.getMessage());
    }

    // TestInputView 클래스
    static class TestInputView extends InputView {
        private String input;

        public void setInput(String input) {
            this.input = input;
        }

        @Override
        public String inputCarNames() {
            return input.split("\n")[0];
        }

        @Override
        public String inputTryCount() {
            return input.split("\n")[1];
        }
    }

    // TestOutputView 클래스
    static class TestOutputView extends OutputView {
        private StringBuilder printedOutput = new StringBuilder();

        @Override
        public void printResultHeader() {
            printedOutput.append("실행 결과\n");
        }

        @Override
        public void printRaceResults(List<RacingCar> racingCars) {
            for (RacingCar car : racingCars) {
                String positionDisplay = "-".repeat(car.getPosition());
                printedOutput.append(car.getName()).append(" : ").append(positionDisplay).append("\n");
            }
        }

        @Override
        public void printWinners(List<RacingCar> winners) {
            String winnerNames = winners.stream()
                    .map(RacingCar::getName)
                    .collect(Collectors.joining(", "));
            printedOutput.append("최종 우승자: ").append(winnerNames).append("\n");
        }

        public String getPrintedOutput() {
            return printedOutput.toString();
        }
    }

}

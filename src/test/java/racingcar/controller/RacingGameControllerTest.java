package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({
            "'pobi,woni,jun\n5'",
            "'car1,car2,car3\n3'"
    })
    void testRun_WithValidInput(String input) {
        // Given: 유효한 자동차 이름과 시도 횟수
        setInputAndRun(input);
        // Then: 출력이 예상대로 발생했는지 확인
        String output = outputView.getPrintedOutput();
        assertTrue(output.contains("실행 결과"), "출력에 '실행 결과'가 포함되어야 합니다.");
        assertTrue(output.contains("최종 우승자"), "출력에 '최종 우승자'가 포함되어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "'Ferrari,pobi,woni\n5', NAME_TOO_LONG",
            "'pobi,woni,pobi\n5', DUPLICATE_NAME",
            "' , , \n5', EMPTY_CAR_NAMES",
            "'pobi,woni,jun\n-3', INVALID_TRY_COUNT"
    })
    void testRun_WithInvalidInput_ShouldThrowException(String input, String errorMessage) {
        // Given: 잘못된 입력
        inputView.setInput(input);
        // When & Then: 예외 발생 확인
        assertExceptionMessage(errorMessage);
    }

    private void setInputAndRun(String input) {
        inputView.setInput(input);
        controller.run();
    }


    private void assertExceptionMessage(String errorMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> controller.run());
        assertEquals(ErrorMessage.valueOf(errorMessage).getMessage(), exception.getMessage());
    }

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

    static class TestOutputView extends OutputView {
        private final StringBuilder printedOutput = new StringBuilder();

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

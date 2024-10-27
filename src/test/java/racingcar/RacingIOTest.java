package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingIOTest {
    private RacingService racingService;

    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        racingService = new RacingService("a,b,c", 4);

        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(standardOut);
        System.out.println(getOutput());
    }

    @Test
    @DisplayName("시작 부분이 출력 형식을 준수하는지 확인")
    void 시작_부분_출력_테스트() {
        RacingIO.promptCarNamesInput();
        RacingIO.promptMoveCountInput();
        assertThat(getOutput()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        assertThat(getOutput()).contains("시도할 횟수는 몇 회인가요?");
    }

    @Test
    @DisplayName("실행 결과가 출력 형식을 준수하는지 확인")
    void 실행_결과_출력_테스트() {
        ArrayList<HashMap<String, Integer>> turnResults = new ArrayList<>();

        updateAndRecordMovement("a", 4, turnResults);
        updateAndRecordMovement("a", 4, turnResults);
        updateAndRecordMovement("a", 4, turnResults);
        updateAndRecordMovement("b", 1, turnResults);
        updateAndRecordMovement("b", 4, turnResults);
        updateAndRecordMovement("c", 1, turnResults);

        RacingIO.promptTurnResult(turnResults);
        assertThat(getOutput()).contains("실행 결과");
        assertThat(getOutput()).contains("a : -");
        assertThat(getOutput()).contains("a : --");
        assertThat(getOutput()).contains("a : ---");
        assertThat(getOutput()).contains("b : ");
        assertThat(getOutput()).contains("b : -");
        assertThat(getOutput()).contains("c : ");
    }

    private void updateAndRecordMovement(String carName, int randomValue, ArrayList<HashMap<String, Integer>> turnResults) {
        racingService.updateMovement(carName, randomValue);
        turnResults.add(new HashMap<>(racingService.getCarMap()));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }
}

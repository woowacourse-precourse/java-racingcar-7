package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingIOTest {
    private RacingService racingService;

    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        racingService = new RacingService("a,b,c", "4");

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
        LinkedList<LinkedHashMap<String, Integer>> turnResults = new LinkedList<>();

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

    @Test
    @DisplayName("우승자 결과가 출력 형식을 준수하는지 확인")
    void 우승자_출력_테스트1() {
        LinkedList<LinkedHashMap<String, Integer>> turnResults = new LinkedList<>();

        updateAndRecordMovement("a", 4, turnResults);
        updateAndRecordMovement("a", 4, turnResults);
        updateAndRecordMovement("b", 4, turnResults);
        updateAndRecordMovement("b", 4, turnResults);

        RacingIO.promptWinner(racingService.getWinners());

        assertThat(getOutput()).contains("최종 우승자 : a, b");
    }

    @Test
    @DisplayName("우승자가 여러 명일 때 우승자 입력 순서대로 출력하는 지 확인")
    void 우승자_출력_테스트2() {
        racingService.setCarNameInput("a,aa,aaa");
        LinkedList<LinkedHashMap<String, Integer>> turnResults = new LinkedList<>();

        updateAndRecordMovement("a", 4, turnResults);
        updateAndRecordMovement("a", 4, turnResults);
        updateAndRecordMovement("aa", 4, turnResults);
        updateAndRecordMovement("aa", 4, turnResults);
        updateAndRecordMovement("aaa", 4, turnResults);
        updateAndRecordMovement("aaa", 4, turnResults);

        RacingIO.promptWinner(racingService.getWinners());

        assertThat(getOutput()).contains("최종 우승자 : a, aa, aaa");
    }

    private void updateAndRecordMovement(String carName, int randomValue, LinkedList<LinkedHashMap<String, Integer>> turnResults) {
        racingService.updateMovement(carName, randomValue);
        turnResults.add(new LinkedHashMap<>(racingService.getCarMap()));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }
}

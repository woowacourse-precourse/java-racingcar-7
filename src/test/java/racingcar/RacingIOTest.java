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
    @DisplayName("초기 입력 프롬프트가 출력 형식을 준수하는지 확인")
    void 초기_입력_프롬프트_테스트() {
        RacingIO.promptCarNameInput();
        RacingIO.promptMaxTurnInput();

        assertThat(getOutput()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        assertThat(getOutput()).contains("시도할 횟수는 몇 회인가요?");
    }

    @Test
    @DisplayName("각 턴의 실행 결과가 출력 형식을 준수하는지 확인")
    void 실행_결과_출력_형식_테스트() {
        LinkedList<LinkedHashMap<String, Integer>> raceResult = new LinkedList<>();

        updateAndRecordMovement("a", 4, raceResult);
        updateAndRecordMovement("a", 4, raceResult);
        updateAndRecordMovement("b", 4, raceResult);
        updateAndRecordMovement("c", 1, raceResult);

        RacingIO.printRaceResult(raceResult);

        assertThat(getOutput()).contains("실행 결과");
        assertThat(getOutput()).contains("a : -");
        assertThat(getOutput()).contains("a : --");
        assertThat(getOutput()).contains("b : -");
        assertThat(getOutput()).contains("c : ");
    }

    @Test
    @DisplayName("우승자 결과가 출력 형식을 준수하는지 확인")
    void 우승자_출력_형식_테스트() {
        LinkedList<LinkedHashMap<String, Integer>> raceResult = new LinkedList<>();

        updateAndRecordMovement("a", 4, raceResult);
        updateAndRecordMovement("b", 4, raceResult);

        RacingIO.promptWinner(racingService.getWinners());

        assertThat(getOutput()).contains("최종 우승자 : a, b");
    }

    @Test
    @DisplayName("우승자가 여러 명일 때 우승자 입력 순서대로 출력하는지 확인")
    void 우승자_출력_순서_테스트() {
        racingService.setCarNameInput("a,aa,aaa");
        LinkedList<LinkedHashMap<String, Integer>> raceResult = new LinkedList<>();

        updateAndRecordMovement("a", 4, raceResult);
        updateAndRecordMovement("aa", 4, raceResult);
        updateAndRecordMovement("aaa", 4, raceResult);

        RacingIO.promptWinner(racingService.getWinners());

        assertThat(getOutput()).contains("최종 우승자 : a, aa, aaa");
    }

    private void updateAndRecordMovement(String carName, int randomValue, LinkedList<LinkedHashMap<String, Integer>> raceResult) {
        racingService.moveCar(carName, randomValue);
        raceResult.add(new LinkedHashMap<>(racingService.getCarPositions()));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }
}

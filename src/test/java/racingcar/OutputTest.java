package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest extends NsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent)); // System.out을 ByteArrayOutputStream으로 리다이렉트
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut); // System.out을 원래대로 복구
    }

    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @Test
    @DisplayName("경주할 자동차 이름 입력 요청 메세지 출력")
    void printCarNameRequestMessage_MethodCall_ShouldPrintCarNameRequestMessage() {
        //when
        Output.printCarNameRequestMessage();

        //then
        assertThat(outContent.toString().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        outContent.reset(); // 매 테스트 후 출력 리셋
    }

    @Test
    @DisplayName("시도할 횟수 입력 요청 메세지 출력")
    void printNumberRequestMessage_MethodCall_ShouldPrintNumberRequestMessage() {
        //when
        Output.printNumberRequestMessage();

        //then
        assertThat(outContent.toString().trim())
                .isEqualTo("시도할 횟수는 몇 회인가요?");
        outContent.reset(); // 매 테스트 후 출력 리셋
    }

    @Test
    @DisplayName("줄바꿈 및 실행 결과 문자열 출력")
    void printRunResultMessage_MethodCall_ShouldPrintRunResultMessage() {
        //when
        Output.printRunResultMessage();

        //then
        assertThat(outContent.toString().trim())
                .isEqualTo("\\n실행 결과");
        outContent.reset(); // 매 테스트 후 출력 리셋
    }

    @Test
    @DisplayName("실행 결과 출력")
    void printRunResult_InputtedCarNameList_ShouldPrintRunResult() {
        //given
        String expectedMessage = "Ahn : -\r\nSeong : \r\nMo : -";
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("Ahn");
        Car car2 = new Car("Seong");
        Car car3 = new Car("Mo");

        car1.move(Movement.GO);
        car2.move(Movement.STOP);
        car3.move(Movement.GO);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        //when
        Output.printRunResult(carList);

        //then
        assertThat(outContent.toString().trim())
                .isEqualTo(expectedMessage);
        outContent.reset(); // 매 테스트 후 출력 리셋
    }

    @Test
    @DisplayName("최종 우승자 출력")
    void printFinalWinner_InputtedCarNameList_ShouldPrintFinalWinner() {
        //given
        String expectedMessage = "최종 우승자 : Ahn, Mo";
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("Ahn");
        Car car2 = new Car("Mo");

        carList.add(car1);
        carList.add(car2);

        //when
        Output.printFinalWinner(carList);

        //then
        assertThat(outContent.toString().trim())
                .isEqualTo(expectedMessage);
        outContent.reset(); // 매 테스트 후 출력 리셋
    }
}

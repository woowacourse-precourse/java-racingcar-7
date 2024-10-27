package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.SystemView.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SystemViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // 출력 스트림을 가로채기 위해 System.out 재설정
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        // 테스트가 끝난 후 원래 출력 스트림으로 복원
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("이름 입력 안내 문구 출력")
    void printSystemNameInputMessageTest() {
        //given

        //when
        printSystemNameInputMessage();
        //then
        assertThat(outContent.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도 횟수 안내 문구 출력")
    void printSystemInputTrialMessageTest() {
        //given

        //when
        printSystemInputTrialMessage();
        //then
        assertThat(outContent.toString()).contains("시도할 횟수는 몇 회인가요?");
    }

    @Test
    @DisplayName("실행 결과 안내 문구 출력")
    void printSystemRaceStartMessageTest() {
        //given

        //when
        printSystemRaceStartMessage();
        //then
        assertThat(outContent.toString()).contains("실행 결과");

    }

    @Test
    @DisplayName("최종 우승 안내 문구 출력")
    void printSystemWinneMessageTest() {
        //given

        //when
        printSystemWinneMessage();
        //then
        assertThat(outContent.toString()).contains("최종 우승 : ");
    }

}
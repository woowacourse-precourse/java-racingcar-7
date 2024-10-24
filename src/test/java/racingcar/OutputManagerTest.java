package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputManagerTest {

    private static final String GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void rollback() {
        System.setOut(standardOut);
    }

    @DisplayName("사용자에게 가이드 메시지를 출력해야 한다.")
    @Test
    public void printGuidMessage() {

        //given
        OutputManager.printGuideMessage();

        //when
        String printMessage = getOutput();

        //then
        assertThat(printMessage).isEqualTo(GUIDE_MESSAGE);
    }

    private String getOutput() {
        return captor.toString().trim();
    }

    @DisplayName("최종 우승자가 한명이면 “최종 우승자 : 우승자_이름” 형태로 출력한다")
    @Test
    void printWinner() {

        //given
        List<String> winnerList = new ArrayList<>();
        String winner = "winner1";

        winnerList.add(winner);

        //when
        OutputManager.printWinner(winnerList);
        String result = getOutput();

        //then
        assertThat(result).isEqualTo("최종 우승자 : " + winner);
    }

    @DisplayName("최종 우승자가 두명 이상이면 우승자 이름 사이 콤마와 공백이 포함된 문자열이 출력된다.")
    @Test
    void printWinners() {

        //given
        List<String> winnerList = new ArrayList<>();
        String winner1 = "winner1";
        String winner2 = "winner2";

        winnerList.add(winner1);
        winnerList.add(winner2);

        //when
        OutputManager.printWinner(winnerList);
        String result = getOutput();

        //then
        assertThat(result).isEqualTo("최종 우승자 : " + winner1 + ", " + winner2);
    }

}
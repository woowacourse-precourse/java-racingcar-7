package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgressAndResultOutputTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }


    @DisplayName("진행상황 시작 메시지 확인")
    @Test
    void checkStartProgressPrompt(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ProgressAndResultOutput progressAndResultOutput = new ProgressAndResultOutput();

        progressAndResultOutput.startProgressOutput();

        assertEquals("\n실행 결과\n", outputStream.toString());
    }
    @DisplayName("진행상황 출력값 확인")
    @Test
    void checkProgressOutput(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ProgressAndResultOutput progressAndResultOutput = new ProgressAndResultOutput();

        progressAndResultOutput.displayRoundProgress(Arrays.asList("po", "bi", "pobi"), Arrays.asList(1, 2, 3));

        assertEquals("po : -\nbi : --\npobi : ---\n\n", outputStream.toString());
    }
    @DisplayName("우승자 출력 및 메시지 확인")
    @Test
    void checkWinnerOutput(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ProgressAndResultOutput progressAndResultOutput = new ProgressAndResultOutput();

        progressAndResultOutput.winnerOutput(Arrays.asList("pobi", "po"));

        assertEquals("최종 우승자 : pobi, po\n", outputStream.toString());
    }
}

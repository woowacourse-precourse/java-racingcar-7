package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OutputTest {

    private Output output;

    @BeforeEach
    void setUp() {
        output = new Output();
    }

    @Test
    void printProgressByStage_진행상태_출력_테스트() {
        HashMap<String, Integer> raceStatus = new HashMap<>();
        raceStatus.put("pobi", 3);
        raceStatus.put("crong", 2);

        // System.out의 출력을 캡처하기 위해 ByteArrayOutputStream 사용
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        output.printProgressByStage(raceStatus);

        String outputString = outContent.toString();
        assertTrue(outputString.contains("pobi : ---"));
        assertTrue(outputString.contains("crong : --"));
    }

    @Test
    void printWinners_우승자_출력_테스트() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("crong");

        // System.out의 출력을 캡처하기 위해 ByteArrayOutputStream 사용
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        output.printWinners(winners);

        String outputString = outContent.toString();
        assertTrue(outputString.contains("최종 우승자 : pobi,crong"));
    }
}

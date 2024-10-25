package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    // 기존의 System.out을 저장할 변수
    private final PrintStream originalOut = System.out;
    // 출력 내용을 담을 ByteArrayOutputStream
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // System.out을 ByteArrayOutputStream으로 리디렉션
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        // 테스트가 끝나면 System.out을 원래대로 복구
        System.setOut(originalOut);
    }

    @Test
    void 우승자_출력() {
        OutputView outputView = new OutputView();

        ArrayList<String> winners = new ArrayList<>();
        winners.add("진용");

        outputView.outputWinner(winners);
        Assertions.assertEquals("최종 우승자 : 진용", outputStreamCaptor.toString().trim());

    }

    @Test
    void 우승자_출력_여러_명() {
        OutputView outputView = new OutputView();

        ArrayList<String> winners = new ArrayList<>();
        winners.add("진용");
        winners.add("순신");
        winners.add("길동");

        outputView.outputWinner(winners);
        Assertions.assertEquals("최종 우승자 : 진용, 순신, 길동", outputStreamCaptor.toString().trim());
    }

    @Test
    void 자동차_전진_횟수_출력() {
        OutputView outputView = new OutputView();

        LinkedHashMap<String, Integer> carMoves = new LinkedHashMap<>();
        carMoves.put("진용", 3);
        carMoves.put("순신", 4);
        carMoves.put("길동", 1);

        outputView.outputCarMoves(carMoves);

        Assertions.assertEquals("진용 : ---\n순신 : ----\n길동 : -", outputStreamCaptor.toString().trim());

    }

}
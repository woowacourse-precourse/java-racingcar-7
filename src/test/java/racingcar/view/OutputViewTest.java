package racingcar.view;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void 우승자_출력() {
        OutputView outputView = new OutputView();
        ArrayList<String> winners = new ArrayList<>();
        winners.add("진용");

        Assertions.assertEquals("진용", outputView.outputWinner(winners));
    }

    @Test
    void 우승자_출력_여러_명() {
        OutputView outputView = new OutputView();
        ArrayList<String> winners = new ArrayList<>();
        winners.add("진용");
        winners.add("순신");

        Assertions.assertEquals("진용, 순신", outputView.outputWinner(winners));
    }

}
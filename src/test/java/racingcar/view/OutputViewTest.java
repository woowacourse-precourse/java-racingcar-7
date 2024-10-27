package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printWinner() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("woni");
        winners.add("jun");

        String expect = "pobi, woni, jun";
        assertEquals(String.join(", ", winners), expect);
    }
}
package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    private Winner winner;

    @BeforeEach
    void setUp() {
        winner = new Winner();
    }

    @Test
    void 우승자가_여러명일_경우_자동차_이름_입력순으로_보여준다() {
        Map<String, StringBuilder> result = new LinkedHashMap<>();
        result.put("test1", new StringBuilder("-"));
        result.put("test2", new StringBuilder("-"));
        result.put("test3", new StringBuilder("-"));

        List<String> winners = winner.getBy(result);
        assertEquals(winners.get(0), "test1");
        assertEquals(winners.get(1), "test2");
        assertEquals(winners.get(2), "test3");
    }
}

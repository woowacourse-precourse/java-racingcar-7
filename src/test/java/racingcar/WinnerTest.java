package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
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
        List<Car> result = new ArrayList<>();
        result.add(new Car("test1"));
        result.add(new Car("test2"));
        result.add(new Car("test3"));

        for (Car car : result) {
            car.moveForward();
        }

        List<String> winners = winner.getBy(result);
        assertEquals(winners.get(0), "test1");
        assertEquals(winners.get(1), "test2");
        assertEquals(winners.get(2), "test3");
    }
}

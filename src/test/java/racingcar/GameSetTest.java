package racingcar;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameSetTest {
    private GameSet gameSet;

    @BeforeEach
    void setUp() {
        gameSet = new GameSet();
    }

    @Test
    @DisplayName("1회미만의 시도횟수 입력시 예외 발생")
    void 시도횟수가_1회미만이면_예외_발생() {
        String input = "pobi, daae, \n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameSet.init());
    }

    @Test
    @DisplayName("입력된 car 이름을 ,로 나누기")
    void car_이름을_쉼표로_나누기() {
        List<Car> carList = gameSet.splitCarNames("pobi, daae,woni");
        Assertions.assertEquals(3, carList.size());
        Assertions.assertEquals("pobi", carList.get(0).getName());
        Assertions.assertEquals("daae", carList.get(1).getName());
        Assertions.assertEquals("woni", carList.get(2).getName());
    }

}

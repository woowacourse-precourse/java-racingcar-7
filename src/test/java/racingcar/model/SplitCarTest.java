package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitCarTest {
    @Test
    void 차량_이름_콤마로_분리() {
        SplitCar splitCar = new SplitCar("pobi,woni,jun");
        List<String> carNames = List.of("pobi", "woni", "jun");
        assertEquals(carNames,splitCar.getSplitCarNames());
    }
}
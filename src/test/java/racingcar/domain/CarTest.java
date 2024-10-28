package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    @DisplayName("랜덤_수가_1~4일_때_정지하는지_테스트")
    void stopTest() {
        Car pobi = new Car("pobi");

        pobi.move(1);
        pobi.move(2);
        pobi.move(3);

        int pobiExpectedPosition = 0;

        int pobiActualPosition = pobi.getMovementOfNumber();

        assertEquals(pobiExpectedPosition, pobiActualPosition);
    }

    @Test
    @DisplayName("랜덤_수가_5~9일_때_전진하는지_테스트")
    void moveTest() {
        Car pobi = new Car("pobi");

        pobi.move(4);
        pobi.move(5);
        pobi.move(6);
        pobi.move(7);
        pobi.move(8);
        pobi.move(9);

        int pobiExpectedPosition = 6;

        int pobiActualPosition = pobi.getMovementOfNumber();

        assertEquals(pobiExpectedPosition, pobiActualPosition);
    }

}
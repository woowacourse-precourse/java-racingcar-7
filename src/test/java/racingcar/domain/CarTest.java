package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    @DisplayName("랜덤 수가 1~4일 때 정지하는지 검증")
    void stopTest() {
        Car pobi = new Car("pobi");

        pobi.move(1);
        pobi.move(2);
        pobi.move(3);
        pobi.move(4);

        int pobiExpectedPosition = 0;

        int pobiActualPosition = pobi.getMovementOfNumber();

        assertEquals(pobiExpectedPosition, pobiActualPosition);
    }

    @Test
    @DisplayName("랜덤 수가 5~9일 때 전진하는지 검증")
    void moveTest() {
        Car pobi = new Car("pobi");

        pobi.move(5);
        pobi.move(6);
        pobi.move(7);
        pobi.move(8);
        pobi.move(9);

        int pobiExpectedPosition = 5;

        int pobiActualPosition = pobi.getMovementOfNumber();

        assertEquals(pobiExpectedPosition, pobiActualPosition);
    }

}
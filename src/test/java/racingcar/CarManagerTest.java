package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {

    @Test
    void count_exception() {
        //given
        String count = "-5";
        CarManager manager = new CarManager();
        //when //then
      /*  Assertions.assertThrows(IllegalArgumentException.class, () -> manager.run(count));*/

    }
}
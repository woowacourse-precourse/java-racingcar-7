package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

public class GameTest {
    @Test
    @DisplayName("자동차 이름 입력 시 리스트에 add되는지")
    void addCarNames(){
        RacingCar racingCar = new RacingCar("Kim,Shin", 5);
        Assertions.assertEquals(2, racingCar.getCarNameList().size());
    }

    @Test
    @DisplayName("예외처리: 자동차 이름 5자 초과 시 에러")
    void validCarName(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new RacingCar("Kimsss,Shinsss", 5));
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.test.Assertions;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RacingCarTest{

    //setCarName() 메서드 테스트
    @Test
    @DisplayName("이름 저장 실패: 한글, 영어 외의 문자 포함")
    void failSetCarNameTest1() throws Exception {
        RacingCar car = new RacingCar();
        //String TestName = "ㅇㅇ";

        assertThrows(IllegalArgumentException.class, () -> {
            car.setCarName("]djdk");
        });

    }

    @Test
    @DisplayName("이름 저장 실패: 5글자 초과, 1글자 미만")
    void failSetCarNameTest2() {
        RacingCar car = new RacingCar();
        String TestName = "kkkkkkk";

        assertThrows(IllegalArgumentException.class, () -> {
            car.setCarName(TestName);
        });
    }

    @Test
    @DisplayName("이름 저장 성공")
    void successCarNameTest() throws Exception {
        RacingCar car = new RacingCar();
        String TestName = "pobi";

        car.setCarName(TestName);

        assertEquals(TestName,car.carName);
    }


    //무작위값을 확인하여 전진 여부 확인하기
    @Test
    @DisplayName("무작위 값으로 전진 여부 확인하기")
    void checkForwardConditionTest() {
        RacingCar car = new RacingCar();
        boolean result = car.checkForwardCondition();
        boolean check = car.randomNumber > 3;
        assertTrue(car.randomNumber >= 0 | car.randomNumber < 10);
        assertEquals(result, check);
    }
}

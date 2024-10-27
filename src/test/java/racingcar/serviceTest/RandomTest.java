package racingcar.serviceTest;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomTest {

    @Test
    @DisplayName("랜덤함수 테스트")
    void checkRandom(){
        for(int i = 0 ; i < 100 ; i++){
            int number = Randoms.pickNumberInRange(0,9);
            Assertions.assertTrue(number>= 0 && number <= 9);
        }
    }
}

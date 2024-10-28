package racingcar.utils;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberTest {

    @DisplayName("0~9 범위로 숫자가 생성되는지, 100번의 테스트로 검증한다")
    @RepeatedTest(50)
    void 랜덤번호_생성_테스트() {
        RandomNumber randomNUmber = new RandomNumber();
        int generateNumber = randomNUmber.generate();
        assertThat(generateNumber).isBetween(0, 9);
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementGeneratorTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @Test
    @DisplayName("0~9의 랜덤한 숫자가 반환되는지 테스트")
    void getRandomNumber_MethodCall_gotNumber() {
        //when
        int num = MovementGenerator.getRandomNumber();

        //then
        assertThat(num).isBetween(0, 9);
    }
}

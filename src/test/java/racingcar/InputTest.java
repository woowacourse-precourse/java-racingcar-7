package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @Test
    @DisplayName("자동차 이름 문자열을 입력 받는지 확인")
    void getCarNames_MethodCall_gotCarNames() {
        //given
        String input = "Ahn,Seong,Mo";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        String result = Input.getCarNames();

        //then
        assertThat(result).isEqualTo("Ahn,Seong,Mo");
    }
}

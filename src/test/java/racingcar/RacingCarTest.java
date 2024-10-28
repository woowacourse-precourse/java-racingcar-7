package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void 중복된_이름_입력시_예외_테스트() {

        String input = "car1,car1,car2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> Application.testGetInputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름은 사용할 수 없습니다");

    }


}
package racingcar.dto;

import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarNamesDTOTest {
    @Test
    @DisplayName("자동차 이름을 입력하지 않은 경우 예외 처리")
    void 자동차_입력_문자열이_공백일때_에러_테스트(){
        Assertions.assertThatThrownBy(() -> new RacingCarNamesDTO(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해야 합니다");
    }

    @Test
    @DisplayName("자동차 이름이 비어 있는 경우 예외 처리")
    void 자동차_이름이_공백인_경우_예외_테스트(){
        Assertions.assertThatThrownBy(() -> new RacingCarNamesDTO("pobi, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어 있거나 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이하가 아닌 경우 예외 처리")
    void 자동차_이름이_5글자보다_크면_예외_테스트(){
        Assertions.assertThatThrownBy(() -> new RacingCarNamesDTO("pobi,seoyoung"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5 이하만 가능합니다.");
    }

    @Test
    @DisplayName("경주할 자동차가 1대 이하일 경우 예외 처리")
    void 자동차가_한대_이하면_예외_테스트(){
        Assertions.assertThatThrownBy(() -> new RacingCarNamesDTO("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차는 두 대 이상 입력해야 합니다.");
    }
}
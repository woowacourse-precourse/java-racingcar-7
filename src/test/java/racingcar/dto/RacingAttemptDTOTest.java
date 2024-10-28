package racingcar.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingAttemptDTOTest {
    @Test
    @DisplayName("시도 횟수가 정수가 아닐 경우 예외 처리")
    void 시도_횟수가_정수가_아니면_예외_테스트(){
        Assertions.assertThatThrownBy(() -> new RacingAttemptDTO("NotInteger"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수에는 정수를 입력해주세요");
    }

    @Test
    @DisplayName("시도 횟수가 1보다 작으면 예외 처리")
    void 시도_횟수가_1보다_작으면_예외_테스트(){
        Assertions.assertThatThrownBy(() -> new RacingAttemptDTO("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이여야 합니다");
    }
}
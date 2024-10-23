package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.ExceptionMessage;

class NameValidatorTest {

    @Test
    @DisplayName("split한 문자열 List 요소들의 길이는 0 이상 5 이하여야 한다.")
    void validatePlayerName() {
        List<String> players = List.of("a", "bb", "ccc", "ddd");
        boolean result = NameValidator.validatePlayerName(players);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("길이가 0 또는 5 초과인 경우 IllegalArgumentException을 throw한다.")
    void invalidatePlayerName() {
        List<String> players = List.of("a", "aabbcc");
        Assertions.assertThatThrownBy(
                        () -> NameValidator.validatePlayerName(players))
                .isInstanceOf(IllegalArgumentException.class
                ).hasMessage(ExceptionMessage.NAME_LENGTH.getMessage());
    }
}
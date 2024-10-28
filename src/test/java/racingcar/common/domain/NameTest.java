package racingcar.common.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameplayer.game.racinggame.domain.car.Name;

class NameTest {

    @Test
    @DisplayName("이름이 5글자보다 작다면 정상적으로 생성된다")
    void NameLengthSmallerThan5MustBeCreated() {
        assertThatCode(() -> new Name("이름입니다")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름이 5글자보다 크다면 예외가 발생해야 한다")
    void NameLengthBiggerThan5MustBeThrowError() {
        assertThatThrownBy(() -> new Name("이름입니다만"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
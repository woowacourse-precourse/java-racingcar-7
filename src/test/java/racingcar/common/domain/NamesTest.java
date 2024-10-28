package racingcar.common.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameplayer.game.racinggame.domain.car.Names;

class NamesTest {

    @Test
    @DisplayName("String 배열을 입력받으면 Names를 정상적으로 생성한다")
    void createInstanceWhenStringArrayInput() {
        // given
        String[] names = new String[]{"이름1", "이름2", "이름3"};

        // when & then
        assertThatCode(() -> new Names(names)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName(",로 이루어진 이름 String이 들어오면 Names를 정상적으로 생성한다")
    void createInstanceWhenStringWithCommaInput() {
        // given
        String nameString = "이름1,이름2,이름3";

        // when & then
        assertThatCode(() -> new Names(nameString)).doesNotThrowAnyException();
    }
}
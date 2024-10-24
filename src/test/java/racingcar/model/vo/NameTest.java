package racingcar.model.vo;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 이름 테스트")
public class NameTest {

    @Test
    void 자동차_이름은_5자_이하여야_한다() {
        // given
        String name = "pobiii";

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

}

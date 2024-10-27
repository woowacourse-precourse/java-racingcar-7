package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    void Name_생성() {
        Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @Test
    void 이름_길이_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(""))
                .withMessageMatching("자동차 이름은 1자 이상 5자 이하여야 합니다");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("banana"))
                .withMessageMatching("자동차 이름은 1자 이상 5자 이하여야 합니다");
    }

    @Test
    void to_string() {
        assertThat(new Name("pobi").toString()).isEqualTo("pobi");
    }

}

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class NameTest {

    private final Name POBI = new Name("pobi");

    @Test
    void Name_생성() {
        assertThat(POBI).isEqualTo(new Name("pobi"));
    }

    @Test
    void 자동차_이름은_1자_이상_5자_이하여야_함() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(""))
                .withMessageMatching("자동차 이름은 1자 이상 5자 이하여야 합니다");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("banana"))
                .withMessageMatching("자동차 이름은 1자 이상 5자 이하여야 합니다");
    }

    @Test
    void to_string() {
        assertThat(POBI.toString()).isEqualTo("pobi");
    }

}

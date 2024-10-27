package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import racingcar.constants.Constants;

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
                .withMessageMatching(Constants.INVALID_NAME_LENGTH);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("banana"))
                .withMessageMatching(Constants.INVALID_NAME_LENGTH);
    }

    @Test
    void to_string() {
        assertThat(POBI.toString()).isEqualTo("pobi");
    }

}

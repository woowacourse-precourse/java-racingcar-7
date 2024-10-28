package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Name;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest extends NsTest {

    @Test
    void 유효한_이름을_생성한다() {
        final String validName = "ckw";

        Name name = Name.from(validName);

        assertThat(name.value()).isEqualTo(validName);
    }

    @Test
    void 이름이_공백이면_예외가_발생한다() {
        final String emptyName = "";

        assertThatThrownBy(() -> Name.from(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 이름이_5자를_초과하면_예외가_발생한다() {
        final String longName = "kyuwon";

        assertThatThrownBy(() -> Name.from(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

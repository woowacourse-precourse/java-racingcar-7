package racingcar.model.primitive;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("Name을 생성할 수 있다.")
    @Test
    void createName() {
        //given
        String name = "pobi";

        //when
        Name creatName = Name.from(name);

        //then
        assertThat(creatName).isEqualTo(Name.from(name));
    }

    @DisplayName("name의 크기가 5를 초과하면 예외를 발생한다.")
    @Test
    void carNameLengthExceedThenFive() {
        //given
        String name = "javaji";

        //when //then
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("name의 크기가 5를 초괴하지 않으면 예외를 발생하지 않는다.")
    @Test
    void carNameLengthLessThenFive() {
        //given
        String name = "pobii";

        //when //then
        assertThatCode(() -> Name.from(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("우승자에 해당하는 name을 추가할 수 있다.")
    @Test
    void addWinner() {
        //given
        List<String> winner = new ArrayList<>();

        Name name = Name.from("pobi");

        //when
        name.add(winner);

        //then
        assertThat(winner).containsExactly("pobi");
    }
}
package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameParserTest {
    @Test
    void 기능_테스트() {
        assertThat(CarNameParser.parse("john, apple, eleph", 5))
                .containsExactly("john", "apple", "eleph");
    }

    @Test
    void 예외_테스트() {
        // 이름 길이 초과
        assertThatThrownBy(()->CarNameParser.parse("john, apple12, eleph", 5))
                .isInstanceOf(IllegalArgumentException.class);
        
        // 잘못된 구분자
        assertThatThrownBy(()->CarNameParser.parse("john. apple. eleph", 5))
                .isInstanceOf(IllegalArgumentException.class);

        // 공백 있는 이름
        assertThatThrownBy(()->CarNameParser.parse("john, a pple, eleph", 5))
                .isInstanceOf(IllegalArgumentException.class);
        
        // 빈 입력
        assertThatThrownBy(()->CarNameParser.parse(null, 5))
                .isInstanceOf(IllegalArgumentException.class);
        
        // null 입력
        assertThatThrownBy(()->CarNameParser.parse(null, 5))
                .isInstanceOf(IllegalArgumentException.class);

        // 중복 이름 입력
        assertThatThrownBy(()->CarNameParser.parse("john, apple, john", 5))
        .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->CarNameParser.parse("apple, apple, apple", 5))
        .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->CarNameParser.parse("john, eleph, eleph", 5))
        .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->CarNameParser.parse("john, apple, eleph, banana, kiwi, apple, orange, apple", 5))
        .isInstanceOf(IllegalArgumentException.class);
    }
}

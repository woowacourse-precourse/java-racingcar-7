package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 알파벳_이름이_아니면_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new Car("abc124!");
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_이름일_경우_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new Car(" ");
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 길이가_5보다_클_경우_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new Car("abcdefghi");
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void moveOrStop() {
    }
}

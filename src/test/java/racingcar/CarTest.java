package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 알파벳_이름이_아니면_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new Car("ab24!");
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름은 영어(알파벳)로만 생성할 수 있습니다.")
        );
    }

    @Test
    void 공백_이름일_경우_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new Car(" ");
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("공백은 이름이 될 수 없습니다.")
        );
    }

    @Test
    void 길이가_5보다_클_경우_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new Car("abcdefghi");
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름은 5글자보다 클 수 없습니다.")
        );
    }

    @Test
    void 숫자가_4보다_작으면_움직이면_안된다() {
        Car car = new Car("test");
        car.moveOrStop(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 숫자가_4이상이면_앞으로_움직인다() {
        Car car = new Car("test");
        car.moveOrStop(6);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}

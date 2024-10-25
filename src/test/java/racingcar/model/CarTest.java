package racingcar.model;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void 자동차_이름_null_실패(){
        assertThatThrownBy(()->new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 null이 될 수 없습니다.");
    }

    @Test
    void 자동차_이름_길이가_5글자보다_큰_입력_실패(){
        assertThatThrownBy(()->new Car("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 5자 이상 될 수 없습니다.");
    }
}
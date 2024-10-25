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
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 자동차_이름_빈_문자열_입력_실패(){
        assertThatThrownBy(()->new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 자동차_이름_영어_입력_실패(){
        assertThatThrownBy(()->new Car("123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_객체_생성_성공(){
        Car car=new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
    @Test
    void 정지_3이하(){
        Car car=new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
    @Test
    void 이동_4이상(){
        Car car=new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
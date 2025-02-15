package racingcar.model;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class CarTest {
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
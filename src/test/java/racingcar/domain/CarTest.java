package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp(){
        //Given : 자동차를 하나 생성한다.
        car = new Car("www");
    }

    @Test
    void 자동차_이름_확인_테스트(){
        //When : 자동차 이름으로 확인 해보기
        String name = car.getName();
        assertEquals("www", name);
    }

    @Test
    void 자동차_전진_테스트(){
        //Given : 현재 자동차의 초기 위치는 0 이다.
        assertEquals(0, car.getDistance());

        //When : 자동차가 한 칸 전진한다.
        car.move();

        //Then: 자동차의 이동거리가 1이 되어야 한다.
        assertEquals(1, car.getDistance());
    }

    @Test
    void 자동차_위치출력_테스트(){
        //Given : 자동치가 세 번 전진한다.
        car.move();
        car.move();
        car.move();

        //When : 자동차의 위치를 "-" 로 출력한다.
        String position = car.getPosition();

        //Then : 위치는 "---" 여야한다
        assertEquals("----", position);

    }

}
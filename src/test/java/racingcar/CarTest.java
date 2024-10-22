package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void nothing() {
        System.out.println("nothing");
    }

    @Test
    void 자동차_이름_입력_테스트() {
        assertEquals(List.of("test1", "test2"), car.getCarNames("test1,test2"));
    }

    @Test
    void 자동차_이름_입력_중복_케이스_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> car.getCarNames("test1,test1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_입력_공백_케이스_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> car.getCarNames("test1,,test2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
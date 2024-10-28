package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ExceptionMessages;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test", 0); // 기본 이름과 초기 forwardCnt 0으로 설정
    }

    @Test
    void 생성자_이름이_5자를_초과하면_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car("exceedName", 0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessages.NAME_LENGTH_LIMIT_EXCEEDED)
        );
    }

    @Test
    void 생성자_빈_이름일_경우_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car("", 0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessages.EMPTY_INPUT)
        );
    }

    @Test
    void 생성자_null일_경우_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car(null, 0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessages.EMPTY_INPUT)
        );
    }

    @Test
    void toString_포맷_확인() {
        // forwardCnt가 0일 때
        assertEquals("test : ", car.toString());

        // forwardCnt가 3일 때
        car.forwardCnt = 3;
        assertEquals("test : ---", car.toString());
    }


}

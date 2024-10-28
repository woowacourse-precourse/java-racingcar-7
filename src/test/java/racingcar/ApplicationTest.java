package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.Converter;
import racingcar.util.Parser;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("쉼표(,)를 기준으로 자동차 이름을 구분한다.")
    void 파싱_테스트() {
        assertEquals(List.of("pobi", "woni", "jun"), Parser.parse("pobi,woni,jun"));
    }

    @Test
    @DisplayName("시도할 횟수를 문자열로 입력해 정수로 변환한다.")
    void 양수_변환_테스트() {
        assertEquals(123, Converter.convert("123"));
    }

    @Test
    @DisplayName("정수를 -로 변환한다.")
    void 바_변환_테스트() {
        assertEquals("---", Converter.convertPositionToBar(3));
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진한다.")
    void 전진_테스트() {
        //Given
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(() -> {
            //When
            car.moveOrStop();
            //Then
            assertThat(car.getPosition()).isEqualTo(1);
        }, MOVING_FORWARD);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 정지한다.")
    void 정지_테스트() {
        //Given
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(() -> {
            //When
            car.moveOrStop();
            //Then
            assertThat(car.getPosition()).isEqualTo(0);
        }, STOP);
    }

    @Test
    @DisplayName("문자열 입력 값이 공백이거나 길이가 5를 초과하면 예외를 던진다.")
    void 입력길이_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("차 이름은 1자 이상 5자 이내로 입력해주세요.")
        );
    }

    @Test
    @DisplayName("문자열 입력 값이 영문자가 아니면 예외를 던진다.")
    void 입력값_타입_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,()", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("차 이름은 영문자로 입력해주세요.")
        );
    }

    @Test
    @DisplayName("정수 입력 값에 양수 외의 값이 들어오면 예외를 던진다.")
    void 양수_검증_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도할 횟수는 양수로 입력해주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

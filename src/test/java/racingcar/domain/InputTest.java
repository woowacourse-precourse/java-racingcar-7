package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.utils.ErrorMessage.INVALID_INPUT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputTest {

    @Test
    @DisplayName("정상 입력 테스트")
    void test1() {
        String s = "pobi,woni,jun";

        Input input = new Input(s);
        CarList expect = new CarList();
        expect.add("pobi");
        expect.add("woni");
        expect.add("jun");

        CarList result = CarList.from(input);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("에러 올바른 값과 빈값")
    void test2() {
        String s = ",woni,jun";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Input(s);
        });

        assertThat(exception.getMessage()).contains(INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("에러 : 5자 초과")
    void test3() {
        String s = "pooobi,woni,jun";
        Input input = new Input(s);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarList.from(input);
        });

        assertThat(exception.getMessage()).contains(INVALID_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("빈값 처리")
    void test4() {
        String s = ",,";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Input(s);
        });

        assertThat(exception.getMessage()).contains(INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("빈 입력")
    void test5() {
        String s = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Input(s));

        assertThat(exception.getMessage()).contains(INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("null 입력")
    void test6() {
        String s = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Input(s));

        assertThat(exception.getMessage()).contains(INVALID_INPUT.getMessage());
    }


}

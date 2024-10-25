package racingcar;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {

    private final Input input = new Input();

    @Test
    void 비어있는_이름_입력시_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> input.checkValidation(""));
    }

    @Test
    void null_일때_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> input.checkValidation(null));
    }

    @Test
    void 올바른_입력_테스트() {
        input.checkValidation("Valid");
    }

    @Test
    void 다섯_글자_이하_입력_테스트() {
        assertDoesNotThrow(() -> input.checkNameLength("pobi"));
        assertDoesNotThrow(() -> input.checkNameLength("woni"));
        assertDoesNotThrow(() -> input.checkNameLength("jun"));
    }

    @Test
    void 다섯_글자_초과_입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> input.checkNameLength("pooobi"));
        assertThrows(IllegalArgumentException.class, () -> input.checkNameLength("wooooni"));
    }

    @Test
    void 라운드_입력_숫자_아닌_경우_예외(){
        assertThrows(IllegalArgumentException.class, () -> input.checkRoundInt("a2"));
        assertThrows(IllegalArgumentException.class, () -> input.checkRoundInt(""));
        assertThrows(IllegalArgumentException.class, () -> input.checkRoundInt(" "));
        assertThrows(IllegalArgumentException.class, () -> input.checkRoundInt(null));
    }

    @Test
    void 라운드_입력_올바른_경우(){
        assertDoesNotThrow(() -> input.checkRoundInt("123"));
        assertDoesNotThrow(() -> input.checkRoundInt("1"));
        assertDoesNotThrow(() -> input.checkRoundInt("12"));
        assertDoesNotThrow(() -> input.checkRoundInt("11000000"));
    }

    @Test
    void 입력에_공백이_포함된_경우(){
        String names = "pobi,,woni";
        System.setIn(new ByteArrayInputStream(names.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> input.getCars());
    }

    @Test
    void 이름이_5글자_초과인_경우(){
        String names = "pobi,,woniiiiiii";
        System.setIn(new ByteArrayInputStream(names.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> input.getCars());
    }

    @Test
    void 이름_앞뒤에_공백이_포함된_경우(){
        String names = "  pobi   ,   woni   ,    jun ";
        System.setIn(new ByteArrayInputStream(names.getBytes()));

        List<Car> cars = input.getCars();

        assertThat("pobi").isEqualTo(cars.get(0).getName());
        assertThat("woni").isEqualTo(cars.get(1).getName());
        assertThat("jun").isEqualTo(cars.get(2).getName());
    }

    @Test
    void 이름_입력_올바른_경우(){
        String names = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(names.getBytes()));

        List<Car> cars = input.getCars();

        assertThat(3).isEqualTo(cars.size());
        assertThat("pobi").isEqualTo(cars.get(0).getName());
        assertThat("woni").isEqualTo(cars.get(1).getName());
        assertThat("jun").isEqualTo(cars.get(2).getName());
    }

}

package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 자동차_이름이_5자_초과시_예외발생() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobiwoni"));
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(cars);
        });
    }

    @Test
    void 자동차_이름이_공백이면_예외발생() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(""));
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(cars);
        });
    }

    @Test
    void 자동차_이름이_중복되면_예외발생() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("pobi"));
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(cars);
        });
    }


    @Test
    void 시행_횟수_입력이_양수가_아니면_예외발생() {
        String input = "-1";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateAttemptCount(input);
        });
    }
}

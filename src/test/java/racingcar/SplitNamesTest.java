package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitNamesTest {

    @Test
    void InputOneCarNameExceptionTest() {
        List<String> carNamesString = List.of("a");

        Assertions.assertThrows(IllegalArgumentException.class, () -> SplitNames.checkOneCar(carNamesString));
    }

    @Test
    void checkOneCarTest() {
        List<String> carNamesString = List.of("a", "b", "c");

        Assertions.assertDoesNotThrow(() -> SplitNames.checkOneCar(carNamesString));
    }

    @Test
    void NoNameInputExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> SplitNames.checkNameLength(""));
    }

    @Test
    void CarNameLengthMoreThan5ExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> SplitNames.checkNameLength("testCar"));
    }

    @Test
    void checkNameLengthTest() {
        Assertions.assertDoesNotThrow(() -> SplitNames.checkNameLength("car"));
    }

    @Test
    void splitCarNamesTest() {
        List<Car> carList = SplitNames.splitCarNames("a,b,c", 5);

        Assertions.assertEquals(3, carList.size());

    }
}

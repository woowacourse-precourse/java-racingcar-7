package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {
    @ParameterizedTest
    @CsvSource({
            "'CarA,CarA,CarB', true",
            "'CarA,CarB,CarC', false"
    })
    void isSameNameTest(String carNames, Boolean result) {
        List<String> carNameList = Arrays.asList(carNames.split(","));

        assertEquals(result, isSameName(carNameList));
    }


    @ParameterizedTest
    @CsvSource({
            "'car', true",
            "'car1,car2', false"
    })
    void isOneNameTest(String carNames, Boolean result) {
        List<String> carNameList = Arrays.asList(carNames.split(","));

        assertEquals(result, isOneName(carNameList));
    }


    private Boolean isSameName(List<String> carNameList) {
        for (String name : carNameList) {
            if (Collections.frequency(carNameList, name) > 1) return true;
        }
        return false;
    }

    private Boolean isOneName(List<String> carNameList) {
        return carNameList.size() == 1;
    }

}

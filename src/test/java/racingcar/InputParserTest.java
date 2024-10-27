package racingcar;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {
    @Test
    void 쉼표_문자_분리_테스트() {
        String mockInput = "tayo,lani,rogi";
        List<String> expectedResults = List.of("tayo", "lani", "rogi");

        var runner = new InputParser(mockInput);
        LinkedHashMap<Car, Integer> actualResults = runner.splitByComma();

        int i = 0;
        for (Car car : actualResults.keySet()) {
            assertThat(car.getCarName()).isEqualTo(expectedResults.get(i));
            i++;
        }
    }
}

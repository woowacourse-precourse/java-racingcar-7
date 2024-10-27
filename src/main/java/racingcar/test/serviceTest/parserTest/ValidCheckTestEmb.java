package racingcar.test.serviceTest.parserTest;

import org.junit.jupiter.api.Test;
import racingcar.service.parser.ValidCheck;
import racingcar.service.parser.ValidCheckEmb;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidCheckTestEmb implements ValidCheckTest {
    @Test
    public void testAreCarNamesValid(){
        ValidCheck validCheck = new ValidCheckEmb();
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add(", ,");
        carNames.add("car2");
        assertThatThrownBy(()-> {validCheck.areCarNamesValid(carNames);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testIsDuplicate(){
        ValidCheck validCheck = new ValidCheckEmb();
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car1");
        carNames.add("car2");
        assertThatThrownBy(()-> {validCheck.isDuplicate(carNames);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void run(){
        testIsDuplicate();
        testAreCarNamesValid();
    }
}

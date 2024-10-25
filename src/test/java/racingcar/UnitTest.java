package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest extends NsTest {

    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // 각 테스트 전에 System.in을 복구하기 위해 원본을 저장합니다.
        System.setIn(originalIn);
    }

    @AfterEach
    void restoreSystemIn() {
        // 각 테스트 후에 System.in을 원본으로 복구합니다.
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("getCarInput 테스트")
    void getCarInputTest() {
        final String input = "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String result = Application.getCarInput();
        assertThat(result).isEqualTo("car1,car2,car3");
    }

    @Test
    @DisplayName("splitInput 작동테스트")
    void splitInputTest() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        List<RacingCar> resultCars = Application.splitInput("car1,car2,car3");
        assertThat(resultCars).extracting("name").containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("splitInput 글자수 예외테스트")
    void splitInputTest2() {
        assertThatThrownBy(() -> Application.splitInput("car1,car2,car333"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("getTrial 글자수 정상 작동 테스트")
    void getTrialTest() {
        final String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Integer result = Application.getTrial();
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("getTrial 예외 테스트")
    void getTrialTest2() {
        final String input = "--\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> Application.getTrial())
                .isInstanceOf(IllegalArgumentException.class);
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

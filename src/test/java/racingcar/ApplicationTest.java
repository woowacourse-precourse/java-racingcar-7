package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.ParsingCarNameService;
import racingcar.view.OutputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void 우승자_출력_테스트() {
        List<Car> winners = Arrays.asList(new Car("pobi"), new Car("crong"));
        String expectedOutput = "최종 우승자 : pobi, crong\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView.printFinalResults(winners);
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void 자동차_이름_추출_테스트() {
        String inputCarName = "pobi, crong,    juni,,,, kime, , ,  min";
        List<Car> expectedCars = Arrays.asList(new Car("pobi"),
                new Car("crong"), new Car("juni"), new Car("kime"), new Car("min"));

        List<Car> actualCars = ParsingCarNameService.parseCarNames(inputCarName);

        assertEquals(expectedCars.size(), actualCars.size());
        for (int i = 0; i < expectedCars.size(); i++) {
            assertEquals(expectedCars.get(i).getCarName(), actualCars.get(i).getCarName());
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

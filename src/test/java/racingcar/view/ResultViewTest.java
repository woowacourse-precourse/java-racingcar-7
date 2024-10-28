package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 라운드_결과_출력_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        car1.move(4);
        car2.move(3);

        ResultView.printRoundResult(List.of(car1, car2));

        String expectedOutput = "pobi : -\nwoni : \n\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 우승자_출력_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        car1.move(4);
        car2.move(4);

        ResultView.printWinners(List.of(car1, car2));

        String expectedOutput = "최종 우승자 : pobi, woni";
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }
}

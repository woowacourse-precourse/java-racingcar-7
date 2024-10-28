package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.strategy.MaxValueIntGeneratorStrategy;

public class OutputViewTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void Given_경주_시작_When_호출시_Expect_메시지를_출력한다() {
        OutputView outputView = new OutputView();
        outputView.printRacingStart();

        assertThat(byteArrayOutputStream.toString().trim()).isEqualTo("실행 결과");
    }

    @Test
    public void Given_Cars_객체_생성_When_자동차_이동시_Expect_메시지를_출력한다() {
        final List<String> carNames = Arrays.asList("car1", "car2", "car3");
        final Cars cars = new Cars(carNames, new MaxValueIntGeneratorStrategy());

        cars.getCars().get(0).tryMove();
        cars.requestCarMove();

        OutputView outputView = new OutputView();
        outputView.printStageResult(cars);
        assertThat(byteArrayOutputStream
                .toString()
                .trim())
                .isEqualTo(
                        cars.getCars().get(0).getCarName() + " : " + "--" + "\n"
                        + cars.getCars().get(1).getCarName() + " : " + "-" + "\n"
                        + cars.getCars().get(2).getCarName() + " : " + "-"
                );
    }

    @Test
    public void Given_Cars_객체_생성_When_자동차_이동이_두_번_있을시_Expect_메시지를_출력한다() {
        final List<String> carNames = Arrays.asList("car1", "car2", "car3");
        final Cars cars = new Cars(carNames, new MaxValueIntGeneratorStrategy());

        cars.getCars().get(0).tryMove();
        cars.requestCarMove();

        OutputView outputView = new OutputView();
        outputView.printStageResult(cars);

        cars.getCars().get(1).tryMove();

        outputView.printStageResult(cars);

        assertThat(byteArrayOutputStream
                .toString()
                .trim())
                .isEqualTo(
                        cars.getCars().get(0).getCarName() + " : " + "--" + "\n"
                        + cars.getCars().get(1).getCarName() + " : " + "-" + "\n"
                        + cars.getCars().get(2).getCarName() + " : " + "-" + "\n"
                        + "\n"
                        + cars.getCars().get(0).getCarName() + " : " + "--" + "\n"
                        + cars.getCars().get(1).getCarName() + " : " + "--" + "\n"
                        + cars.getCars().get(2).getCarName() + " : " + "-"
                );
    }
}
package racingcar.interfaces.racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.CarService;
import racingcar.domain.fake.FakeInputHandler;
import racingcar.domain.fake.FakeRacingStrategy;
import racingcar.domain.racing.JudgeService;
import racingcar.domain.racing.RacingService;
import racingcar.interfaces.output.OutputHandler;

class RacingControllerTest {

    private RacingController racingController;

    @BeforeEach
    void setUp() {
        CarFactory carFactory = new CarFactory();
        CarService carService = new CarService(carFactory);
        FakeRacingStrategy fakeRacingStrategy = new FakeRacingStrategy();
        RacingService racingService = new RacingService(fakeRacingStrategy);
        JudgeService judgeService = new JudgeService();
        FakeInputHandler fakeInputHandler = new FakeInputHandler();
        OutputHandler outputHandler = new OutputHandler();

        racingController = new RacingController(carService, racingService, fakeInputHandler, outputHandler, judgeService);
    }

    @DisplayName("4대의 자동차가 5번 경주하여 결과를 출력하는 테스트")
    @Test
    void raceControllerTest() {
        OutputStream out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));
        racingController.processRace();

        assertThat(out.toString()).contains("honda : -----", "bmw : -----", "benz : -----", "ford : -----");

        System.setOut(System.out);
    }
}

package racingcar.test;

import org.junit.jupiter.api.Test;
import racingcar.test.controllerIOTest.InputControllerTestEmb;
import racingcar.test.controllerIOTest.OutputControllerTestEmb;
import racingcar.test.controllerRaceTest.RaceControllerTestEmb;
import racingcar.test.controllerRaceTest.RacingCarControllerTestEmb;
import racingcar.test.modelTest.RacingCarTestEmb;
import racingcar.test.serviceTest.decisionTest.ForwardOrNotTestEmb;
import racingcar.test.serviceTest.evaluatorTest.WinnerEvaluatorTestEmb;
import racingcar.test.serviceTest.factoryTest.CarFactoryTestEmb;
import racingcar.test.serviceTest.factoryTest.RaceControllerFactoryTestEmb;
import racingcar.test.serviceTest.parserTest.ParsingServiceTestEmb;
import racingcar.test.serviceTest.parserTest.ValidCheckTestEmb;
import racingcar.test.viewTest.InputHandlerTestEmb;
import racingcar.test.viewTest.ResultViewerTestEmb;

public class WholeTestEmb implements WholeTest {
    @Test
    public void runWholeTest() {
        new InputControllerTestEmb().run();
        new OutputControllerTestEmb().run();
        new RaceControllerTestEmb().run();
        new RacingCarControllerTestEmb().testMoveForward();
        new RacingCarTestEmb().run();
        new ForwardOrNotTestEmb().testIsBiggerOrEqualFour();
        new WinnerEvaluatorTestEmb().run();
        new CarFactoryTestEmb().testCreateCars();
        new RaceControllerFactoryTestEmb().testCreateRaceController();
        new ParsingServiceTestEmb().run();
        new ValidCheckTestEmb().run();
        new InputHandlerTestEmb().testGetInput();
        new ResultViewerTestEmb().testOutput();
    }
}

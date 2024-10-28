package racingcar.controller;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Register;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingControllerTest {

    @Test
    void 자동차_문자열_쉼표_기준_분리() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Register register = new Register();
        CarRacingController carRacingController = new CarRacingController(inputView, outputView, register);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("진용1");
        expected.add("진용2");
        expected.add("진용3");

        Assertions.assertEquals(carRacingController.divide("진용1,진용2,진용3"), expected);
    }
}

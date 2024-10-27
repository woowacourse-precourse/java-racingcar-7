package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDomain;
import racingcar.domain.CarDomains;
import racingcar.view.InputView;

class InputControllerTest {
    private InputController inputController;
    private DummyInputView dummyInputView;

    @BeforeEach
    void setUp() {
        dummyInputView = new DummyInputView();
        inputController = InputController.getInstance(dummyInputView);
    }

    @Test
    @DisplayName("자동차이름_요청_테스트")
    void testGetCarNameRequest() {
        assertSimpleTest(() -> {
            String inputCarNames = "Car1,Car2,Car3";
            dummyInputView.setCarNames(inputCarNames);

            CarDomains carDomains = inputController.getCarNameRequest();

            assertNotNull(carDomains);
            assertEquals(3, carDomains.getCarDomainList().size());
            assertEquals(Arrays.asList("Car1", "Car2", "Car3"),
                    carDomains.getCarDomainList().stream().map(CarDomain::getName).toList()
            );
        });
    }

    @Test
    @DisplayName("경기_진행_횟수_요청_테스트")
    void testGetRoundRequest() {
        assertSimpleTest(() -> {
            String inputRound = "5";
            dummyInputView.setRound(inputRound);

            Integer round = inputController.getRoundRequest();

            assertNotNull(round);
            assertEquals(Integer.valueOf(inputRound), round);
        });
    }

    private static class DummyInputView implements InputView {
        private String carNames;
        private String round;

        @Override
        public String displayCarNameRequest() {
            return carNames;
        }

        @Override
        public String displayRoundRequest() {
            return round;
        }

        public void setCarNames(String carNames) {
            System.out.println(carNames);
            this.carNames = carNames;
        }

        public void setRound(String round) {
            this.round = round;
        }
    }
}
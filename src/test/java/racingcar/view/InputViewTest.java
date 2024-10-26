package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import racingcar.Application;

public class InputViewTest{
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = InputView.getInstance();
    }

    @DisplayName("자동차 이름과 시도 횟수 입력받기")
    @Test
    void readCarRacingSetup_메서드_테스트() {
        String simulationSetup = "car1,car2,car3\n5\n";
        System.setIn(new ByteArrayInputStream(simulationSetup.getBytes()));

        inputView.readCarRacingSetup();

        assertThat(inputView.getCarNames()).isEqualTo("car1,car2,car3");
        assertThat(inputView.getTryCount()).isEqualTo("5");
    }
}

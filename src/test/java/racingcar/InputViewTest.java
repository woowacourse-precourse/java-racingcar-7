package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class InputViewTest extends NsTest {

    @Test
    void inputCar() throws IllegalAccessException {
        run("Harry,Amy,Tom");
        String[] carNames = InputView.inputCar();
        assertThat(carNames).contains("Harry","Amy","Tom");
    }

    @Test
    void inputCount() {
        run("3");
        int inputCountNum = InputView.inputCount();
        assertThat(inputCountNum).isEqualTo(3);
        
    }


    @Override
    protected void runMain() {

    }
}
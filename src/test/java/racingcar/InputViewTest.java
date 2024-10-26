package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class InputViewTest {

    @Test
    void inputCar() throws IllegalAccessException {
        assertThat(InputView.inputCar("Harry,Amy,Tom")).contains("Harry","Amy","Tom");
    }

    @Test
    void inputCount() {
        assertThat(InputView.inputCount("3")).isEqualTo(3);
        
    }


}
package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름을_출력() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("dobi");
    }

    @Test
    void 입력받은_문자열을_쉼표를_기준으로_구분() {
        String inputString = "pobi,woni,   jun";
        String[] names = CarGenerator.splitInputString(inputString);
        assertThat(names).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

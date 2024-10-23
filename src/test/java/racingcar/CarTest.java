package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class CarTest extends NsTest{

    @Test
    void 자동차_개수_테스트() {
        Cars cars = new Cars("핍비,피비");
        assertThat(cars.getCarCount()).isEqualTo(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

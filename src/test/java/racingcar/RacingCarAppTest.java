package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingCarAppTest {

    @Test
    void 자동차_생성_테스트() {
        RacingCarApp app = new RacingCarApp();
        app.makeCar("car1,car2");
        assertThat(app.getCars().size()).isEqualTo(2);
        assertThat(app.getCars().get(0).getCarName()).isEqualTo("car1");
        assertThat(app.getCars().get(1).getCarName()).isEqualTo("car2");
    }
}
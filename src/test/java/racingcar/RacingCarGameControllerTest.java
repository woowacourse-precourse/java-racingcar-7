package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarGameController;
import racingcar.model.Car;

public class RacingCarGameControllerTest {
    private RacingCarGameController racingCarGameController;

    @BeforeEach
    void setUp() {
        racingCarGameController = new RacingCarGameController();
    }

    @Test
    @DisplayName("문자열로 받은 자동차 이름을 가지고 자동차 객체 리스트를 만듭니다.")
    void converToCarsTest() {
        //given
        String[] carName = {"pobi", "woni", "jun"};

        //when
        List<Car> racingCars = racingCarGameController.convertToCars(carName);

        //then
        assertAll(
                () -> assertThat(racingCars).hasSize(3),
                () -> assertThat(racingCars.get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(racingCars.get(1).getName()).isEqualTo("woni"),
                () -> assertThat(racingCars.get(2).getName()).isEqualTo("jun")
        );
    }

}

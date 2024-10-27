package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

class InputDTOTest {

    @Test
    void INPUT_DTO를_RACING_CAR_클래스로_만든다() {
        InputDTO inputDTO = new InputDTO(List.of("차이름1", "차이름2"), 3L);
        List<RacingCar> racingCars = inputDTO.to();
        assertThat(racingCars.get(0).getName()).isEqualTo("차이름1");
        assertThat(racingCars.get(1).getName()).isEqualTo("차이름2");
    }
}
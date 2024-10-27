package racingcar;

import static racingcar.GameController.carRacingInfo;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameControllerTest {

    @BeforeEach
    void setUp() {
        carRacingInfo.clear();
    }

    @Test
    void 시도_결과_리스트_만들기() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3", "car4");
        List<CarDto> carDtos = GameController.createCarDtos(carNames);
        Assertions.assertThat(carDtos).hasSize(4);

        for (int i = 0; i < carDtos.size(); i++) {
            CarDto carDto = carDtos.get(i);
            Assertions.assertThat(carDto.getCarName()).isEqualTo(carNames.get(i));
        }

    }

    @Test
    void 시도_결과_맵에넣기(){

        List<String> carNames = Arrays.asList("car1", "car2", "car3", "car4");

        List<CarDto> carDtos1 = GameController.createCarDtos(carNames);
        List<CarDto> carDtos2 = GameController.createCarDtos(carNames);
        List<CarDto> carDtos3 = GameController.createCarDtos(carNames);

        GameController.raceResultRecord(1, carDtos1);
        GameController.raceResultRecord(2, carDtos2);
        GameController.raceResultRecord(3, carDtos3);

        Assertions.assertThat(carRacingInfo).hasSize(3);

        for (int i = 0; i < carRacingInfo.size(); i++) {
            List<CarDto> carDtoList = carRacingInfo.get(i+1);
            String carName = carDtoList.get(i).getCarName();
            Assertions.assertThat(carName).isEqualTo(carNames.get(i));
        }

    }
}
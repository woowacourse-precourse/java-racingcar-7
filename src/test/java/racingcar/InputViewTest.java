package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;

class InputViewTest {

    @Test
    void 자동차_이름_입력_테스트() {
        // given
        String input = "c,s,w\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        List<Car> actualCars = InputView.getCarNames();

        // then
        String[] carNames = input.split(",");
        List<Car> expectedCars = CarService.convertToCarList(carNames);

        assertEquals(expectedCars.size(), actualCars.size(), "자동차 개수 확인");
        for (int i = 0; i < expectedCars.size(); i++) {
            assertEquals(expectedCars.get(i).getName(), actualCars.get(i).getName(), "자동차 이름 확인");
        }
    }


    @Test
    void 라운드_정수형_변환() {
        String round = "3";

    }

}


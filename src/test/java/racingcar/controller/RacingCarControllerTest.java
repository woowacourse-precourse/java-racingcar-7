package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

class RacingCarControllerTest {
    static RacingCarController racingCarController;
    static InputView inputView = InputView.getInstance();

    @BeforeAll
    static void setUp() {
        racingCarController = new RacingCarController(new RacingCarService());
    }

    @DisplayName("이름이 쉼표 기준으로 나눠 Car 클래스 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = "pobi,woni")
    void validateNameLength(String names) {
        List<String> nameList = inputView.splitNames(names);
        List<Car> carList = racingCarController.setCarsName(nameList);
        List<String> carNameList = new ArrayList<>();
        for (Car car : carList) {
            carNameList.add(car.getName());
        }
        Assertions.assertThat(carNameList).isEqualTo(List.of("pobi", "woni"));
    }

}
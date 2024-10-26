package service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class CarServiceTest {

    private final CarService carService = new CarService();

    @Test
    void 유효한_차_이름_입력시_테스트() {
        String carNames = "pobi,woni,jun";

        List<Car> carList = carService.createCarList(carNames);

        assertThat(carList).hasSize(3);
        assertThat(carList.getFirst().getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 전처리_필요한_차_이름_입력시_테스트() {
        String carNames = "  pobi,    woni, jun ";

        List<Car> carList = carService.createCarList(carNames);

        assertThat(carList).hasSize(3);
        assertThat(carList.getFirst().getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }
}
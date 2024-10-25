package racingcar.view;

import racingcar.dto.response.CarsResponse;

public class OutputView {

    public void printMovement(CarsResponse carsResponse) {
        carsResponse.cars().forEach(car -> System.out.println(car.toString()));
    }
}

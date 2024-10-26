package racingcar.view;

import racingcar.dto.CarsDto;
import racingcar.model.Car;

public class OutputView {
    private OutputView() {
    }
    public static void outputEachRound(CarsDto carsDto) {
        for (Car car : carsDto.getCars()) {
            System.out.println(car.getName()+" : "+"-".repeat(car.getWinStack()));
        }
    }
}

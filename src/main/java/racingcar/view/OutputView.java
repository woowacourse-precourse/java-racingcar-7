package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printOneGameResult(List<Car> inputCarList){

        inputCarList.forEach( car ->
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveCount()))
        );

        System.out.println();
    }
}

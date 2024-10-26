package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printOneGameResult(List<Car> inputCarList){

        inputCarList.forEach( car ->
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveCount()))
        );

        System.out.println();
    }

    public static void printWinner(String winner){

        System.out.println("최종 우승자 : " + winner);
    }
}

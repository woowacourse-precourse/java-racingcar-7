package racingcar.printer;

import java.util.List;
import racingcar.Printer;
import racingcar.domain.Cars;

public class PrintRacingResult implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printAfterGameResult(List<Cars> afterGameCars) {
        System.out.println("실행 결과");
        for (Cars cars : afterGameCars) {
            System.out.println(Cars.makeResultOutput(cars.allCar()));
        }
    }

    @Override
    public void printFinalWinner(List<String> winner) {
        String finalWinner = "최종 우승자 : "
            + String.join(", ", winner);
        System.out.println(finalWinner);
    }
}

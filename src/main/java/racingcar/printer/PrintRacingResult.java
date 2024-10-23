package racingcar.printer;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Result;
import racingcar.application.Printer;

public class PrintRacingResult implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printAfterGameResult(Result afterGameCars) {
        System.out.println("실행 결과");
        for (Cars cars : afterGameCars.finalResultCars()) {
            System.out.println(cars.makeResultOutput());
        }
    }

    @Override
    public void printFinalWinner(List<String> winner) {
        String finalWinner = "최종 우승자 : "
                + String.join(", ", winner);
        System.out.println(finalWinner);
    }
}

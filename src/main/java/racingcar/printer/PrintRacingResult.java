package racingcar.printer;

import java.util.List;
import racingcar.application.Printer;
import racingcar.domain.Cars;
import racingcar.domain.Result;

public class PrintRacingResult implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printResultAfterGame(Result afterGameCars) {
        System.out.println("실행 결과");
        for (Cars cars : afterGameCars.finalResultCars()) {
            System.out.println(cars.makeResultOutput());
        }
        printFinalWinner(afterGameCars.findWinners());
    }

    private void printFinalWinner(List<String> winner) {
        String finalWinner = "최종 우승자 : "
                + String.join(", ", winner);
        System.out.println(finalWinner);
    }
}

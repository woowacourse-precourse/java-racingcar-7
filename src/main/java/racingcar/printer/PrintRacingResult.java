package racingcar.printer;

import java.util.List;
import racingcar.application.Printer;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Result;

public class PrintRacingResult implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printResultAfterGame(Result result) {
        print("실행 결과");
        for (Cars cars : result.finalResultCars()) {
            print(makeResultOutput(cars));
        }
        printFinalWinner(result.findWinners());
    }

    private String makeResultOutput(Cars cars) {
        StringBuilder resultString = new StringBuilder();
        for (Car car : cars.allCar()) {
            resultString.append(makeCarDistanceResult(car)).append('\n');
        }
        return resultString.toString();
    }

    private String makeCarDistanceResult(Car car) {
        return car.name() + " : " + "-".repeat(Math.max(0, car.distance()));
    }

    private void printFinalWinner(List<String> winners) {
        String finalWinner = "최종 우승자 : "
                + String.join(", ", winners);
        print(finalWinner);
    }
}

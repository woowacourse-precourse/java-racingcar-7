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
    public void printResultAfterGame(Result afterGameCars) {
        System.out.println("실행 결과");
        for (Cars cars : afterGameCars.finalResultCars()) {
            System.out.println(makeResultOutput(cars));
        }
        printFinalWinner(afterGameCars.findWinners());
    }

    private void printFinalWinner(List<String> winner) {
        String finalWinner = "최종 우승자 : "
                + String.join(", ", winner);
        System.out.println(finalWinner);
    }

    private String makeResultOutput(Cars cars) {
        StringBuilder resultString = new StringBuilder();
        for (Car car : cars.allCar()) {
            resultString.append(makeCarDistanceResult(car));
            resultString.append('\n');
        }
        return resultString.toString();
    }

    private String makeCarDistanceResult(Car car) {
        return car.name() + " : " + "-".repeat(Math.max(0, car.distance()));
    }
}

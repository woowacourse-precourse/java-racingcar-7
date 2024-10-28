package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.Constant;

import java.util.List;

public class OutputView {

    public void printRoundResult(Race race) {
        for (Car car : race.getCarList()) {
            int currentLocation = car.getCurrentLocation();
            System.out.print(car.getName() + " : ");  // 자동차 이름
            System.out.print(Constant.PROGRESS_INDICATOR.repeat(currentLocation));  // 전진한 정도
            System.out.println();
        }
        System.out.println();
    }

    public void printFinalWinners(List<Car> finalWinners) {
        System.out.print("최종 우승자 : ");

        List<String> winnersName = getWinnersName(finalWinners);

        System.out.println(String.join(", ", winnersName));
    }

    private List<String> getWinnersName(List<Car> finalWinners) {
        return finalWinners.stream()
                .map(Car::getName)
                .toList();
    }

}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarOutputHandler {
    public void runRace(List<Car> carList, int howManyTimesMove) {
        for (int i = 0; i < howManyTimesMove; i++) {
            for (Car car : carList) {
                car.carMove();
            }
            printCarRacingProgress(carList, i + 1);
        }
        List<Car> winners = findRacingWinners(carList);
        printCarRacingWinner(winners);
    }

    public void printCarRacingProgress(List<Car> carList, int roundNumber) {
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.println(car.getCarName() + " : " + car.displayPosition());
        }
        System.out.println();
    }

    public void printCarRacingWinner(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getCarName());
            if (i < winners.size() - 1) {
                winnerNames.append(", ");
            }
        }
        System.out.println(winnerNames);
    }

    public List<Car> findRacingWinners(List<Car> carList) {
        int maxPosition = carList.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .orElse(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getCarPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judgement {

    private static final int MOVE_STANDARD = 3;
    private Car[] cars;

    public Judgement(Car[] cars) {
        this.cars = cars;
    }

    private void printRoundResult(Car currentCar) {
        int currentCarLocation = currentCar.getcurrentLocation();
        System.out.print(currentCar.name() + " : ");
        for (int count = 0; count < currentCarLocation; count++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void updateRoundResult(List<Integer> randomNumbers) {
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            Car curCar = cars[carIndex];
            if (randomNumbers.get(carIndex) > MOVE_STANDARD) {
                curCar.move();
            }
            printRoundResult(curCar);
        }
        System.out.println();
    }

    private List<String> judgeWinner() {
        List<String> winners = new ArrayList<>();
        int maxLocationNum = cars[0].getcurrentLocation();
        winners.add(cars[0].name());

        for (int i = 1; i < cars.length; i++) {
            Car curCar = cars[i];
            if (curCar.getcurrentLocation() > maxLocationNum) {
                maxLocationNum = curCar.getcurrentLocation();
                winners.clear();
                winners.add(curCar.name());
                continue;
            }
            if (curCar.getcurrentLocation() == maxLocationNum) {
                winners.add(curCar.name());
            }
        }
        return winners;
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        List<String> winners = judgeWinner();
        System.out.println(String.join(", ", winners));
    }

}

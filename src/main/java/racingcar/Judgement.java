package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judgement {

    private Car[] cars;

    public Judgement(Car[] cars) {
        this.cars = cars;
    }

    private void printRoundResult(Car curCar) {
        int curCarLocation = curCar.getcurrentLocation();
        System.out.print(curCar.name() + " : ");
        for (int count = 0; count < curCarLocation; count++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void updateRoundResult(List<Integer> randomNumbers) {
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            Car curCar = cars[carIndex];
            if (randomNumbers.get(carIndex) > 3) {
                curCar.move();
            }
            printRoundResult(curCar);
        }
        System.out.println();
    }

    private List<String> judgeWinner() {
        List<String> winnerList = new ArrayList<>();
        int maxLocationNum = cars[0].getcurrentLocation();
        winnerList.add(cars[0].name());

        for (int i = 1; i < cars.length; i++) {
            Car curCar = cars[i];
            if (curCar.getcurrentLocation() > maxLocationNum) {
                maxLocationNum = curCar.getcurrentLocation();
                winnerList.clear();
                winnerList.add(curCar.name());
                continue;
            }
            if (curCar.getcurrentLocation() == maxLocationNum) {
                winnerList.add(curCar.name());
            }
        }
        return winnerList;
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        List<String> winnerList = judgeWinner();
        System.out.println(String.join(", ", winnerList));
    }

}

package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputService {
    List<String> winnerList = new ArrayList<>();

    public void printStartRacing() {
        System.out.println("\n실행 결과");
    }

    public void printRacingResults(List<String> nameOfCar, List<Integer> movementNum) {
        for (int i=0; i<nameOfCar.size(); i++) {
            System.out.print(nameOfCar.get(i)+" : ");
            int movement = movementNum.get(i);
            printMovement(movement);
            System.out.println();
        }
        System.out.println();
    }

    public void printMovement(int movement) {
        for (int j=0; j<movement; j++) {
            System.out.print("-");
        }
    }

    public void findWinner(List<Integer> movementNum, List<String> nameOfCar) {
        int max = Collections.max(movementNum);

        for (int i=0; i<movementNum.size(); i++) {
            int num = movementNum.get(i);
            if (num == max) {
                String name = nameOfCar.get(i);
                winnerList.add(name);
            }
        }
        printWinner();
    }

    public void printWinner() {
        System.out.print("최종 우승자 : " + String.join(",", winnerList));
    }
}

package racingcar;

import java.util.List;

public class RacePrinter {
    public void printPositions(List<String> carNames, List<Integer> carPositions) {

        for (int i = 0; i < carNames.size(); i++) {

            String position = "-".repeat(carPositions.get(i));
            System.out.println(carNames.get(i) + " : " + position);
        }
        System.out.println();
    }
}

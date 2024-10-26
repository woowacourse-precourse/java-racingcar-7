package racingcar.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printOutputView(Map<String, Integer> racingCars) {
        System.out.println("실행 결과");
        printRound(racingCars);
    }

    private void printRound(Map<String, Integer> racingCars) {
        for (String carName : racingCars.keySet()) {
            int go = racingCars.get(carName);

            System.out.println(carName + " : " + "-".repeat(go) );
        }
        System.out.println();
    }

    public void printWinnerView(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners);
    }

}

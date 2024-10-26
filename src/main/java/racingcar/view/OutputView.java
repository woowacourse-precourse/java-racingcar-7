package racingcar.view;

import java.util.Map;

public class OutputView {

    public void printOutputView() {
        System.out.println("실행 결과");
        //printRound();
    }

    private void printRound(Map<String, Integer> racingCar) {
        for (String carName : racingCar.keySet()) {
            int go = racingCar.get(carName);

            System.out.println(carName + " : " + "-".repeat(go) );
        }
        System.out.println();
    }
}

package racingcar;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {



    public void printStep(String carName, int carLocation) {
        System.out.print(carName + " : ");
        for (int i = 0; i < carLocation; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    public void printWinner(List<String> cars){
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String car : cars) {
            stringJoiner.add(car);
        }
        System.out.println("최종 우승자 : " + stringJoiner.toString());
    }
}

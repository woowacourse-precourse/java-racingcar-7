package racingcar;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {


    public void printWinner(List<String> cars){
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String car : cars) {
            stringJoiner.add(car);
        }
        System.out.println("최종 우승자 : " + stringJoiner.toString());
    }
}

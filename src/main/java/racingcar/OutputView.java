package racingcar;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {

    public void printStep(List<Round> rounds) {
        System.out.println("실행 결과");
        for (Round round : rounds) {
            round.getCarLocation().forEach((name,location) ->{
                System.out.print(name + " : ");
                for(int i=0;i<location;i++) {
                    System.out.print("-");
                }
                System.out.println();
            });
            System.out.println();
        }
    }

    public void printWinner(List<String> cars){
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String car : cars) {
            stringJoiner.add(car);
        }
        System.out.println("최종 우승자 : " + stringJoiner.toString());
    }
}

package racingcar.view;

import racingcar.domain.Round;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void printStep(List<Round> rounds) {
        System.out.println("\n실행 결과");
        for (Round round : rounds) {
            printEachCar(round);
            System.out.println();
        }
    }

    private void printEachCar(Round round) {
        round.getCarLocation().forEach((name, location) ->{
            System.out.print(name + " : ");
            for(int i=0;i<location;i++) {
                System.out.print("-");
            }
            System.out.println();
        });
    }

    public void printWinner(List<String> cars){
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String car : cars) {
            stringJoiner.add(car);
        }
        System.out.println("최종 우승자 : " + stringJoiner.toString());
    }
}

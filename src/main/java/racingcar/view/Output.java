package racingcar.view;

import java.util.List;

public class Output {
    public void printIntermediateResult(StringBuilder stringBuilder) {
        System.out.print(stringBuilder);
    }

    public void printMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

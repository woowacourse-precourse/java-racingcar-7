package view;

import java.util.List;

public class OutputView {

    private static final String FORWARD_UNIT = "-";

    public void printf(String message) {
        System.out.printf(message);
    }

    public void finalWinners(List<String> winners) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));
    }

    public void printRacing(String carName, int forward) {
        System.out.printf("%s : %s%n", carName, FORWARD_UNIT.repeat(Math.max(0, forward)));
    }
}

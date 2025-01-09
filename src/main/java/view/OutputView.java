package view;

import java.util.List;

public class OutputView {

    public void println(String message) {
        if (message == null) {
            System.out.println();
            return;
        }
        System.out.println(message);
    }

    public void printf(String message) {
        System.out.printf(message);
    }

    public void finalWinners(List<String> winners) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));
    }

    public void printRacing(List<String> racingInfo) {
        for (String carForwardInfo : racingInfo) {
            System.out.print(carForwardInfo);
        }
        println(null);
    }

}

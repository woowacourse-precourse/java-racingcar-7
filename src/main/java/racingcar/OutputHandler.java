package racingcar;

import java.util.List;

public class OutputHandler {
    public static void printFinalWinner(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(",", winnerList));
    }

    public static void printMoveCountAndName(String name, int moveCount) {
        System.out.print(name + " : " + "-".repeat(moveCount) + "\n");
    }

    public static void changeLine() {
        System.out.println();
    }
}

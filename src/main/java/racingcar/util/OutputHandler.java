package racingcar.util;

public class OutputHandler {
    public void printCurrentResult(String[] results) {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }
    public void printFinalResult(String[] results) {
        System.out.println("최종 우승자 : " + String.join(", ", results));
    }

    public void printError(String message) {
        System.out.println("Error: " + message);
    }
}

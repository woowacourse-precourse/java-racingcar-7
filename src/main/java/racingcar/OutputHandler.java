package racingcar;

public class OutputHandler {
    public void printResult(String[] results) {
        System.out.println("최종 우승자 : " + String.join(", ", results));
    }

    public void printError(String message) {
        System.out.println("Error: " + message);
    }
}

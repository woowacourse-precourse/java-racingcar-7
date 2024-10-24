package racingcar.presentation;

public class OutputView {
    private static final String RUN_START_NOTIFIER = "실행 결과";

    public void printRunStarted(){
        System.out.println(RUN_START_NOTIFIER);
    }

    public void printOutput(String input) {
        System.out.println(input);
    }

    public void printWinner(String winner){
        System.out.println(winner);
    }
}

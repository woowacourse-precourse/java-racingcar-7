package racingcar.presentation;

public class OutputView {
    private static final String RUN_START_NOTIFIER = "\n실행 결과";

    public void printRunStarted(){
        System.out.println(RUN_START_NOTIFIER);
    }

    public void print(String input){
        System.out.println(input);
    }
}

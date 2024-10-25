package racingcar.io;

public class View {
    private static View INSTANCE;

    private View() {}
    public static View getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new View();
        }
        return INSTANCE;
    }

    public void printCarNamesGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRoundsGuide() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printExecutionOutput(String executionOutput) {
        System.out.println("실행 결과");
        System.out.println(executionOutput);
    }

    public void printWinner(String winnerNames) {
        System.out.println(winnerNames);
    }

}

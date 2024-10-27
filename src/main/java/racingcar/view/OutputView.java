package racingcar.view;

public class OutputView {

    public void printRunResultMessage() {
        System.out.println("실행 결과");
    }

    public void printForwardStatuses(String forwardStatuses) {
        System.out.println(forwardStatuses);
    }

    public void printWinningNames(String winningNames) {
        System.out.printf("최종 우승자 : %s%n", winningNames);
    }
    
}

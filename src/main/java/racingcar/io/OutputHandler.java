package racingcar.io;

public class OutputHandler {

    public void showCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showRoundInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }


    public void showGameResult(String gameResult) {
        System.out.println(gameResult);
    }

}

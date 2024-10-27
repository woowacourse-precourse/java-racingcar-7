package racingcar.view;

import java.util.List;

public class OutputView {
    private final static String CAR_POSITION = "-";

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printCarDistance(String name, int distance) { //Car 객체를 넘겨 받는 것이 좋은건지..? 그런데 도메인을 그대로 넘겨주면 위험할듯
        System.out.println(name + " : " + CAR_POSITION.repeat(distance));
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printWinner(List<String> winnerNameList) {
        String winner = String.join(",", winnerNameList);
        System.out.println("최종 우승자 : " + winner);
    }

    public void printEmptyLine(){
        System.out.println();
    }
}

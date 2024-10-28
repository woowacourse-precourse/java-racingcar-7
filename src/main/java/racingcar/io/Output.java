package racingcar.io;

import java.util.List;

public class Output {

    public void carNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void playCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printScore(StringBuilder score) {
        System.out.println(score);
    }

    public void announceWinners(List<String> winners) {
        String winner = String.join(", ", winners);

        System.out.print("최종 우승자 : " + winner);
    }

}


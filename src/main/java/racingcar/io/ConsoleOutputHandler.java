package racingcar.io;

import java.util.List;

public class ConsoleOutputHandler {

    public void racingCarNamingMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void attemptCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void showCarDistance(String carName, int distance) {
        System.out.printf("%s : %s%n", carName, "-".repeat(distance));
    }

    public void finalWinnerMessage(List<String> winnerList) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerList));
    }
}

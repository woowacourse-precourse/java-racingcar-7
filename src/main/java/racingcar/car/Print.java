package racingcar.car;

import java.util.List;

public class Print {
    public void carNameInputRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
    }

    public void roundInputRequest() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public void result() {
        System.out.println("실행 결과");
    }

    public void winner(List<Car> cars) {
        Compare compare = new Compare();
        StringBuilder winnerNames = new StringBuilder();
        List<String> winners = compare.winnerName(cars);
        for (String winner : winners) {
            winnerNames.append(winner).append(", ");
        }
        winnerNames.delete(winnerNames.length() - 2, winnerNames.length());
        System.out.println("최종 우승자 " + ": " + winnerNames.toString());
    }
}


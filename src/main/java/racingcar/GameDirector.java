package racingcar;


import java.util.List;

import static racingcar.SystemMessage.*;

public class GameDirector {
    private final int count;
    private final CarManager manager = new CarManager();

    public GameDirector(String carNames,String count) {
        manager.add(carNames);
        this.count = Validator.validateCountIfNegative(count);
    }

    public void run() {
        manager.moveCars(this.count);
    }
    public void printWinner() {
        List<String> winnerList = manager.getWinner();
        if (winnerList.size() == 1) {
            Printer.print(RESULT, winnerList.get(0)); // 단일 우승자 출력
        } else {
            String winner = String.join(", ", winnerList); // 다수 우승자는 쉼표로 구분하여 출력
            Printer.print(RESULT, winner);
        }
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Set;

public class Stadium {
    private final CarRegistry carRegistry;
    private final Integer rounds;
    private final StringBuilder executionResult = new StringBuilder();

    public Stadium(CarRegistry carRegistry, Integer rounds) {
        this.carRegistry = carRegistry;
        this.rounds = rounds;
    }

    public void runGame() {
        for (int i = 0; i < rounds; i++) {
            executeOneRound();
        }
    }

    public String getWinner() {
        Set<String> winners = carRegistry.getWinnerNames();
        String winnersString = "최종 우승자 : " + String.join(", ", winners);
        return winnersString;
    }

    public String getResult() {
        return executionResult.toString();
    }

    private void executeOneRound() {
        for(Car car : carRegistry.getCars()){
            if(doesCarMove()){
                car.goForward();
            }
        }
        executionResult.append(carRegistry.toString()).append("\n");
    }

    private boolean doesCarMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}

package racingcar;

import static racingcar.ConstantMessage.FINAL_RESULT;
import static racingcar.ConstantMessage.FINAL_WINNER;

import java.util.ArrayList;
import java.util.List;

public class GameCarProcess {
    private List<GameCar> gameCarList;
    private int count;

    public GameCarProcess(List<GameCar> gameCarList, int count) {
        this.gameCarList = gameCarList;
        this.count = count;
    }

    void gameProgress() {
        System.out.println(FINAL_RESULT);
        for (int i = 0; i < count; i++) {
            gameCarProgress();
            System.out.println();
        }
        winnerPrint(findWinner());
    }

    void gameCarProgress() {
        for (GameCar gameCar : gameCarList) {
            int randNum = RandNumPick.pickRandomNumber();
            gameCar.move(randNum);
            gameCar.displayPrint();
        }
    }

    public List<String> findWinner() {
        int maxWinner = 0;
        for (GameCar gameCar : gameCarList) {
            int current = gameCar.getForwardMarksSize();
            if (current > maxWinner) {
                maxWinner = current;
            }
        }
        List<String> winners = new ArrayList<>();
        for (GameCar gameCar : gameCarList) {
            if (gameCar.getForwardMarksSize() == maxWinner) {
                winners.add(gameCar.getCarName());
            }
        }
        return winners;
    }

    void winnerPrint(List<String> winners) {
        System.out.print(FINAL_WINNER);
        System.out.println(String.join(", ", winners));
    }
}
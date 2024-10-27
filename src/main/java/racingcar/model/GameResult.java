package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<Car> gameResult;
    private boolean isLast;

    private GameResult(List<Car> gameResult) {
        this.gameResult = gameResult;
    }

    public static GameResult of(List<Car> gameResult) {
        return new GameResult(gameResult);
    }

    public static GameResult ofEmpty() {
        return of(new ArrayList<>());
    }

    public String getFinalWinnerForDisplay() {
        List<String> finalWinner = new ArrayList<>();
        int maxForwardNumber = findMaxForwardNumber();
        getFinalWinner(maxForwardNumber, finalWinner);

        return String.join(",", finalWinner);
    }

    @Override
    public String toString() {
        StringBuilder resultForDisplay = new StringBuilder();
        for (Car car : gameResult) {
            resultForDisplay.append(car.toString()).append("\n");
        }

        return resultForDisplay.toString();
    }

    private void getFinalWinner(int maxForwardNumber, List<String> finalWinner) {
        for (Car car : gameResult) {
            if (car.isWinner(maxForwardNumber)) {
                finalWinner.add(car.getName());
            }
        }
    }

    private int findMaxForwardNumber() {
        int maxForwardNumber = Integer.MIN_VALUE;
        for (Car car : gameResult) {
            if (car.isMaxForwardNumber(maxForwardNumber)) {
                maxForwardNumber = car.getForwardNumber();
            }
        }

        return maxForwardNumber;
    }

    public void checkLastGameResult() {
        isLast = true;
    }

    public boolean isLastGameResult() {
        return isLast;
    }

    public List<Car> getGameResult() {
        return new ArrayList<>(gameResult);
    }

}
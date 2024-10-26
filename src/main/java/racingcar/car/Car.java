package racingcar.car;

import static racingcar.car.Constants.EMPTY_STRING;
import static racingcar.car.Constants.MAX_LENGTH_OF_NAME;
import static racingcar.car.ErrorMessage.EMPTY_STRING_NAME_ERROR_MESSAGE;
import static racingcar.car.ErrorMessage.NAME_LENGTH_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Car implements Comparable<Car> {

    private final String name;
    private int moveCount;

    public Car(String name) {
        validateEmptyStringName(name);
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void attemptMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            moveCount++;
        }
    }

    public void attemptMove(int randomNumber) {
        if (randomNumber >= 4) {
            moveCount++;
        }
    }

    public void showStatus() {
        String moveStatus = moveCountToHyphen();
        printStatus(moveStatus);
    }

    public boolean isWinner(int winnerMoveCount) {
        return winnerMoveCount == moveCount;
    }

    @Override
    public int compareTo(Car other) {
        return other.moveCount - this.moveCount;
    }

    private void validateEmptyStringName(String name) {
        if (name.equals(EMPTY_STRING)) {
            throw new IllegalArgumentException(EMPTY_STRING_NAME_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }


    private String moveCountToHyphen() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < moveCount; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    private void printStatus(String moveStatus) {
        System.out.println(name + " : " + moveStatus);
    }
}
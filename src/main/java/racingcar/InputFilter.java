package racingcar;

public class InputFilter {

    private static final int MAX_NAME_LENGTH = 5;
    private final int moveCount;
    private final String[] carNames;

    public InputFilter(String rawCarNames, String rawMoveCount) {
        String[] carNames = validateCarNames(rawCarNames);
        int moveCount = validateMoveCount(rawMoveCount);

        this.carNames = carNames;
        this.moveCount = moveCount;
    }

    public String[] validateCarNames(String carNames) {
        String[] splitCarNames = carNames.split(",");
        validNameLength(splitCarNames);
        return splitCarNames;
    }

    private static void validNameLength(String[] splitCarNames) {
        for (String carName : splitCarNames) {
            if (carName.length() > MAX_NAME_LENGTH || carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    public int validateMoveCount(String moveCount) {
        int moveCountInt = validInteger(moveCount);
        validPositive(moveCountInt);

        return moveCountInt;
    }

    private static void validPositive(int moveCountInt) {
        if (moveCountInt < 1) {
            throw new IllegalArgumentException("이동 횟수는 1 이상만 가능합니다.");
        }
    }

    private static int validInteger(String moveCount) {
        int moveCountInt;
        try {
            moveCountInt = Integer.parseInt(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자만 가능합니다.");
        }
        return moveCountInt;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getMoveCount() {
        return moveCount;
    }
}

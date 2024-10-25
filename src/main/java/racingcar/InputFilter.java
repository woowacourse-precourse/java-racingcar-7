package racingcar;

//자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
//사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
public class InputFilter {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private int moveCount;
    private String[] carNames;

    public InputFilter() {
    }

    public void validateCarNames(String carNames) {
        this.carNames = carNames.split(",");
        for (String carName : this.carNames) {
            if (carName.length() > MAX_NAME_LENGTH || carName.length() < MIN_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    public void validateMoveCount(String moveCount) {
        try {
            this.moveCount = Integer.parseInt(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자만 가능합니다.");
        }
        if (this.moveCount < 1) {
            throw new IllegalArgumentException("이동 횟수는 1 이상만 가능합니다.");
        }
    }
}

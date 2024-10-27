package racingcar.model;

public class GameCoinInput {
    private static final String FORMAT_ERROR = "게임 횟 수는 숫자만 입력해 주세요, 혹은 입력 할 수 있는 수의 최대치를 넘었습니다.";
    private static final String MINIMUM_COIN_COUNT_ERROR = "0 보다 큰 수를 입력해 주세요";
    private static final int MINIMUM_COIN_COUNT = 1;
    String userInput;
    int coin;

    public GameCoinInput(String userInput) {
        this.userInput = userInput;
        validate();
    }

    private void validate() {
        validateNumber();
        validateNumberMinimum();
    }

    public int getGameCoin() {
        return coin;
    }

    public void validateNumber() {
        try {
            coin = Integer.parseInt(userInput);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        }
    }

    private void validateNumberMinimum() {
        if (coin < MINIMUM_COIN_COUNT) {
            throw new IllegalArgumentException(MINIMUM_COIN_COUNT_ERROR);
        }
    }

}

package racingcar.model;

public class GameCoinInput {
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
            throw new IllegalArgumentException("게임 횟 수는 숫자만 입력해 주세요, 혹은 입력 할 수 있는 수의 최대치를 넘었습니다.");
        }
    }

    private void validateNumberMinimum() {
        if (coin < 1) {
            throw new IllegalArgumentException("0 보다 큰 수를 입력해 주세요");
        }
    }

}

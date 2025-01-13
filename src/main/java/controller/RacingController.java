package controller;

import exception.CustomIllegalArgException;
import racingcar.Cars;
import racingcar.Racing;
import view.InputView;
import view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            Racing racing = createRacing();
            playAllRacing(racing, validCount(inputView.inputAttemptCount()));
            printWinner(racing);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private Racing createRacing() {
        String carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames);
        return new Racing(cars);
    }

    private void playAllRacing(Racing racing, int attemptCount) {
        outputView.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            racing.playRacing();
            outputView.printRacing(racing.racingInfo());
        }
    }

    private void printWinner(Racing racing) {
        outputView.finalWinners(racing.findWinners());
    }

    private int validCount(String inputCount) {
        try {
            int attemptCount = Integer.parseInt(inputCount);
            if (attemptCount < 1 || attemptCount > 1_000_000_000) {
                throw new IllegalArgumentException("시도 횟수는 1 이상 1,000,000,000 이하의 숫자여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgException("숫자만 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            throw new CustomIllegalArgException(e.getMessage());
        }
    }
}

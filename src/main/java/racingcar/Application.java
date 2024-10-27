package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.ValueExtractor;
import racingcar.validator.NumberValidator;
import racingcar.validator.StringValidator;
import racingcar.view.InputView;

import static racingcar.domain.ValueExtractor.getDelimitedValue;

public class Application{
    public static void main(String[] args) {

        // 1. 자동차 이름 입력받고 검증하기
        String cars = InputView.getCars();

        String[] delimitedValue = getDelimitedValue(cars);
        StringValidator.validateAllStringValues(delimitedValue);

        // 2. 경기 횟수 입력받고 검증하기
        String racingCount = InputView.getRacingCount();

        NumberValidator.validateNumericValue(racingCount);
        int numericValue = ValueExtractor.getNumericValue(racingCount);

        // 3. 자동차 경주 실시
        RacingGame racingGame = new RacingGame(delimitedValue, numericValue);
        racingGame.play();

    }
}

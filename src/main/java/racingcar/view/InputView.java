package racingcar.view;

import racingcar.dto.CarNamesInput;
import racingcar.dto.TryCountInput;

public interface InputView {
    CarNamesInput readCarNames();

    TryCountInput readTryCount();
}

package racingcar.gameplayer.game.racinggame.ui.helper;

import racingcar.gameplayer.game.common.exception.CustomException;
import racingcar.gameplayer.game.common.domain.Names;
import racingcar.gameplayer.game.common.domain.PositiveNumber;
import racingcar.gameplayer.game.common.exception.ErrorMessage;
import racingcar.gameplayer.game.racinggame.ui.component.ConsoleInputComponent;
import racingcar.gameplayer.game.racinggame.ui.component.InputComponent;

public class InputHelper {

    private static final InputComponent inputComponent = new ConsoleInputComponent();

    public Names getNames() {
        try {
            String names = inputComponent.getValue("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            return new Names(names);
        } catch (Exception e) {
            throw new CustomException(ErrorMessage.INVALID_NAME_FORMAT_ERROR);
        }
    }

    public PositiveNumber getTryCount() {
        try {
            String count = inputComponent.getValue("시도할 횟수는 몇 회인가요?");
            return new PositiveNumber(count);
        } catch (Exception e) {
            throw new CustomException(ErrorMessage.INVALID_COUNT_ERROR);
        }
    }
}

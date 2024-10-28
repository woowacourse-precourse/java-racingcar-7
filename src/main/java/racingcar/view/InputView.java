package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RawCarNamesInput;
import racingcar.dto.RawMovingCountInput;
import racingcar.validator.MovingCountValidator;
import racingcar.validator.RawCarNamesValidator;

public class InputView {

    private final OutputView outputView = new OutputView();
    private final RawCarNamesValidator rawCarNamesValidator = new RawCarNamesValidator();
    private final MovingCountValidator movingCountValidator = new MovingCountValidator();

    public String inputCarNames() {
        outputView.printCarNamesInstruction();
        RawCarNamesInput rawCarNamesInput = RawCarNamesInput.of(Console.readLine());

        String rawCarNames = rawCarNamesInput.rawCarNames();

        rawCarNamesValidator.validateNotEmpty(rawCarNames);

        return rawCarNames;
    }

    public String inputMovingCount() {
        outputView.printMovingCountInstruction();
        RawMovingCountInput rawMovingCountInput = RawMovingCountInput.of(Console.readLine());

        String rawMovingCount = rawMovingCountInput.rawMovingCount();

        movingCountValidator.validateNotEmpty(rawMovingCount);

        return rawMovingCount;
    }
}

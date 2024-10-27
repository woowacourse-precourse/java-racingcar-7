package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.RawCarNamesValidator;

public class InputView {

    private final OutputView outputView = new OutputView();
    private final RawCarNamesValidator rawCarNamesValidator = new RawCarNamesValidator();

    public String inputCarNames() {
        outputView.printCarNamesInstruction();
        String rawCarNames = Console.readLine().stripLeading().stripTrailing();

        rawCarNamesValidator.isEmpty(rawCarNames);

        return rawCarNames;
    }
}

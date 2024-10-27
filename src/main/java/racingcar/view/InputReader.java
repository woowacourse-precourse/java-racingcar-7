package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Validator;

public class InputReader {

    private final OutputWriter outputWriter;
    private final Validator validator;

    public InputReader(OutputWriter outputWriter, Validator validator) {
        this.outputWriter = outputWriter;
        this.validator = validator;
    }

    public String inputRacingCarNames() {
        outputWriter.printCarNamesInputMessage();
        String racingCarNames = Console.readLine().trim();

        validator.validateEmptyRacingCarNames(racingCarNames);

        return racingCarNames;
    }

    public Integer inputRacingCount() {
        outputWriter.printRaceCountInputMessage();
        String racingCount = Console.readLine().trim();

        validator.validateEmptyRacingCount(racingCount);
        validator.validateInvalidRacingCount(racingCount);

        return Integer.parseInt(racingCount);
    }

}

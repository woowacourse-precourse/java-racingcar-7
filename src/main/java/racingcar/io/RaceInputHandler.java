package racingcar.io;

import racingcar.constants.InputMessages;
import racingcar.dto.RaceRequest;
import racingcar.io.reader.Reader;
import racingcar.io.writer.Writer;

public class RaceInputHandler {

    private final Reader reader;
    private final Writer writer;
    private final RaceInputValidator validator;

    public RaceInputHandler(
            Reader reader,
            Writer writer,
            RaceInputValidator validator
    ) {
        this.reader = reader;
        this.writer = writer;
        this.validator = validator;
    }

    public RaceRequest handle() {
        String carNames = getCarNames();
        int lapCount = getLapCount();

        return RaceRequest.of(carNames, lapCount);
    }

    private String getCarNames() {
        writer.write(InputMessages.CARNAME_DESCRIPTION);
        String carNames = reader.readLine();
        validator.validateCarNames(carNames);
        return carNames;
    }

    private int getLapCount() {
        writer.write(InputMessages.LAPCOUNT_DESCRIPTION);
        int lapCount = reader.readLineToInt();
        validator.validateLapCount(lapCount);
        return lapCount;
    }
}
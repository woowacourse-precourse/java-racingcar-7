package racingcar.io;

import racingcar.dto.RaceResult;
import racingcar.io.writer.Writer;

public class RaceOutputHandler {

    private final Writer writer;
    private final RaceResultParser parser;
    private final RaceResultValidator validator;

    public RaceOutputHandler(Writer writer, RaceResultParser parser, RaceResultValidator validator) {
        this.writer = writer;
        this.parser = parser;
        this.validator = validator;
    }

    public void handle(RaceResult raceResult) {
        validator.validateRaceResult(raceResult);
        String resultString = parser.parse(raceResult);
        writer.write(resultString);
    }
}
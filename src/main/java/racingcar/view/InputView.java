package racingcar.view;

import racingcar.domain.CarName;
import racingcar.domain.TrialCount;
import racingcar.dto.request.CarsRequest;
import racingcar.io.input.Reader;
import racingcar.io.output.Writer;
import racingcar.util.CarNameConverter;

import java.util.List;

public class InputView {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRIAL_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public CarsRequest readCarNames() {
        writer.writeln(CAR_NAME_INPUT_MESSAGE);
        String carNames = reader.readLine();
        List<CarName> cars = CarNameConverter.convert(carNames);
        return new CarsRequest(cars);
    }

    public TrialCount readTrialCount() {
        writer.writeln(TRIAL_COUNT_INPUT_MESSAGE);
        String trialCountString = reader.readLine();
        int trialCount = Integer.parseInt(trialCountString);
        return new TrialCount(trialCount);
    }
}

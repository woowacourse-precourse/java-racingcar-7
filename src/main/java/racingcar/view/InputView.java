package racingcar.view;

import racingcar.domain.CarName;
import racingcar.dto.request.CarsRequest;
import racingcar.exception.ExceptionMessage;
import racingcar.io.input.Reader;
import racingcar.io.output.Writer;
import racingcar.util.CarNameConverter;

import java.util.List;

import static racingcar.exception.ExceptionMessage.*;

public class InputView {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final int START_TRY_COUNT = 1;
    public static final int END_TRY_COUNT = 10;

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

    public int readTryCount() {
        writer.writeln(TRY_COUNT_INPUT_MESSAGE);
        String tryCountString = reader.readLine();
        int tryCount = Integer.parseInt(tryCountString);
        validateRange(tryCount);
        return tryCount;
    }

    private static void validateRange(int tryCount) {
        if (tryCount < START_TRY_COUNT || tryCount > END_TRY_COUNT) {
            throw new IllegalArgumentException(
                    TRY_COUNT_OUT_OF_RANGE.formatMessage("최소 %d번, 최대 %d번까지 시도 가능합니다."
                            , START_TRY_COUNT
                            , END_TRY_COUNT
                    )
            );
        }
    }
}

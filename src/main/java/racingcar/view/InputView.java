package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.view.input.ConsoleReader;
import racingcar.view.input.Reader;
import racingcar.view.output.ConsoleWriter;
import racingcar.view.output.Writer;

public class InputView {

    private static final Reader DEFAULT_READER = new ConsoleReader();
    private static final Writer DEFAULT_WRITER = new ConsoleWriter();

    private static final String NAME_DELIMITER = ",";

    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public InputView() {
        this(DEFAULT_READER, DEFAULT_WRITER);
    }

    public List<String> inputCarNames() {
        writer.writeLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readCarNames();
    }

    private List<String> readCarNames() {
        return Arrays.stream(reader.read().split(NAME_DELIMITER))
                .toList();
    }

    public int inputRoundCount() {
        writer.writeLine("시도할 횟수는 몇 회인가요?");
        return toInt(reader.read());
    }

    private int toInt(String numberText) {
        try {
            return Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자이어야 합니다");
        }
    }
}

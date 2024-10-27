package racingcar.io.reader;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.ExceptionMessages;

public class MissionUtilsReader implements Reader {

    @Override
    public String readLine() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_INPUT, e);
        }
    }

    @Override
    public int readLineToInt() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_NUMBER_FORMAT, ne);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_INPUT, e);
        }
    }
}

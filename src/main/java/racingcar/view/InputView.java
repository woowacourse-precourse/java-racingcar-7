package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.StringToListParser;
import racingcar.exception.Validator;

public class InputView {

    public List<String> getCarList() {
        System.out.println(ConsoleMessage.ENTER_CAR_NAME);
        StringToListParser stringToListParser = new StringToListParser(Console.readLine());
        return stringToListParser.parsingCarName();
    }

    public long getTryNumber() {
        System.out.println(ConsoleMessage.ENTER_TRY_NUMBER);
        return Validator.isNumeric(Console.readLine());
    }

    public void close() {
        Console.close();
    }

}

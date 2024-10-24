package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Splitter;
import racingcar.exception.Validator;

public class InputView {

    public List<String> getCarList() {
        System.out.println(ConsoleMessage.ENTER_CAR_NAME);
        Splitter splitter = new Splitter(Console.readLine());
        return splitter.parsingCarName();
    }

    public long getTryNumber() {
        System.out.println(ConsoleMessage.ENTER_TRY_NUMBER);
        return Validator.isNumeric(Console.readLine());
    }

    public void close() {
        Console.close();
    }

}

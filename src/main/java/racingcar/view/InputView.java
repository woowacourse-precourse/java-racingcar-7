package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.SplitName;
import java.util.List;

public class InputView {
    public List<String> inputNames() {
        String carNames = Console.readLine();
        return SplitName.splitCarName(carNames);
    }
    public String inputTryCount(){
        return Console.readLine();
    }
}
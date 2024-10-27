package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Util.Message.IOMessage;

public class InputView {
    public List<String> inputCarName() {
        System.out.println(IOMessage.INPUT_CAR_NAMES.getMessage());
        String names = Console.readLine();

        return splitNames(names);
    }

    public int inputTrialCount() {
        System.out.println(IOMessage.INPUT_TRIAL_COUNT.getMessage());
        int count = Integer.parseInt(Console.readLine());

        return count;
    }

    public List<String> splitNames(String names) {
        String[] splitNames = names.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : splitNames) {
            carNames.add(name.trim());
        }

        return carNames;
    }
}
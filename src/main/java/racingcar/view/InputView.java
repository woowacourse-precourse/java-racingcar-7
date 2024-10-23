package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static InputView instance;
    private static final OutputView outputView = OutputView.getInstance();

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public List<String> inputCarNames() {
        outputView.printMessage(NAME_MESSAGE);
        String names = Console.readLine();
        return splitNames(names);
    }
    public List<String> splitNames(String names) {
        return List.of(names.split(","));
    }

    public Integer inputCount() {
        outputView.printMessage(COUNT_MESSAGE);
        int count = Integer.parseInt(Console.readLine());
        Console.close();
        return count;
    }


}

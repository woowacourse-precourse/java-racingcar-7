package racingcar.view.inputView;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.validator.MoveCountValidator;

public class MoveCountInputView implements InputView {
    private static final String MOVE_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private final MoveCountValidator validator;

    public MoveCountInputView(){
        this.validator = new MoveCountValidator();
    }

    @Override
    public String input(){
        System.out.println(MOVE_COUNT_INPUT_MESSAGE);
        String input = Console.readLine();

        isValidate(input);

        return input;
    }

    @Override
    public void isValidate(String input) {
        validator.isValidate(input);
    }
}

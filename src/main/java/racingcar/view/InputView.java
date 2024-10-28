package racingcar.view;

import racingcar.dto.InputDto;

public abstract class InputView {

    public InputDto.RequestInputDto readInput() {
        final InputDto.RequestInputDto inputRequest = customInput();

        return inputRequest;
    }

    protected abstract InputDto.RequestInputDto customInput();

    protected abstract void carInputValidate(final String inputString);
}

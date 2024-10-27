package racingcar.view;

import racingcar.model.dto.RoundResultDto;

public class OutputView {

    public void printResultMessage() {
        System.out.println(ViewMessage.RESULT_MESSAGE.getMessage());
    }

    public void printRoundInformation(RoundResultDto result) {
        result.roundResult().forEach((name, position) -> {
            System.out.println(name + " : " + position);
        });
    }
}

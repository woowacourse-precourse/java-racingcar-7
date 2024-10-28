package racingcar.view;

import racingcar.constant.ServiceMessage;

public class OutputView {
    public void printResult(String winnerUser) {
        System.out.println(ServiceMessage.WINNER_USER.getMessage() + winnerUser);
    }
}

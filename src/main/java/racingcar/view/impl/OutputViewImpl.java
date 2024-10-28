package racingcar.view.impl;

import racingcar.constant.Message;
import racingcar.dto.Result;
import racingcar.view.OutputView;

public class OutputViewImpl implements OutputView {
    @Override
    public void printExecutionMessage() {
        System.out.println(Message.EXECUTION_RESULT_HEADER);
    }

    @Override
    public void printResult(Result result) {
        System.out.println(result.middleResult());
    }

    @Override
    public void printFinalWinner(String finalWinner) { // String 타입으로 변경
        System.out.println(finalWinner);
    }
}
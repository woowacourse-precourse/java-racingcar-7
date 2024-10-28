package racingcar.view;

import racingcar.common.IOMessage;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;

public class OutputView {
    public void printRoundResult(CarGroup carGroup) {
        System.out.println(IOMessage.RESULT_NOTICE);
        carGroup.printCarPositions();
        System.out.println();
    }

}

package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.exceptions.RacingCarExceptionHandler;
import racingcar.exceptions.RacingCarExceptionMessage;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final RacingCarView view = new RacingCarView();
    private CarGroup carGroup;
    private int tryNum;

    public void startRace() {
        // 자동차 이름 입력
        view.getCarInputString();
        String carInputString = Console.readLine();
        carGroup = new CarGroup(carInputString.split(","));

        // 시도 횟수 입력
        view.getTryInputString();
        String tryInputString = Console.readLine();
        checkTryNumLength(tryInputString.trim());
        tryNum = Integer.parseInt(tryInputString);

        // race
        race();

        // 결과
        carGroup.calculateMaxScore();
        view.getOutputString(getWinnerString());
    }

    private void checkTryNumLength(String tryNum) {
        if (tryNum.isEmpty()) {
            RacingCarExceptionHandler.throwException(RacingCarExceptionMessage.NO_TRY_NUM);
        } else if (tryNum.equals("0")) {
            RacingCarExceptionHandler.throwException(RacingCarExceptionMessage.TRY_NUM_CANNOT_BE_ZERO);
        }
    }

    private void race() {
        for (int i = 0; i < tryNum; i++) {
            carGroup.go();
            printNow();
        }
    }

    private void printNow() {
        for (Car car : carGroup.getCarList()) {
            System.out.println(car.getName() + " : " + car.scoreToDash(car.getScore()));
        }
        System.out.println();
    }

    private String getWinnerString() {
        return Arrays.toString(carGroup.getWinnerCarList().toArray())
                .replace("[", "").replace("]", "");
    }
}

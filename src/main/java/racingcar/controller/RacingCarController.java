package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
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

        // 시도 횟수
        view.getTryInputString();
        String tryInputString = Console.readLine();
        checkTryNumLength(tryInputString);
        tryNum = Integer.parseInt(tryInputString);
    }

    private void checkTryNumLength(String tryNum){
        if(tryNum.length()==0){
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }
    }
}

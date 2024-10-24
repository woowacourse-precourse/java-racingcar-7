package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RaceReady;

public class InputView {

    public RaceReady readyForRace() {
        String nameInput = requestNameInput();
        String numberOfTime = requestNumberOfTime();
        Console.close();

        return new RaceReady(nameInput, numberOfTime);
    }

    private String requestNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private String requestNumberOfTime() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}

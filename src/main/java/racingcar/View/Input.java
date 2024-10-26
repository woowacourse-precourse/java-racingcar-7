package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private Integer trialCount;

    public List<String> ListRequestCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        List<String> carNameList = List.of(Console.readLine().split(","));
        return carNameList;
    }

    public Integer RequestNumberOfTrialMessage() throws IllegalArgumentException{
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.trialCount = Integer.parseInt(Console.readLine());
        return trialCount;
    }
}

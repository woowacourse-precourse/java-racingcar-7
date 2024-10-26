package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private String carNameList;
    private int currentCount;

    public void nameAndCurrentCount() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carNameList = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.currentCount = Integer.parseInt(Console.readLine());
    }

    public String getCarList() {
        return carNameList;
    }

    public int getCount() {
        return currentCount;
    }
}

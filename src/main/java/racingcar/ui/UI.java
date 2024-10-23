package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class UI {

    public UI() {}

    public String getRacerName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉰표(,) 기준으로 구분)");

        return Console.readLine();
    }

    public int getRacingTimes(){
        System.out.println("시도할 횟수는 몇 회인가요?");

        int times;

        try {
            times = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 형태의 숫자를 입력해주세요.");
        }

        return times;
    }
}

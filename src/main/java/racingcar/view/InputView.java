package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        System.out.println("자동차 이름을 입력하세요(쉼표로 구분): ");
        return Console.readLine();
    }

    public int getRounds() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class ActionManager {
    private final AdvanceAction advanceAction;

    public ActionManager() {
        this.advanceAction = new AdvanceAction();
    }

    public void run() {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String getCar = Console.readLine();
        String[] carList = getCar.split(",");

        validateNameLength(carList);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        advanceAction.setFirst(carList);
        advanceAction.printCarProgress(count);

        advanceAction.printWinner();
        Console.close();
    }

    private void validateNameLength(String[] carList) {
        for (String car : carList) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("요구조건에 따라 자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

}

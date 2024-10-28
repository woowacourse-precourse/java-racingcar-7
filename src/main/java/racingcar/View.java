package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public View() {

    }

    public void showInputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().trim().split(",");
        System.out.println("시도할 횟수는 몇 회인가요?");
        String strCount = Console.readLine().trim();
        int count = Integer.parseInt(strCount);
    }

    public void showOutputView(String[] names) {
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        for (String name : names) {
            winners.append(name).append(", ");
        }
        System.out.print(winners);
    }
}

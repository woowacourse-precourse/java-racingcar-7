package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class View {

    public View() {

    }

    public void showInputView() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] names = Console.readLine().trim().split(",");
            checkValidNames(names);
            System.out.println("시도할 횟수는 몇 회인가요?");
            String strCount = Console.readLine().trim();
            checkValidCount(strCount);
            int count = Integer.parseInt(strCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void showOutputView(String[] names) {
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        for (String name : names) {
            winners.append(name).append(", ");
        }
        System.out.print(winners);
    }

    private void checkValidNames(String[] names) throws Exception {
        for (String name : names) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new Exception("잘못된 이름 입력입니다.");
            }
        }
    }

    private void checkValidCount(String strCount) throws Exception {
        for (char c : strCount.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new Exception("잘못된 횟수 입력입니다.");
            }
        }
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {

    private String[] names;
    private int count;


    public View() {

    }

    public void showInputView() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names = Console.readLine().trim().split(",");
            checkValidNames(names);
            System.out.println("시도할 횟수는 몇 회인가요?");
            String strCount = Console.readLine().trim();
            checkValidCount(strCount);
            count = Integer.parseInt(strCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void showOutputView(List<String> names) {
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < names.size(); i++) {
            if (i < names.size() - 1) {
                winners.append(names.get(i)).append(", ");
            } else {
                winners.append(names.get(i));
            }
        }
        System.out.print(winners);
    }

    public String[] getCarNames() {
        return names;
    }

    public int getCount() {
        return count;
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

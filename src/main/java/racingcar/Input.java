package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private List<String> cars;
    public int tryCount() {
        int count = Integer.parseInt(getReadLine());
        if (count < 0) {
            throw new IllegalArgumentException("잘못된 시도횟수 입니다");
        }
        return count;
    }

    public List<String> carNames() {
        String[] names = getReadLine().split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("잘못된 차량이름 입니다");
            }
            cars.add(name);
        }

        return cars;
    }

    private static String getReadLine() {
        return Console.readLine();
    }
}

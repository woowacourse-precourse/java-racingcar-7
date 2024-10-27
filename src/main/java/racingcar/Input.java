package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private List<Car> cars;
    public int tryCount() {
        System.out.println(Message.INPUT_TRY_COUNT);
        try {
            int count = Integer.parseInt(getReadLine());
            if (count < 0) {
                throw new IllegalArgumentException("잘못된 시도횟수 입니다");
            }
            return count;
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    public List<Car> carNames() {
        System.out.println(Message.INPUT_CAR_NAMES);
        String[] names = getReadLine().split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("잘못된 차량이름 입니다");
            }
            cars.add(new Car(name));
        }

        return cars;
    }

    private static String getReadLine() {
        return Console.readLine();
    }
}

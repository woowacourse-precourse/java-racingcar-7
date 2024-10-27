package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class MainProgram {
    public void main() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();

        carList = carList.replaceAll(" ", "");
        String[] cars = carList.split(",");

        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름 목록 입력 형식이 맞지 않습니다.");
            }
        }

        tryCount = tryCount.replaceAll(" ", "");

        try {
            int count = Integer.parseInt(tryCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도할 횟수 입력 형식이 맞지 않습니다.");
        }
    }
}

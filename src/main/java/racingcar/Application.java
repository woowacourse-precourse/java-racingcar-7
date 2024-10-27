package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;

public class Application {

    private static ArrayList<String> splitCarNames(String carNames) {
        ArrayList<String> carNameList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름 5자 초과");
            } else if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력하지 않음");
            } else {
                carNameList.add(carName.trim()); // 조건 만족 시 자동차 이름 추가
            }
        }
        return carNameList;
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        ArrayList<String> carNameList = splitCarNames(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountString = readLine();
        if (!tryCountString.matches("^[0-9]\\d*$")) {
            throw new IllegalArgumentException("시도 횟수는 0 이상의 정수만 가능");
        }
        int tryCount = Integer.parseInt(tryCountString);
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("Welcome racingcar game!");

        System.out.println("경주할 자동차 이름을 정하시오.(이름은 쉼표(,) 기준으로 구분)");

        String carName = Console.readLine();
        String[] splitName = carName.split(","); // 이름은 쉼표를 기준으로 구분한다.

        // 이름은 5자 이하로 가능하며 5자 초과시 IllegalArgumentException을 발생시킨 후 애플리케이션 종료시킨다.
        for (int i = 0; i < splitName.length; i++) {
            if (splitName[i].length() > 5) {
                throw new IllegalArgumentException("5자 이하로 이름을 정하시오.");
            }
        }
        System.out.println("몇 번의 이동을 할 것인가요?");
        String moveInput = Console.readLine();

        int tryCount;
        try {
            tryCount = Integer.parseInt(moveInput);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }

        List<String> carNameList = Arrays.asList(splitName);

        Racing racing = new Racing(carNameList, tryCount);
        racing.startRace();

        // 우승자 선발 및 출력
        System.out.println();
        racing.winners();
    }
}

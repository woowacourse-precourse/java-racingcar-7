package racingcar;

import static racingcar.RacingHelper.checkCarNamesValidate;
import static racingcar.RacingHelper.checkRacingTimeValidate;
import static racingcar.RacingHelper.printRacingCourse;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        List<String> carNames = checkCarNamesValidate(Console.readLine());

        System.out.println("시도할 횟수는 몇 회인가요?\n");
        int racingTime = checkRacingTimeValidate(Console.readLine());

        System.out.println("실행 결과\n");

        // 전진한 횟수 담는 리스트
        List<Integer> carRunningCountList = carNames.stream().map(s -> 0).collect(Collectors.toList());
        for (int i = 1; i <= racingTime; i++) {
            printRacingCourse(carNames, carRunningCountList);
        }
    }

}

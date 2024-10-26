package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int getTrialCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            int trial = Integer.parseInt(Console.readLine());
            if (trial <= 0) {
               throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return trial;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}

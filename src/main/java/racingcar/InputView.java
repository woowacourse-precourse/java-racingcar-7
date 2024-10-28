package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    // 사용자로부터 자동차 이름들을 입력받음
    public static List<RacingCar> inputRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        return splitNames(names);
    }

    // 사용자로부터 횟수를 입력받음
    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        int times;
        try {
            times = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            // 숫자가 아닌 값 입력시 IllegalArgumentException 발생
            throw new IllegalArgumentException();
        }
        // 0이하의 값 입력 시 예외 처리
        if (times < 1) {
            throw new IllegalArgumentException();
        }
        return times;
    }

    // 쉼표(,) 기준으로 이름을 나눠 List에 저장
    private static List<RacingCar> splitNames(String names) {
        List<RacingCar> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(names, ",");
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            nameList.add(new RacingCar(name));
        }
        return nameList;
    }
}

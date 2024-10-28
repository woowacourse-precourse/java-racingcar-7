package run;

import java.util.ArrayList;
import java.util.List;
import racingcar.Car;
import camp.nextstep.edu.missionutils.Console;
import racingcar.Racing;

public class Run {
    public void start() {
        List<Car> racingCar = new ArrayList<>();
        getCar(racingCar);
        int tryNum = getTryNum();
        racingResult(racingCar, tryNum);
    }


    private void getCar(List<Car> racingCar) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] splitCarName = getCarName(names);

        for (String carName : splitCarName) {
            racingCar.add(new Car(carName, 0));
        }
    }

    private String[] getCarName(String names) {
        String[] carNames = names.split(",");
        if (carNames.length == 0) {
            throw new IllegalStateException();
        }
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            isDigit(carName);
        }
        return carNames;
    }

    private void isDigit(String carName) {
        for (int i = 0; i < carName.length(); i++) {
            char c = carName.charAt(i);
            if (c < 65 || (c > 90 && c < 97) || c > 122) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int getTryNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNum = Console.readLine();
        for (int i = 0; i < tryNum.length(); i++) {
            char c = tryNum.charAt(i);
            if (c >= 48 && c <= 57) {
                continue;
            } else {
                throw new IllegalArgumentException();
            }
        }
        System.out.println();
        return Integer.parseInt(tryNum);

    }

    private static void racingResult(List<Car> racingCar, int tryNum) {
        Racing racing = new Racing(racingCar, tryNum);
        System.out.println("실행 결과");
        for (int i = 0; i < tryNum; i++) {
            racing.game();
            racing.show();
        }
        racing.winner();
    }
}

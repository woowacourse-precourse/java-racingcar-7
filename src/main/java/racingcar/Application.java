package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    // TODO: 사용자가 잘못된 값을 입력했을 때 상황들 생각해보기
    public static void main(String[] args) {
        String carNames = inputCarNames();
        int repeatCount = inputRepeatCount();

        inputValidate(carNames, repeatCount);

        List<Car> carList = toCarList(carNames);
        String winners = runRace(carList, repeatCount);

        System.out.println("최종 우승자 : " + winners);
    }

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int inputRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static String runRace(List<Car> carList, int repeatCount) {
        System.out.println("실행 결과");
        int winnerLocation = 0;
        while(repeatCount > 0) {
            for(final Car car : carList) {
                car.go();
                winnerLocation = Math.max(winnerLocation, car.getLocation());
                System.out.println(car.getName() + " : " + car.getLocationToString());
            }

            System.out.println();
            repeatCount--;
        }

        StringBuilder winners = new StringBuilder();
        for(final Car car : carList) {
            if(winnerLocation == car.getLocation()) {
                winners.append(car.getName());
                winners.append(",");
            }
        }

        return winners.substring(0, winners.length() - 1);
    }

    public static void inputValidate(String carNames, int repeatCount) {
        if(carNames.endsWith(",") || carNames.isEmpty() || repeatCount <= 0) {
            throw new IllegalArgumentException();
        }

        for (final String carName : carNames.split(",")) {
            if(carName.length() > 5 || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<Car> toCarList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
    }
}
package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> carNames = getCarNames();

        int tryCount = getTryCount();


        Map<String, Integer> cars = new HashMap<>();
        carNames.forEach(carName -> {
            cars.putIfAbsent(carName, 0);
        });

        int maxPosition = 0;
        for(int i = 0; i < tryCount; i++) {

            for(String car : cars.keySet()) {
                int randomValue = Randoms.pickNumberInRange(0, 9);

                if(randomValue >= 4) {
                    int prevPosition = cars.get(car);
                    cars.put(car, prevPosition + 1);
                    maxPosition = Math.max(maxPosition, prevPosition + 1);
                }
            }

            //현재상태 출력
            StringBuilder carStatus = new StringBuilder();
            cars.keySet().forEach(carName -> {
                carStatus.append(carName).append(" : ");
                for(int k = 0; k < cars.get(carName); k++) {
                    carStatus.append("-");
                }
                carStatus.append("\n");
            });
            System.out.println(carStatus);
        }

        int finalMaxPosition = maxPosition;
        List<String> winnerName = new ArrayList<>();
        cars.forEach((carname, position) -> {
            if(position == finalMaxPosition) {
                winnerName.add(carname);
            }
        });

        String winner = String.join(", ", winnerName);
        System.out.println("최종 우승자 : " + winner);
    }

    private static int getTryCount() {

        System.out.println("시도할 횟수는 몇 회인가요?");

        int tryCount = Integer.parseInt(Console.readLine());
        validateTryCount(tryCount);

        return tryCount;
    }

    private static void validateTryCount(int tryCount) {
        if(tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }

    private static List<String> getCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNameInput = Console.readLine();
        List<String> carNames = List.of(carNameInput.split(","));

        validateCarNames(carNames);

        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        carNames.forEach(car -> {
            validateNameLength(car);
        });
    }

    private static void validateNameLength(String car) {
        if(car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}

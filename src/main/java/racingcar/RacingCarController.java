package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarController {


    public void run() {
        RacingCarService racingCarService = new RacingCarService();

        Map<String, Integer> carInfo = getCarInfo();
        int attemptCount = getAttemptCount();

        for (int i = 0; i < attemptCount; i++) {
            racingCarService.process(carInfo);
            printCurrentStatus(carInfo);
        }

        printWinner(carInfo);
    }

    public Map<String, Integer> getCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] cars = carNames.split(",");
        Map<String, Integer> carInfo = new LinkedHashMap<>();
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            } else {
                carInfo.put(car, 0);
            }
        }
        return carInfo;
    }

    public int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = 0;
        try {
            attemptCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return attemptCount;
    }

    public void printCurrentStatus(Map<String, Integer> carInfo) {
        for (String carName : carInfo.keySet()) {
            System.out.println(carName + " : " + "-".repeat(carInfo.get(carName)));
        }
        System.out.println();
    }

    private void printWinner(Map<String, Integer> carInfo) {
        int maxCount = carInfo.values().stream().max(Integer::compareTo).get();
        List<String> winner = new ArrayList<>();
        for (String carName : carInfo.keySet()) {
            if (carInfo.get(carName) == maxCount) {
                winner.add(carName);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}

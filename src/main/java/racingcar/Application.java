package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car car = new Car();
        HashMap<String, Integer> carInfo = car.getCar();
        int tryNumber = car.getTryNumber();

        System.out.println("\n실행 결과");
        String carMovementStatus = "-";
        while (tryNumber > 0) {
            for (String i : carInfo.keySet()) {
                int randomNum = pickNumberInRange(0, 9);
                if (randomNum > 3) {
                    carInfo.replace(i, carInfo.get(i) + 1);
                }
                System.out.println(i + " : " + carMovementStatus.repeat(carInfo.get(i)));
            }
            System.out.println();
            tryNumber -= 1;
        }

        System.out.print("최종 우승자 : ");
        Optional<Integer> maxValue = carInfo.values().stream().max(Integer::compareTo);
        maxValue.ifPresent(value -> {
            String maxKeys = carInfo.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(value))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(", "));
            System.out.println(maxKeys);
        });

    }
}

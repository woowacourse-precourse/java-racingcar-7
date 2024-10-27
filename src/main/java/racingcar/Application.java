package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

//        1. 각 자동차별 0~9사이 무작위 값 구하기
//        2. 값이 4이상인 자동차를 체크하기
//        3. 실행 결과를 출력하기
//        - 1~3번을 입력한 시도 횟수만큼 반복
//        - 우승자를 출력하기
//        - 우승자가 여러 명일 경우 쉼표를 이용하여 구분하기

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        HashMap<String, Integer> carInfo = new HashMap<>();
        String[] carNames = readLine().split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력 해야합니다.");
            }
            carInfo.put(carName, 0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber = Integer.parseInt(readLine());
        if (tryNumber > 10){
            throw new IllegalArgumentException("시도하는 횟수가 너무 많습니다. 10회 이하로 설정해주세요");
        }

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

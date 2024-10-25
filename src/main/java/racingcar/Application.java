package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String RaceCarNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int RaceCount = Integer.parseInt(Console.readLine());


        String[] CarNames = RaceCarNames.split(",");
        HashMap<String, String> carRaceSituation = new HashMap<>();
        for (int i = 0; i < CarNames.length; i++) {
            if (CarNames[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            carRaceSituation.put(CarNames[i], ""); // 0 -> 시작지점
        }

        // indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
        System.out.println("실행 결과");
        for (int i = 0; i < RaceCount; i++) {
            for (int j = 0; j < CarNames.length; j++) {
                carRaceSituation.put(CarNames[j], carRaceSituation.get(CarNames[j]).concat(movement(CarNames[j]))); // 기본값에 movement 값 추가
                System.out.println(CarNames[j] + " : " + carRaceSituation.get(CarNames[j]));
            }
            System.out.println();
        }


        // indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
        System.out.print("최종 우승자 : ");
        int winners = 0;
        for (String key : carRaceSituation.keySet()) {
            if (carRaceSituation.get(key).equals(Collections.max(carRaceSituation.values()))) {
                winners++;
                separator(key, winners);
            }
        }

    }

    public static String movement(String CarNames) {
        String movement = "";
        if (Randoms.pickNumberInRange(0, 9) > 4) { // 4이상이면 - 추가 (전진)
            movement = movement.concat("-");
        }
        return movement;
    }

    public static void separator(String key, int winners) {

        if (winners > 1) {
            System.out.print(", " + key);
        } else System.out.print(key);
    }

}

package racingcar;

import racingcar.io.Input;

import java.util.*;

public class Application {
    public static final Input input = new Input();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runFullGame();
    }

    private static void runFullGame() {
        //입력 받기
        Map<String, Integer> carStepsMap = getCarMap();
        int round = getRound();

        //로직 실행
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            output.gameResult(startGame(carStepsMap));
        }

        //우승자 출력 받기
    }

    private static Map<String, Integer> getCarMap() {
        String[] splitCarName = input.carName().split(",");
        Map<String, Integer> carMap = new HashMap<>();
        for (String carName : splitCarName) {
            carMap.put(carName, 0);
        }
        return carMap;
    }

    private static int getRound() {
        int numRound;
        try {
            numRound = Integer.parseInt(input.gameRounds());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 이외의 값은 입력이 불가능합니다.");
        }
        if (numRound < 0) {
            throw new IllegalArgumentException("음수는 입력이 불가능합니다.");
        }
        return numRound;
    }

    private static Map<String,Integer> startGame(Map<String,Integer> carMap) {
        for (String key : carMap.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMap.put(key, carMap.get(key) + 1);
            }
        }

        return carMap;
    }

}

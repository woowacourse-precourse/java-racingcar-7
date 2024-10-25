package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.GameController;
import racingcar.view.io.Input;
import racingcar.view.io.Output;

import java.util.*;

public class Application {
    public static final Input input = new Input();
    public static final Output output = new Output();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.runFullGame();
//        runFullGame();
    }

    private static void runFullGame() {
        //입력 받기 (나중에 한 메서드로 묶을 것)
        Map<String, Integer> carStepsMap = getCarMap();
        int round = getRound();

        //로직 실행
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            output.gameResult(startGame(carStepsMap));
        }

        //우승자 출력 받기
        List<String> winnerList = getWinner(carStepsMap);
        output.winner(winnerList);
    }

    private static List<String> getWinner(Map<String, Integer> carMap) {
        List<String> winnerList = new ArrayList<>();
        int top = 0;
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) > top) {
                top = carMap.get(carName);
            }
        }
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) == top) {
                winnerList.add(carName);
            }
        }
        return winnerList;
    }

    private static Map<String, Integer> getCarMap() {
        String[] splitCarName = input.carName().split(",");
        Map<String, Integer> carMap = new HashMap<>();
        for (String carName : splitCarName) {
            if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            carMap.put(carName, 0);
        }
        return carMap;
    }

    private static int getRound() {
        int numRound;
        try {
            numRound = Integer.parseInt(input.gameRounds());
            System.out.println();
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

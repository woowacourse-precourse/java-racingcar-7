package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class CarRace {

    public static List<String> start(String cars, int moveAttempts){
        String[] carNames = cars.split(",");

        // 입력값에 포함될 수 있는 공백 제거
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }

        Map<String, String> carMap  = new HashMap<>();
        for (int i = 0; i < carNames.length; i++) {
            carMap.put(carNames[i], "");
        }

        for (int i = 0; i < moveAttempts; i++) {
            move(carMap, carNames);
            printRaceStaus(carMap);
        }

        return determineRaceWinners(carMap, carNames);
    }

    private static void move(Map<String, String> carMap, String[] carNames){
        for (int i = 0; i < carNames.length; i++) {
            if (canMove()) {
                carMap.put(carNames[i], carMap.get(carNames[i]) + "-");
            }
        }
    }

    private static boolean canMove(){
        return Randoms.pickNumberInRange(0, 9) > 4;
    }

    private static void printRaceStaus(Map<String, String> playerMap){
        System.out.println("실행 결과");
        for (String str : playerMap.keySet()) {
            System.out.println(str + " : " + playerMap.get(str));
        }
        System.out.println();
    }

    private static List<String> determineRaceWinners(Map<String, String> playerMap, String[] playerNames){
        Map<String, Integer> playerWithMoveCounts = new HashMap<>();
        for (int i = 0; i < playerMap.size(); i++) {
            playerWithMoveCounts.put(playerNames[i], playerMap.get(playerNames[i]).length());
        }

        Collection<Integer> values = playerWithMoveCounts.values();
        Integer max = Collections.max(values);

        List<String> winner = new ArrayList<>();
        for (int i = 0; i < playerMap.size(); i++) {
            if(playerMap.get(playerNames[i]).length() == max){
                winner.add(playerNames[i]);
            }
        }

        return winner;
    }

    public static void printFinalWinners(List<String> winner){
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i != winner.size() - 1){
                System.out.print(", ");
            }
        }
    }
}

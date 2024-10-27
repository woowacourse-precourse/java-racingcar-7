package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    private static List<Integer> carPositions;
    private static List<String> carNames;

    public static void main(String[] args) {
        try {
            carNames = getCarNames();
            System.out.println("입력한 자동차 이름: " + carNames);

            carPositions = new ArrayList<>(Arrays.asList(new Integer[carNames.size()]));
            for (int i = 0; i < carPositions.size(); i++) {
                carPositions.set(i, 0); // 초기 위치 0으로 설정
            }

            int tryCount = getTryCount();
            System.out.println("시도 횟수: " + tryCount);

            raceCars(tryCount);
            carPosition();
            raceWinner();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> getCarNames(){
        System.out.println("자동차 이름을 입력해주세요.");
        String inputCarName = Console.readLine();
        return validCarNames(inputCarName);
    }

    private static List<String> validCarNames(String userInput){
        List<String> carNames = Arrays.asList(userInput.split(","));

        for(String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하만 입력 가능합니다.");
            }
        }

        return carNames;
    }

    private static int getTryCount(){
        System.out.println("시도할 횟수를 입력해주세요.");
        String userInput = Console.readLine();
        int tryCount = Integer.parseInt(userInput);

        if(tryCount<=0){
            throw new IllegalArgumentException("1번 이상은 시도해야합니다.");
        }

        return tryCount;
    }

    private static void raceCars(int tryCount){
        for (int i = 0; i < tryCount; i++){
            System.out.println("차수 " + (i + 1) + " 진행 중...");
            for(int j = 0; j < carPositions.size(); j++){
                if(shouldMove(carNames.get(j))){
                    carPositions.set(j, carPositions.get(j) + 1);
                }
            }
            carPosition();
            System.out.println();
        }
    }

    private static void carPosition(){
        for(int i= 0; i < carPositions.size(); i++){
            System.out.print(carNames.get(i) + (i + 1) + ": " );
            System.out.println("-".repeat(carPositions.get(i)));
        }
    }

    private static boolean shouldMove(String carName){
        int randomValue = Randoms.pickNumberInRange(0,9);
        boolean move = randomValue >= 4;
        if (move) {
            System.out.println(carName + "자동차가 전진합니다.");
        } else {
            System.out.println(carName + "자동차가 전진하지 않습니다.");
        }
        return move;
    }

    private static void raceWinner(){
        int maxPosition = carPositions.stream().max(Integer::compareTo).orElse(0);
        List <String> winners = new ArrayList<>();

        for(int i = 0; i < carPositions.size(); i++){
            if(carPositions.get(i) == maxPosition){
                winners.add(carNames.get(i));
            }
        }

        System.out.println("우승자는" + String.join(",", winners) + "입니다.");
    }

}

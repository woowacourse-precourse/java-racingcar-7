package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<Integer> carPositions;

    public static void main(String[] args) {
        try {
            List<String> carNames = getCarNames();
            System.out.println("입력한 자동차 이름: " + carNames);

            carPositions = new ArrayList<>(Arrays.asList(new Integer[carNames.size()]));
            for (int i = 0; i < carPositions.size(); i++) {
                carPositions.set(i, 0); // 초기 위치 0으로 설정
            }

            int tryCount = getTryCount();
            System.out.println("시도 횟수: " + tryCount);

            raceCars(tryCount);
            carPosition();
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
        }
    }

    private static void carPosition(){
        for(int i= 0; i < carPositions.size(); i++){
            System.out.println("자동차 " + (i + 1) + ": " );
            System.out.println("-".repeat(carPositions.get(i)));
        }
    }

}

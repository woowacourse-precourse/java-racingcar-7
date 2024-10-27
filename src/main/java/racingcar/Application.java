package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carList = checkInput(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(Console.readLine());
        checkNum(num);

        System.out.println("\n실행 결과");
        runRacing(num, carList);
    }

    static public String[] checkInput(String input) throws IllegalArgumentException {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여할 자동차를 입력해주세요. 예) pobi,woni,jun");
        }

        String[] carList = input.split(",");
        if(carList.length < 1) {
            throw new IllegalArgumentException("경주에 참여할 자동차를 입력해주세요. 예) pobi,woni,jun");
        }

        for(String car : carList) {
            if(car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요. 예) pobi,woni,jun");
            }
        }
        return carList;
    }

    static public void checkNum(int num) throws IllegalArgumentException{
        if(num <= 0) {
            throw new IllegalArgumentException("1 이상 시도할 횟수를 입력해주세요.");
        }
    }

    static public void runRacing(int num, String[] carList) {
        int[] carIndex = new int[carList.length];

        for (int i = 0; i < num; i++) {
            for (int k = 0; k < carList.length; k++) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                if (randomValue >= 4) {
                    carIndex[k]++;
                }
            }

            for (int j = 0; j < carList.length; j++) {
                System.out.println(carList[j] + " : " + "-".repeat(carIndex[j]));
            }
            System.out.println();
        }
        maxDistance(carIndex, carList);
    }

    static public void maxDistance(int[] carIndex, String[] carList) {
        int maxDistance = 0;
        for (int distance : carIndex) {
            maxDistance = Math.max(maxDistance, distance);
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carIndex.length; i++) {
            if (carIndex[i] == maxDistance) {
                winners.add(carList[i]);
            }
        }
        printWinner(winners);
    }

    static public void printWinner(List<String> winners) {
        System.out.println("최종 우승자  :  " + String.join(", ", winners));
    }
}

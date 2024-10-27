package racingcar;

import java.util.*;

public class Application {
    static Map<String, Integer> carList = new LinkedHashMap<>(); //name, distance
    static int turn = 0;

    public static void main(String[] args) {
        init();
        moveCar();
        getWinner();
    }
    static void init() { //자동차 이름 n개, 턴 수 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            String input1 = camp.nextstep.edu.missionutils.Console.readLine();
            String[] nameArray = input1.split(",");
            checkName(nameArray);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            String input2 = camp.nextstep.edu.missionutils.Console.readLine();
            turn = Integer.parseInt(input2);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    static void checkName(String[] nameArray) {
        for(int i = 0; i < nameArray.length; i++) {
            if(nameArray[i].length() > 5) { throw new IllegalArgumentException(); }
            else { carList.put(nameArray[i], 0); }
        }
    }
    static void moveCar() {
        for(int t = 0 ; t < turn; t++) {
            Iterator<String> carNames = carList.keySet().iterator();

            while(carNames.hasNext()) {
                String name = carNames.next();
                System.out.print(name + " : ");

                int requireMove = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
                carList.put(String.valueOf(name), carList.get(String.valueOf(name)) + requireMove);

                int currentMove = 0;
                displayMove(currentMove, requireMove);

                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
    static void displayMove(int currentMove, int requireMove) {
        while(currentMove < requireMove) {
            System.out.print("-");
            currentMove++;
        }
    }
    static void getWinner() {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Map.Entry<String, Integer> entry : carList.entrySet()) {
            if (entry.getValue() > maxDistance) {
                maxDistance = entry.getValue();
            }
        }

        for (Map.Entry<String, Integer> entry : carList.entrySet()) {
            if (entry.getValue() == maxDistance) {
                winners.add(entry.getKey());
            }
        }

        System.out.print("최종 우승자 : " + String.join(", ",winners));
    }
}

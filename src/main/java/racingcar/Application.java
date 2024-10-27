package racingcar;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    static Map<String, Integer> carList = new LinkedHashMap<>(); //name, distance
    static int turn = 0;

    public static void main(String[] args) {
        init();
        moveCar();

    }
    static void init() { //자동차 이름 n개, 턴 수 입력받기
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        String[] nameArray = input.split(",");
        for(int i = 0; i < nameArray.length; i++) {
            if(nameArray[i].length() > 5) { throw new IllegalArgumentException(); }
            else { carList.put(nameArray[i], 0); }
        }

        input = camp.nextstep.edu.missionutils.Console.readLine();
        turn = Integer.parseInt(input);
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
}

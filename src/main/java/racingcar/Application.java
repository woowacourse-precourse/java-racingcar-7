package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    static List<String> carList;
    static int turn = 0;

    public static void main(String[] args) {
        init();
        moveCar();

    }
    static void init() { //자동차 이름 n개, 턴 수 입력받기
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        carList = Arrays.asList(input.split(","));
        input = camp.nextstep.edu.missionutils.Console.readLine();
        turn = Integer.parseInt(input);

        for(int i = 0; i < carList.size(); i++) {
            if(carList.get(i).length() > 5) { throw new IllegalArgumentException(); }
        }
    }
    static void moveCar() {
        for(int t = 0 ; t < turn; t++) {
            for(int i = 0; i < carList.size(); i++) {
                System.out.print(carList.get(i) + " : ");
                int requireMove = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
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

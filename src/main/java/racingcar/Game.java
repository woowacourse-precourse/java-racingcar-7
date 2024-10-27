package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    private static Input input;

    public void init() {
        input = new Input();
        System.out.println("실행 결과");
        gameStart(input.cnt);
        winner();
    }

    private void winner() {
        List<String> names = new ArrayList<>(input.cars.keySet());
        names.sort((o1, o2) -> input.cars.get(o2) - input.cars.get(o1));
        int max = input.cars.get(names.get(0));
        System.out.print("최종 우승자 : ");
        for(String name : names) {
            if(input.cars.get(name) == max)
                System.out.print(name + ", ");
            else
                break;
        }
    }

    private void gameStart(int cnt) {
        for(int i=0; i<cnt; i++) {
            move();
            printGame();
        }

    }

    private void move() {
        for(String name: input.cars.keySet()) {
            int num = Randoms.pickNumberInRange(0, 9);
            if(num >= 4)
                input.cars.put(name, input.cars.get(name) + 1);
        }
    }

    private void printGame() {
        for(String name: input.cars.keySet()) {
            System.out.print(name + ": ");
            System.out.println("-".repeat(input.cars.get(name)));
        }
        System.out.println();
    }
}

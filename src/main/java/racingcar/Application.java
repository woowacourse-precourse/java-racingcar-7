package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class RacingCar {
    private String name;
    private int moves;

    public RacingCar(String name) {
        this.name = name;
        this.moves = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoves() {
        return moves;
    }

    public void addMoves() {
        moves++;
    }

    public boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}

public class Application {
    public static void main(String[] args) {
        getNameOfCars();
    }

    private static String[] getNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputSequence = Console.readLine();
        
        String[] carNames = inputSequence.split(",");
        return carNames;
    }
    
}

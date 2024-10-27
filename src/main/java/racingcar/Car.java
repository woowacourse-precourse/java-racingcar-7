package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int currentPosition;

    public Car(String _name, int _currentPosition) {
        name = _name;
        currentPosition = _currentPosition;
    }

    public void moveForward() {
        int random = Randoms.pickNumberInRange(0, 9);

        if (checkMoveForward(random)) {
            currentPosition++;
        }
    }

    private boolean checkMoveForward(int random) {
        if(random < 0 || random > 9)
            return false;

        return random >= 4;
    }

    public void printPosition() {
        System.out.printf("%s : ", name);
        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

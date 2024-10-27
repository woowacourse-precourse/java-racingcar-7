package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MoveDecider {


    public static int pickRandomNum (){
        //System.out.println(randomNum);
        return pickNumberInRange(0, 9);
    }

    public static String isMovable(int randomNum) {

        String moved = "";
        if (randomNum > 3) {
            moved = moved + "-";
        }
        //System.out.println(moved);
        return moved;
    }

    public static String move() {
        StringBuilder result = new StringBuilder();

        try {
            String[] carNames = InputView.inputCar();
            int attemptCount = InputView.inputCount();

            for (String name : carNames) {
                String movementResult = generateMovementResult (name, attemptCount);
                System.out.println(movementResult);
                result.append(movementResult).append("\n");
            }

        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            return e.getMessage();

        }

        return result.toString();
    }

    private static String generateMovementResult (String carName, int attemptCount) {
        StringBuilder movement = new StringBuilder();

        for (int i = 0; i < attemptCount; i++) {
            int randomNum = MoveDecider.pickRandomNum();
            String moved = MoveDecider.isMovable(randomNum);
            movement.append(moved);
        }

        return carName + " : " + movement;
    }

}
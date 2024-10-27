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

            String[] movements = new String[carNames.length];
            for (int i = 0; i < carNames.length; i++) {
                movements[i] = carNames[i] + " : ";

            }

            for (int attempt = 0; attempt < attemptCount; attempt++) {
                generateMovementResult(movements);
                System.out.println();
            }

            for (String movement : movements) {
                result.append(movement).append("\n");
            }


        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            return e.getMessage();

        }

        return result.toString();
    }

    private static void generateMovementResult (String[] movements) {
        for (int i = 0; i < movements.length; i++) {
            int randomNum = MoveDecider.pickRandomNum();
            String moved = MoveDecider.isMovable(randomNum);
            movements[i] += moved;
            System.out.println(movements[i]);

        }
    }

}
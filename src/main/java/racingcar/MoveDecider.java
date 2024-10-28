package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MoveDecider {


    public static int pickRandomNum (){
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

    public static String move(String[] carNames, int attemptCount) {
        StringBuilder result = new StringBuilder();
        String[] movements = new String[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            movements[i] = carNames[i] + " : ";
        }

        for (int attempt = 0; attempt < attemptCount; attempt++) {
            generateMovementResult(movements);
        }

        for (String movement : movements) {
            result.append(movement).append("\n");
        }

        return result.toString();
    }

    private static void generateMovementResult (String[] movements) {
        for (int i = 0; i < movements.length; i++) {
            int randomNum = MoveDecider.pickRandomNum();
            String moved = MoveDecider.isMovable(randomNum);
            movements[i] += moved;
        }

        for (String movement : movements) {
            System.out.println(movement);
        }
        System.out.println();
    }

}
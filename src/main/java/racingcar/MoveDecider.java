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

            for (String name : carNames) {
                int randomNum = MoveDecider.pickRandomNum();
                String moved = MoveDecider.isMovable(randomNum);
                String movement = name + " : " + moved;
                System.out.println(movement);
                result.append(movement).append("\n");
            }

        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            return e.getMessage();

        }

        return result.toString();
    }

}
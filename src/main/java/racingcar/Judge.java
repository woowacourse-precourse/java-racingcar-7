package racingcar;

import java.util.ArrayList;

public class Judge {
    private static ArrayList<String> winnerList = new ArrayList<>();
    private static int maxMoveLength;


    ArrayList<String> judgeWinner (ArrayList<Car> carList){
        for (Car car : carList) {
            if (car.getMoveList().size() == maxMoveLength) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public static ArrayList<String> getWinnerList() {
        return winnerList;
    }
}

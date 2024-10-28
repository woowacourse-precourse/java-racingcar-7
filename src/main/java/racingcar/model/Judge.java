package racingcar.model;

import java.util.ArrayList;

public class Judge {
    private static ArrayList<String> winnerList = new ArrayList<>();
    private static int maxMoveLength;

    public int judgeMaxLength(ArrayList<Car> carList){
        for (Car car : carList) {
            if (car.getMoveList().size() > maxMoveLength) {
                maxMoveLength = car.getMoveList().size();
            }
        }
        return maxMoveLength;
    }

    public ArrayList<String> judgeWinner(ArrayList<Car> carList){
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

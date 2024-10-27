package racingcar;

import java.util.ArrayList;

public class Judge {
    private static ArrayList<String> winnerList = new ArrayList<>();

    ArrayList<String> judgeWinner (ArrayList<Car> carList){
        int moveLength = carList.get(0).getMoveList().size();
        for (Car car : carList) {
            if(car.getMoveList().size() >= moveLength){
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public static ArrayList<String> getWinnerList() {
        return winnerList;
    }
}

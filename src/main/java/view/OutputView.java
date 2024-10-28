package view;

import java.util.List;
import model.Car;
import model.CarList;

public class OutputView {

    public OutputView() {
    }

    public void displayCarsStatus(CarList carList) {
        for (Car car : carList.getCars()) {
            StringBuilder carInfo = new StringBuilder();
            carInfo.append(car.getName());
            carInfo.append(" : ");

            int distance = car.getDistance();
            carInfo.append(setDistanceInfo(distance));

            System.out.println(carInfo);
        }
        System.out.println();
    }

    private String setDistanceInfo(int distance) {
        return "-".repeat(Math.max(0, distance));
    }

    public void displayWinnerList(List<String> winnerList) {
        StringBuilder winnerInfo = new StringBuilder();
        winnerInfo.append("최종 우승자 : ");

        for (int i = 0; i < winnerList.size() - 1; i++) {
            winnerInfo.append(winnerList.get(i));
            winnerInfo.append(",");
        }
        winnerInfo.append(winnerList.getLast());
        System.out.println(winnerInfo);
    }
}

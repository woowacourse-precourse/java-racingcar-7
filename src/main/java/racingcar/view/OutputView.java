package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printInterimResult(List<Car> carList) {
        //중간 결과 출력
        for (Car car : carList) {
            System.out.println(interimFormat(car));
        }
        System.out.print("\n");
    }

    public void printResult(List<Car> carList) {
        int maxMileage = 0;
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (maxMileage < carList.get(i).getMileage()) {
                //max 갱신
                maxMileage = carList.get(i).getMileage();
                //기존 max clear
                result.clear();
                //새로운 max 객체 추가
                result.add(carList.get(i));
            } else if (maxMileage == carList.get(i).getMileage()) {
                result.add(carList.get(i));
            }
        }
        //최종 결과 출력
        System.out.print("최종 우승자 : ");
        for (int i = 0; i<result.size()-1; i++) {
            System.out.print(result.get(i).getName()+", ");
        }
        System.out.println(result.getLast().getName());
    }

    private String interimFormat(Car car) {

        return car.getName() +
                " : " +
                "-".repeat(Math.max(0, car.getMileage()));
    }
}

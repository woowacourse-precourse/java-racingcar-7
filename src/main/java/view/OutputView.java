package view;

import java.util.List;
import model.Car;

public class OutputView {

    private final static char RACE_STEP = '-';

    public void showRaceStart() {
        System.out.println("실행 결과");
    }

    // TODO: MVC를 지키는가?
    //  view는 controller로 부터 cars를 받고 있음
    //  car객체는 model로 부터 받고 있음
    public void showRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            showCarName(car);
            showCarStep(car);
        }
        System.out.println();
    }

    // TODO: 마지막 콤마 제거
    public void showWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (Car car : winners) {
            System.out.print(car.getName() + ", ");
        }
    }

    // TODO: 출력을 잘 하고 있는가?
    //  java에서 제공하는 API가 있는지 등 더 알아보기
    private void showCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private void showCarStep(Car car) {
        for (int i = 0; i < car.getStep(); i++) {
            System.out.print(RACE_STEP);
        }
        System.out.println();
    }

}

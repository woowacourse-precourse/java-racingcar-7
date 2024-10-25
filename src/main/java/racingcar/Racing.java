package racingcar;

import java.util.List;

public class Racing {

    public void race(){
        List<Car> carList = Cars.getCarList();
        int tryNumber = User.getTryNumber();

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            printPosition(carList);
            System.out.println();
        }

        System.out.println();
        System.out.println("최종 우승자 : " + Winner.printWinner(carList));
    }

    private static void printPosition(List<Car> carList){
        for (Car car : carList) {
            car.move();
            String output = "-";
            String positionOutput = output.repeat(car.getPosition());
            System.out.println(car.getCarName() + " : " + positionOutput);
        }
    }
}

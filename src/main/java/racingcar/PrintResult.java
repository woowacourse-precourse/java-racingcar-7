package racingcar;

public class PrintResult {

    public void printCar(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 1; i <= car.getForwardCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

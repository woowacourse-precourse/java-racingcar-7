package racingcar;

public class OutputView {
    public static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRaceProcess(Cars cars) {
        for (Car car : cars.getCars()) {
            printStatus(car);
        }
        System.out.println();
    }

    private static void printStatus(Car car) {
        String carName = car.getCarName();
        String distance = "-".repeat(car.getDistance());

        System.out.printf("%s : %s\n", carName, distance);
    }

}
package racingcar;

public class Output {
    public static void printWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public static void printDistance(Car car) {
        System.out.println(car.getName() + " : " + car.getDist());
    }

    public static void printRoundResult(Car[] cars) {
        for (Car car : cars) {
            printDistance(car);
        }
    }
}

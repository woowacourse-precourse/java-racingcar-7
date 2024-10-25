package racingcar;

public class Output {
    public static void printWinner() {
        System.out.println("최종 우승자 : ");
    }

    public static void printDistance(Car car) {
        System.out.println(car.getName() + " : " + car.getDist());
    }
}

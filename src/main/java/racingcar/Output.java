package racingcar;

public class Output {
    public static void printExecuteResult() {
        System.out.println("실행 결과");
    }
    public static void printCarPosition(Car car){
        String position = "";
        for (int i = 0; i < car.getPosition(); i++) {
            position = position.concat("-");
        }
        System.out.println(car.getName() + " : " + position);
    }

    public static void printWinner() {

    }
    public static void printWinners() {

    }
}

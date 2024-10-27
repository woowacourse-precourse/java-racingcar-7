package racingcar;

public class Application {
    public static void main(String[] args) {
        Stadium stadium = new Stadium();
        stadium.start();

        System.out.printf("최종 우승자 : %s", String.join(", ", stadium.getWinners()));
    }
}

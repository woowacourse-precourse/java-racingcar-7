package racingcar;

public class RacingCar {
    private final String[] carList;
    private final int number;
    private final int[] winnerCount;
    private final Racing racing;
    private final Winner winner;

    public RacingCar(String[] carList, int number) {
        this.carList = carList;
        this.number = number;
        this.winnerCount = new int[carList.length];
        this.racing = new Racing();
        this.winner = new Winner();
    }

    public void start() {
        for (int i = 0; i < number; i++) {
            int[] racingResult = racing.racing(carList, number);
            winner.checkWinner(racingResult, winnerCount);
        }
        System.out.print("최종 우승자 : ");
        winner.printFinalWinner(carList, winnerCount);
    }
}

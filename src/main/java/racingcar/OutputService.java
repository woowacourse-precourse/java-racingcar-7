package racingcar;

public class OutputService {

    private final RacingCarService racingCarService;

    public OutputService(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run(String carList, int count) {
        RacingCarList racingCarList = new RacingCarList(carList);

        for (int i = 1; i <= count; i++) {
            System.out.println(i + "회차 결과");
            printOutRoundByRoundResults(racingCarList);
        }
        System.out.println(racingCarService.getWinnerRacingCar(racingCarList));
    }

    private void printOutRoundByRoundResults(RacingCarList racingCarList) {
        for (RacingCar racingCar : racingCarList.getRacingCarList()) {
            int stopOrMoveNumber = racingCarService.randomNumberCreate();
            racingCarService.increasingCurrentMovingPoint(racingCar, stopOrMoveNumber);
            System.out.println(racingCar.getRaceOutcomeForCarInRound(racingCar));
        }
        System.out.println();
    }
}

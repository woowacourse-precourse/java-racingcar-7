package racingcar;

public class Application {
    public static void main(String[] args) {
        ErrorVerificationService errorVerificationService = new ErrorVerificationService();
        OutputService outputService = new OutputService(new RacingCarService());

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = camp.nextstep.edu.missionutils.Console.readLine();

        errorVerificationService.checkInputValidity(carList, count);
        outputService.run(carList, Integer.parseInt(count));
    }
}

package racingcar;

public class Application {
    public static void main(String[] args) {
        OutputService outputService = new OutputService(new RacingCarService());

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = camp.nextstep.edu.missionutils.Console.readLine();

        countNumberCheck(count);
        outputService.run(carList, Integer.parseInt(count));
    }

    public static void countNumberCheck(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }

}

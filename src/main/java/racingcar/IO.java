package racingcar;

public class IO {

    public String[] inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarData = camp.nextstep.edu.missionutils.Console.readLine();
        String[] carNames = inputCarData.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }

    public int inputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputMoveCnt = camp.nextstep.edu.missionutils.Console.readLine();

        try {
            int cnt = Integer.parseInt(inputMoveCnt);

            if (cnt <= 0) {
                throw new IllegalArgumentException();
            }

            return cnt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

package view;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 쉼표로 구분해서 입력");
        return readLine();
    }

    public static int getAttempts() {
        System.out.println("시도할 횟수 입력");
        String input = readLine();
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.", e);
        }
    }
}

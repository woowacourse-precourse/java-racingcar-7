package racingcar;

public class Application {
    public static void main(String[] args) {


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarInput = camp.nextstep.edu.missionutils.Console.readLine();
        public static String[] carList(String input){
            final String[] nameList = input.trim().split("\\s+,\\s+");
            for (String i : nameList) {
                if (i == null || i.isEmpty()) {
                    throw new IllegalArgumentException("자동차 이름 중 공백이 존재합니다.");
                }

                if (i.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름의 길이는 5를 넘길 수 없습니다.");
                }
            }
            return nameList;
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String racingNum = camp.nextstep.edu.missionutils.Console.readLine();
        public static int numValid(String racingNum){
            try {
                int racingNumber = Integer.parseInt(racingNum);
                if (racingNumber <= 0) {
                    throw new IllegalArgumentException("시도할 횟수는 0보다 큰 정수이어야 합니다.");
                }
                return racingNumber;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("시도할 횟수는 정수로 입력되어야 합니다.");
            }
        }

    }
}

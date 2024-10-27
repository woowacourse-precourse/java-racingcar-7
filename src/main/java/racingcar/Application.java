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


//### 2. 이동 횟수 입력 구현
//            - 사용자는 몇 번의 이동을 할 것인지 입력
//            - 입력 메서드와 예외처리는 1번과 동일

    }
}

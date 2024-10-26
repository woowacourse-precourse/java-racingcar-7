package racingcar;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] carNames = scanner.nextLine().split(",");
            checkCarNames(carNames);

            System.out.println("시도할 횟수는 몇 회인가요?");
            int raceRounds = scanner.nextInt();
            if(raceRounds < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }

        } catch (IllegalArgumentException e) { // 잘못된 값 예외 처리
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void checkCarNames(String[] carNames){
        for(int i=0; i<carNames.length; i++){
            String carName = carNames[i].trim();
            if(carName.length() > 5 || carName.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }

    }
}


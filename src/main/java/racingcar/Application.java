package racingcar;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();
        String [] cars = nameInput.split(",");

        // 각 자동차 이름이 5자 이하인지 검증
        ValidateCarNames(cars);
    }


    private static void ValidateCarNames(String [] carNames){
        for(String carName : carNames){
            carName = carName.trim(); // 공백 제거

            if (carName.length() > 5 || carName.isEmpty()){
                throw new IllegalArgumentException();
            }
        }
    }
}



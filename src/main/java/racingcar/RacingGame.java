package racingcar;

public class RacingGame {
    public static Racingcar[] createRacingcars(){   // 입력받은 레이싱카의 이름으로 n대의 레이싱카 초기화
        String[] carsName = InputHandler.InputCarsName(); 
        Validator.validateCarNames(carsName);

        Racingcar[] racingcars = new Racingcar[carsName.length];
        for (int i = 0; i < racingcars.length; i++) {
            racingcars[i] = new Racingcar(carsName[i]);
        }

        return racingcars;
    }
}

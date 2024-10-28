package racingcar.exception;

public class TryNumberException {

    public void tryNumberException(int tryNumber){
        if(tryNumber < 0){
            System.out.println("음수 입력은 불가합니다.");
            throw new IllegalArgumentException();
        }else if(tryNumber == 0){
            System.out.println("시도하지 않으면 게임 진행이 불가합니다.");
            throw new IllegalArgumentException();
        }
    }
}

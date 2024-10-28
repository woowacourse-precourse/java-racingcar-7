package racingcar.exception;

public class TryNumberException {

    private final String TryNumberNegativeNotAllowed= "음수 입력은 불가합니다.";
    private final String TryNumberZeroNotAllowed="시도하지 않으면 게임 진행이 불가합니다.";

    public void tryNumberException(int tryNumber){
        if(tryNumber < 0){
            System.out.println(TryNumberNegativeNotAllowed);
            throw new IllegalArgumentException();
        }else if(tryNumber == 0){
            System.out.println(TryNumberZeroNotAllowed);
            throw new IllegalArgumentException();
        }
    }
}

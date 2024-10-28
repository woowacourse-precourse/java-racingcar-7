package racingcar.Domain;

public class Round {
    private final int count;
    private int remainCount; // 가변 변수. 안전성을 고려해 실제로는 이것을 사용

    public Round(String count) {
        this.count = convertRoundCount(count);
        this.remainCount = convertRoundCount(count);
        validateCountRange();
    }

    private void validateCountRange(){
        if(remainCount < 1){
            throw new IllegalArgumentException
                    ("라운드 수가 적절하지 않습니다.");
        }
    }

    private int convertRoundCount(String count){
        try{
            return Integer.parseInt(count);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }
    public void decreaseCount(){
        remainCount--;
    }
    public boolean isRemain(){
        return remainCount > 0;
    }
}

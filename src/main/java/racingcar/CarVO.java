package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarVO {

    private String carName;
    private int position;

    public CarVO(String inputValue){
        if (inputValue.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하로 입력해주세요.확인 후 다시 입력해주세요.");
        }
        carName=inputValue;
        position=0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void runing(){
        int randomPosition = pickNumberInRange(0,9);
        if (randomPosition >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        String resultText = carName + " : ";
        if (position > 0) {
            for (int i = 0; i < position; i++) {
                resultText += "-";
            }
        }
        return resultText;
    }
}

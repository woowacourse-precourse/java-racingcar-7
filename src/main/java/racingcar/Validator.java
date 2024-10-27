package racingcar;

public class Validator {
    static public String[] checkInput(String input) throws IllegalArgumentException {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여할 자동차를 입력해주세요. 예) pobi,woni,jun");
        }

        String[] carList = input.split(",");
        if(carList.length < 1) {
            throw new IllegalArgumentException("경주에 참여할 자동차를 입력해주세요. 예) pobi,woni,jun");
        }

        for(String car : carList) {
            if(car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요. 예) pobi,woni,jun");
            }
        }
        return carList;
    }

    static public void checkNum(int num) throws IllegalArgumentException{
        if(num <= 0) {
            throw new IllegalArgumentException("1 이상 시도할 횟수를 입력해주세요.");
        }
    }
}

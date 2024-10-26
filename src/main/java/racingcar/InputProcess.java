package racingcar;

public class InputProcess {
    public String[] splitName(String carNames) {
        return carNames.split(",");
    }

    public void checkName(String[] carList) {
        for (int i = 0; i < carList.length; i++) {
            if(carList[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}

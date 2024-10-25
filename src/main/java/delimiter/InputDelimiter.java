package delimiter;

import java.util.ArrayList;
import java.util.List;

public class InputDelimiter {
    public List<String> delimiterWithComma(String inputCarName) {
        List<String> delimiterWithCommaList = new ArrayList<>();

        for (String carName : inputCarName.split(",")) {
            delimiterWithCommaList.add(carName);
        }

        isCorrectCarName(delimiterWithCommaList);
        return delimiterWithCommaList;
    }

    private void isCorrectCarName(List<String> delimiterWithCommaList) {
        delimiterWithCommaList.forEach(i -> {
            if (i.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 적어주세요.");
            }
        });
    }
}

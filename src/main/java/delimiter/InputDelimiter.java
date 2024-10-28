package delimiter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputDelimiter {
    private static final String CAR_NAME_DELIMITER = ",";
    public List<String> activateDelimiterWithComma(String inputCarName) {
        List<String> delimiterWithCommaList = new ArrayList<>();

        for (String carName : inputCarName.split(CAR_NAME_DELIMITER)) {
            String refinedCarName = refineCarName(carName);

            isCorrectCarName(refinedCarName);

            delimiterWithCommaList.add(refinedCarName);
        }

        isDuplicateCarName(delimiterWithCommaList);

        return delimiterWithCommaList;
    }

    private String refineCarName(String carName) {
        String refinedCarName = carName.trim();

        return refinedCarName;
    }

    private void isCorrectCarName(String refinedCarName) {
        if (refinedCarName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 적어주세요.");
        }
        if (refinedCarName.length() == 0) {
            throw new IllegalArgumentException("자동차 이름으로 공백이 올 수 없습니다. 최소 한문자 이상 적어주세요.");
        }
    }

    private void isDuplicateCarName(List<String> delimiterWithCommaList) {
        int sizeWithDeleteDuplicateInList = deleteDuplicateStringInList(delimiterWithCommaList);

        if (sizeWithDeleteDuplicateInList != delimiterWithCommaList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다. 중복되지 않는 자동차 이름을 입력해주세요.");
        }
    }

    private int deleteDuplicateStringInList(List<String> delimiterWithCommaList) {
        Set<String> delimiterWithCommaListToSet = new HashSet<>(delimiterWithCommaList);

        return delimiterWithCommaListToSet.size();
    }
}

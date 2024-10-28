package delimiter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputDelimiter {
    public List<String> activateDelimiterWithComma(String inputCarName) {
        List<String> delimiterWithCommaList = new ArrayList<>();

        for (String carName : inputCarName.split(",")) {
            delimiterWithCommaList.add(carName);
        }

        isCorrectCarName(delimiterWithCommaList);
        isDuplicateCarName(delimiterWithCommaList);

        return delimiterWithCommaList;
    }

    private void isCorrectCarName(List<String> delimiterWithCommaList) {
        delimiterWithCommaList.forEach(i -> {
            if (i.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 적어주세요.");
            }
            if (i.length() == 0) {
                throw new IllegalArgumentException("comma(\",\")는 자동차 이름 구분자입니다. 자동차 이름 사이에만 하나의 comma가 올 수 있도록 해주세요.");
            }
        });
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

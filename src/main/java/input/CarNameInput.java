package input;

import camp.nextstep.edu.missionutils.Console;
import delimiter.InputDelimiter;
import java.util.List;

public class CarNameInput {
    InputDelimiter inputDelimiter = new InputDelimiter();
    InformationInput informationInput = new InformationInput();

    public List<String> inputHandler() {
        String inputCarNameLump = makeInputCarName();

        return inputDelimiter.activateDelimiterWithComma(inputCarNameLump);
    }

    private String makeInputCarName() {
        informationInput.printInformationInputOfCarName();
        // 원시값 포장 필요
        String carName = Console.readLine();

        isInputCarName(carName);

        return carName;
    }

    private void isInputCarName(String carName) {
        if (carName.length() == 0 || carName.equals(null)) {
            throw new IllegalArgumentException("자동차 이름으로 빈 문자열은 올 수 없습니다. 자동차 이름을 입력해주세요.");
        }
    }
}

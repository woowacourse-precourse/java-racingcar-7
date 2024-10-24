package racingcar;

import java.util.Arrays;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Reader implements ReaderInterface{

    @Override
    public List<String> getNameInput() {
        String nameInput = readLine();
        try {
            List<String> names = Arrays.stream(nameInput.split(",")).toList();

            if (validNameInput(names)) {
                return names;
            }
            else{
                throw new IllegalArgumentException("invalid name");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("can't parse names");
        }

    }

    private boolean validNameInput(List<String> names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH){
                return false;
            }
        }
        return true;
    }

    @Override
    public int getTryInput() {
        String tryInput = readLine();
        try {
            int raps = Integer.parseInt(tryInput);
            if (validTryInput(raps)) {
                return raps;
            } else {
                throw new IllegalArgumentException("must try more than once");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("not an positive integer input");
        }
    }

    private boolean validTryInput(int raps) {
        return raps >= MIN_RAPS;
    }
}

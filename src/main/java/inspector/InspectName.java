package inspector;

import static utils.LetterCounter.letterCounter;
import constant.Constants;
import java.text.BreakIterator;

public class InspectName {
    public void inspecting(String[] targetGroup){
        for (String content : targetGroup) {
            detectNameLengthLimit(content);
        }
    }

    private void detectNameLengthLimit(String name){
        if(letterCounter(name) > Constants.RACING_CAR_NAME_LIMIT){
            throw new IllegalArgumentException("글자 수가 넘음");
        }
    }

}
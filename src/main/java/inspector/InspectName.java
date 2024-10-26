package inspector;

import static exceptor.ExceptionHandler.detectDuplicatedName;
import static exceptor.ExceptionHandler.detectNameLengthLimit;
import static utils.LetterCounter.letterCounter;
import constant.Constants;
import java.text.BreakIterator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InspectName {
    public void inspecting(String[] group){
        for (String content : group) {
            detectNameLengthLimit(content);
            detectDuplicatedName(group);
        }
    }

}
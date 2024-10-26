package inspector;

import static exceptor.ExceptionHandler.detectBlankName;
import static exceptor.ExceptionHandler.detectDuplicatedName;
import static exceptor.ExceptionHandler.detectNameLengthLimit;

public class InspectName {
    public void inspecting(String[] group){
        detectDuplicatedName(group);
        for (String content : group) {
            detectNameLengthLimit(content);
            detectBlankName(content);
        }
    }

}
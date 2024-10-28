package inspector;

import validator.Validator;
import java.util.ArrayList;

public class InspectName {

    public void inspectingInvalidName(ArrayList<String> group){
        Validator.validateDuplicatedName(group);

        for (String content : group) {
            Validator.validateNameLengthLimit(content);
            Validator.validateBlankName(content);
        }

    }
}
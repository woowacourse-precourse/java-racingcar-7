package inspector;

import exceptor.Validator;
import java.util.ArrayList;

public class InspectName {

    public void inspecting(ArrayList<String> group){
        Validator.validateDuplicatedName(group);

        for (String content : group) {
            Validator.validateNameLengthLimit(content);
            Validator.validateBlankName(content);
        }

    }

}
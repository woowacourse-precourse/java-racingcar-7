package inspector;

import exceptor.Validator;

public class InspectName {

    public void inspecting(String[] group){
        Validator.validateDuplicatedName(group);

        for (String content : group) {
            Validator.validateNameLengthLimit(content);
            Validator.validateBlankName(content);
        }

    }

}
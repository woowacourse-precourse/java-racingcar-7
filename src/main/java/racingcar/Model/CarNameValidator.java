package racingcar.Model;

import java.util.ArrayList;
import racingcar.Constants;
import racingcar.Utils;

public class CarNameValidator {
    private final String nameString;
    public final ArrayList<String> names;

    public CarNameValidator(String nameString){
        this.nameString = nameString;
        this.names = Utils.toArrayList(nameString);
        validate();
    }
    private void validate(){
        checkNamePattern();
        checkNameSize();
        checkDuplicate();
    }
    private void checkNamePattern(){

    }
    private void checkNameSize(){

    }
    private void checkDuplicate(){

    }
}

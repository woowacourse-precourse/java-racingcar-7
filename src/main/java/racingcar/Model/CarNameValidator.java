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
        if(!Constants.nameStringPattern.matcher(nameString).matches()){
            throw new IllegalArgumentException(Constants.CAR_NAME_WRONG);
        }
    }
    private void checkNameSize(){
        if(names.stream().anyMatch(name -> name.isEmpty() || name.length() >= Constants.MAX_NAME_SIZE)){
            throw new IllegalArgumentException(Constants.CAR_NAME_LENGTH_WRONG);
        }
    }
    private void checkDuplicate(){
        if(names.size() != names.stream().distinct().count()){
            throw new IllegalArgumentException(Constants.CAR_NAME_DUPLICATE);
        }
    }
}

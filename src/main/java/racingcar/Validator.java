package racingcar;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public HashSet<String> usernameSet = new HashSet<>();

    public void validateUsernames(List<String> usernames) {
        for (String username : usernames) {
            validateUsernameLength(username);
            validateDuplicateUsername(username);
            usernameSet.add(username);
        }
    }

    private void validateUsernameLength(String name){
        if(name.length() > 5 || name.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateUsername(String name){
        if(usernameSet.contains(name)){
            throw new IllegalArgumentException();
        }
    }

    public void isDigit(String string){
        for(int i = 0; i < string.length(); i++){
            if(!Character.isDigit(string.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }
}

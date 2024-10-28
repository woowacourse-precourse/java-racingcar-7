package racingcar.Input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameInput {

  private String[] name;

  public NameInput() {
  }

  public boolean validateInput(String input) {
    List<String> names = Arrays.stream(input.split(","))
        .map(String::trim)
        .toList();

    if (names.size() == 0) {
      throw new IllegalArgumentException();
    }

    if (names.stream().anyMatch(name -> name.length() == 0)) {
      throw new IllegalArgumentException();
    }

    if (names.stream().anyMatch(name -> name.length() > 5)) {
      throw new IllegalArgumentException();
    }

    Set<String> uniqueNames = new HashSet<>(names);
    if (uniqueNames.size() < names.size()) {
      throw new IllegalArgumentException();
    }
    return true;
  }

  public void setName(String input) {
    this.name = input.split(",");
  }

  public String[] getName() {
    return name;
  }
}

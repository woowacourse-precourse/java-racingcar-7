package repository;

import java.util.Set;

public interface Repository {
    Boolean isDuplicateName(String name);

    void save(String name,Long moveForwardCount);

    Long find(String name);

    int size();

    Set<String> repositoryKeyset();


}

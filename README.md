# java-racingcar-precourse

---
## 1. 기능 요구 사항 분석
- 입력되는 문자열이 적절한 형식에 부합하는지 판별할 수 있어야 한다.
- 자동차의 이름과 위치를 저장할 수 있어야 한다.
- 반복적인 난수 생성을 통해 자동차의 위치를 갱신할 수 있어야한다.
- 출력 형식에 맞게 자동차의 위치정보를 출력할 수 있어야 한다.
- 우승자를 찾고, 모든 우승자를 출력할 수 있어야 한다.

## 2. 아이디어

- 문자열의 주어진 형식에 매칭되는지 판별하기 위해 정규식(Regular Expression) 을 사용한다.
- 자동차에 대한 정보를 Car 객체에 저장하고, 자바 컬렉션 ArrayList를 통해 관리한다.
- 컬렉션을 순회하며 최대 전진거리를 찾고, 이와 같은 주행거리의 자동차를 출력한다.

## 3. 구현할 기능 목록

1. 구현할 클래스는 Application과 Car, View로 정한다.
2. Application에서는 camp.nextstep.edu.missionutils.Console 라이브러리를 사용해 문자열을 입력받는다.
3. Application에서는 두가지 입력에 대한 정규식을 멤버로 두어 입력을 받는다.
4. Application에서는 입력이 각 패턴에 맞지 않는 경우 IllegalArgumentException을 발생시킨다.
4. Application에서는 play를 통해 Car.move를 반복호출한다.
5. Car에서는 move에서 난수 생성기를 통해 각 Car의 위치를 조정한다.
6. View에서는 두번의 입력에 대한 안내문구를 출력한다.
7. View에서는 printWinner를 통해 우승자를 출력한다. 이떄 2명 이상의 우승자에 대해서도 처리를 해준다.
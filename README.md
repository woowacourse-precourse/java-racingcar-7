# 자동차 경주

## 공통 피드백

- [ ] .gitignore에 필요한 사항 고려 후 업데이트
- [ ] 의미 있는 커밋 메세지 작성
- [ ] Java API 적극 활용
- [ ] 배열 대신 컬렉션 지향

## 과제 진행 요구 사항

- [x] [자동차 경주 저장소](https://github.com/woowacourse-precourse/java-racingcar-7)를 포크하고 클론할 것
- [x] 기능을 구현하기 전  `README.md`에 구현할 기능 목록을 정리할 것
- [x] 커밋 단위는 앞 단계에서  `README.md`에 정리한 기능 목록 단위일 것
  - 커밋 시 [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)를 준수할 것

## 기능 요구 사항

- [ ] 자동차 클래스 구현
  1. 자동차 이름과 이동 거리를 필드로 가질 것
  2. 자동차를 이동시키는 메서드를 구현
  3. 필드값을 반환하는 메서드를 구현
- [ ] 클래스 내 자동차를 이동시키는 메서드 구현
  1. camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 랜덤값 계산
  2. 0 ~ 9 사이의 랜덤값이 4 이상일 경우 1회 전진, 그렇지 않으면 정지
- [ ] 경주할 자동차 이름을 입력받는 기능
  - List\<Car> 반환
  1. 입력값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
  2. 쉼표를 구분자로 하여 경주할 자동차의 이름을 구분
  3. 자동차 이름의 길이는 5 이하일 것
  4. 자동차는 최대 100개까지만 허용
  5. 입력값이 위 조건을 만족하지 않을 경우 다시 입력받을 것
- [ ] 시도할 횟수인 n을 입력받는 기능
  - int 반환
  1. 입력값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
  2. n은 1 ~ 100 범위의 자연수
  3. 입력값이 위 조건을 만족하지 않을 경우 다시 입력받을 것
- [ ] 자동차를 n회 이동시키고, 우승자를 결정하는 기능
  - List\<Car>, int 입력
  1. 매 회차마다 이동 결과를 출력하고, 최대 이동 거리를 기억 (별도의 함수 호출)
  2. 이동이 완료되면 최대 이동 거리에 해당하는 우승자를 출력 (별도의 함수 호출)
- [ ] 자동차를 1회 이동시키는 기능
  - List\<Car> 입력, int 반환
  1. 자동차 클래스의 메서드를 활용
  2. 모든 자동차의 이동이 완료되면 결과를 출력
  3. 최대 이동 거리를 반환
- [ ] 우승자를 결정하는 기능
  - List\<Car>, int 입력
  1. 리스트 내 자동차를 순회하여 입력받은 최대 이동 거리의 자동차를 모두 탐색
  2. 탐색된 자동차는 List에 임시 저장 후 쉼표로 구분하여 출력
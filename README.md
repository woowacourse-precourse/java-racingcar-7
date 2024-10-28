# java-racingcar-precourse

---
```
.
├── main
│   └── java
│       └── racingcar
│           ├── Application.java
│           ├── controller
│           │   └── RacingController.java
│           ├── domain
│           │   └── Car.java
│           ├── service
│           │   ├── RacingService.java
│           │   ├── Separator.java
│           │   └── Validation.java
│           └── view
│               ├── InputView.java
│               └── OutputView.java
└── test
    └── java
        └── racingcar
            ├── ApplicationTest.java
            └── service
                ├── SeparatorTest.java
                └── ValidationTest.java


```
## 기능 목록
-[x] 입력 받은 문자열 분리 및 검증
  - 구분자(,)를 기준으로 문자열 분리
  - 분리된 이름 검증 => 5자 이하, 공백 여부 검증
-[x] 경주
  - 경주를 위한 자동차 등록
  - 경주 시작
    - 한번의 경주 시 각 자동차들의 전진 가능 여부 판단 후 전진
    - 한번의 경주가 끝나면 자동차들의 현재 전진 거리 출력
  - 경주 종료
    - 경주 종료 시 참여 자동차 중 가장 멀리 간 거리 계산
    - 가장 멀리간 자동차들 구하기
----
## 오류 처리 목록
-[x] 문자열 검증
  - 자동차 이름 입력 시 공백 및 구분자만 입력시 => "자동차 이름이 입력되지 않았습니다" 반환
  - 입력 문자열의 구분자 사이에 공백이 있을 때 => "자동차 이름이 공백으로 입력되었습니다" 반환
  - 자동차 이름에 중복이 있을 때 => "자동차 이름이 중복 되었습니다." 반환
  - 자동차 이름이 5자 초과일때 => "자동차 이름이 5자를 넘었습니다." 반환
-[x] 시도 횟수 검증
  - 시도 횟수가 숫자가 아닌 입력이 들어올 때 => "시도 횟수가 잘못 입력되었습니다." 반환
---



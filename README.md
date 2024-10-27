# 🏎️ 자동차 경주

---

## 📦 패키지 구조

```
project/
├── Application.java
├── 📁 racing
│   ├── Car
│   ├── Computer
│   ├── RacingController
│   └── RacingMessage
├── 📁 util
│   ├── ErrorMessage
│   ├── InputValidator
│   ├── Parser
│   
│   └── Validator
└── 📁 view
    ├── InputView
    └── OutputView
```

---

## 📁 패키지 설명

- **racing** : 
  - ```Car``` : 자동차 이름과 위치를 저장하는 모델
  - ```Controller``` : 경주 진행 및 우승자 판별 로직을 담당
  - ```RacingController``` : 경주 시작과 종료를 처리하는 컨트롤러
  - ```RacingMessage``` : 입출력 안내 메시지 관리


- **util** : 
  - ```ErrorMessage``` : 예외 메시지 및 상수 관리
  - ```InputValidator``` : 사용자의 입력값 검증
  - ```Parser``` : 입력값을 변환 및 파싱
  - ```Validator``` : 경주에서의 유효성 검사를 담당


- **view** : 입력과 출력을 담당하는 뷰 계층
  - ```InputView``` : 사용자로부터 입력을 받는 역할
  - ```OutputView``` : 사용자에게 결과를 출력하는 역할

---

## 💭 클래스 다이어그램

<img width="1054" alt="클래스 다이어그램" src="https://github.com/user-attachments/assets/42a48ea4-ec8f-4561-b543-39f44e300849">

---

## 구현 기능 목록

### ✅ 사용자 입력
- 사용자는 자동차 이름과 경주 횟수를 두 차례에 나누어 입력한다.
- 입력값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```  메서드를 사용하여 받는다.
- 입력값을 ```Parser``` 클래스를 통해 가공하여 컨트롤러에게 반환한다.
  - 첫 번째 입력값은 자동차 이름을 하나씩 추출하여 리스트로 반환
  - 두 번째 입력값은 정수로 변환하여 반환
    - 정수가 아닐 경우, 예외로 처리한다.

### ✅ 입력값 필터링
- 컨트롤러에서 입력값을 ```InputValidator``` 클래스를 통해 검증한다.
  - 자동차 이름이 공백일 경우, 예외로 처리한다.
  - 자동차 이름이 5자를 초과할 경우, 예외로 처리한다.
  - 경주 횟수가 양의 정수가 아닐 경우, 예외로 처리한다.
- 필터링된 입력값을 ```Computer``` 인스턴스에 저장한다.

### ✅ 경주 로직
- ```Computer``` 클래스에서 0~9 사이의 무작위 숫자를 생성한다.
- 랜덤값은 ```camp.nextstep.edu.missionutils.Randoms```의 ```pickNumberInRange()``` 메서드를 사용한다. 
- 생성된 숫자가 4 이상일 경우 자동차는 전진한다.
  - ```Car``` 객체의 ```movePosition()``` 메서드를 호출하여 위치를 이동시킨다.

### ✅ 차수별 실행 결과 안내
- 컨트롤러에서 경주 횟수만큼 경주를 반복하며, 차수별 결과를 출력한다.

### ✅ 우승자 판별 및 출력
- ```Computer``` 클래스에서 각 자동차 객체의 위치를 비교하여 우승자를 찾는다.
- 우승자는 한 명 이상일 수 있으며, 동점일 경우 여러 명의 우승자를 쉼표(,)로 구분하여 출력한다.
  - 우승자가 한 명도 없는 경우, 예외로 처리한다.

### ✅ 예외 처리 기능
- 상술한 예외들에 대해 ```IllegalArgumentException``` 을 발생시킨다.

# 2024 UTC Precourse 2주차 ___ java-racingcar
## 0️⃣ _ 1주차 회고록 및 보완할점
``` 
    
    📌 주어진 것에 몰두하자 

        기초 명세에서 요구사항을 제대로 읽지 않았다

        조금은 들떴던 탓일까? 너무 많은 것을 하고싶었던걸까? 
        1주차에 친절히 적혀있던 아무것도 입력되지 않으면 0을 출력한다. 이 짧은 글을 읽지 못했다...
        그저 정규 표현 문자열, 특수문자에 대한 예외처리만 머릿속에 가득했다.
        지나간 것에 후회해봤자 남는것은 없지만, 이걸 양분 삼아야겠다.

        2주차는 "주어진 내용"에 성실하게 입각하여 구현한다.
        이후 주어진 시간에 내 의견을 "곁들임" 느낌으로 가야겠다.


    📌 Git Commit 컨벤션을 다시 잡자.

        되돌아 보니 조금은 조잡하게 작성된거같다. 
        어느것은 한글로... 어느것은 영어로... 어느것은 섞어서...
        나만의 Git Convention을 하나 정해서 최대한 구체적으로 기록을 남겨보자


    📌 테스트 케이스는 더욱 다양한 케이스에서 많이 검증한다.

        1주차에는 각 기능에 맞춰 테스트 케이스를 다 작성하긴 하였다. 하지만 케이스별 1개씩이였다.
        2주차에는 더욱 다양하고, 확실한 테스트 검증을 추가해볼 예정이다.


```
## 1️⃣ _ 파일 디렉토리 구조
```
------------------GUIDE---------------------

ㄴ -> Directory
- -> Parameter
+ -> Method

--------------------------------------------
/src/main/java/racingcar
    │
    ├── Application.java
    ├── controller/
    ├── dto/
    │   └─ racingCarDTO
    │       ├─ - racingCarData : HashMap<String, Integer>
    │       ├─ - numberOfRacing : int
    │       ├─ + racingCarDTO(racingCarNameString : String, numberOfRacingString : String) : RacingCarDTO
    │       ├─ + getRacingCarData() : HashMap<String, Integer>
    │       ├─ + getNumberOfRacing() : int
    │       └─ + updateRacingCarDistance(carName : String, distance : int)
    ├── service/
    │   └─ RacingServiceImpl.java
    │       ├─ + moveRacingCarByRandom(racingCarDTO : racingCarDTO) 
    │       └─ + getRandomMovementResult() : int
    ├── view/
    │   ├─ InputView.java
    │   │   ├─ + getRacingCarNameFromUser() : String
    │   │   └─ + getNumberOfRaceFromUser() : String
    │   └─ OutputView.java
    │       ├─ + printEachDistanceByRandomMovement(racingCarDTO : racingCarDTO)
    │       └─ + printWinnerOfRacing(racingCarDTO : racingCarDTO)
    └── util/
        ├─ checkRacingCarNameListIsAvailable.java
        │   ├─ + checkRacingCarNameListIsAvailable(racingCarNames : String)
        │   ├─ + validateNameLength(racingCarList : String[]) 
        │   ├─ + validateDelimiter(racingCarNames : String, numOfRacingCar : int)
        │   └─ + validateDuplicateNames(racingCarList : String[])
        └─ RacingNumberValidator.java
            └─ + checkNumberOfRacingIsAvailable(stringNumOfRace : String)
```

## 2️⃣ _ 나만의 Git Convention 
```
    <Header>
    [Keyword] : 요약
    - 헤더에는 끝에 .을 찍지 않는다
    - 명령어의 어투를 사용
    - Keyword Type
        - Docs : 문서 관련 내용
        - Feat : 새로운 내용 추가(구현)
        - Fix : 기존 구현 내용 수정
        - Del : 기존 구현 내용 삭제
        - Test : 테스트 코드 관련 내용

    <Body>
    - Header와 한 줄 띄워서 작성
    - 모든 내용은 영어로 작성하려고 노력
    - 자세한 수정 내용에 대해서 작성

    <예시>
    Feat : Add 1 method in ServiceImpl.java

    Implement int getRandomMovement(int num) method
        - Input : integer
        - Output : Integer
        - Main Purpose : get Random Number to decide to Move or not

```
## 3️⃣ _ 일별 기능 구현 리스트 & 회고
### 2024.10.16 Wed
``` 

    - 기초 명세서를 기반으로 각각의 구현할 것을 사전에 정의한다.
    - 1주차에서 사용한 Controller / DTO / Service / View / Util 체제는 그대로 유지한다.
    - 나만의 Git Convention과 규칙을 작성한다.
    - 이번 미션에서는 처음 사용자가 입력하는 값에 대한 예외사항 처리만이 존재한다.
        - 오늘은 사용자의 입력을 받고, 예외 처리를 하는 부분을 작성한다.
    - 오늘의 구현 내용
        - View 패키지에 사용자의 입력을 받는 Static Method 구현한다.
        - 주어진 명세 + 기초적인 것(중복처리) 등에 대한 예외처리 로직을 구현한다.
        - 구현된 기능에 대한 Test Code를 작성한다.

    ✅ 구현 후 느낀점 / 추가 개선사항 

    -   처음에는 View에서 사용자의 입력을 받은 뒤에 Controller에 넘기기전에 예외처리를 하려고했다.
        하지만 다시 생각해보았을때 단일 책임의 원칙인데 View한테 그런걸 시켜도 되나? 라고 생각했고 
        View는 정말 자신의 역할 그대로, 입력만 받아서 전달 그 어떤 가공도 하지 않도록 하였다.
    
    -   1주차에서는 예외처리를 클래스 1개로 운영했지만 이번에는 각각의 역할에 맞춰서 분리하여 구성하였다.
        현재는 먼저 주어진 명세에서 제공된 예외처리(이름은 5보다 이하여아한다.)를 먼저 구현하고, 
        중요한 몇가지 경우의 수(null 값, 중복 이름)에 대한 내용을 추가했다.

    -   오늘 구현한 예외 처리에 대해서 테스트 케이스를 바로 작성해 보았다.
        생각보다 어디에서는 의도대로 되고, 어디에서는 의도대로 되지않았다.
        기존에는 올바른 입력들에 대해서는 테스트를 안짰는데 더욱 많은 테스트 케이스를 짜보아야겠다고 느꼈다.
   
```
### 2024.10.17 Thu
``` 

    - DTO 내부 구조 설정 및 관련 클래스 생성
    - Service 구조 설계 및 구현
        - 회차별 레이스 실행 함수
    - 출력 관련 Method 2개 설정
        - 각 레이스 회차별 결과 출력 함수
        - 최종 우승자 출력 함수


    ✅ 구현 후 느낀점 / 추가 개선사항 
    -   DTO와 Service, OutputView와 관련된 구현을 실행하였는데 구현하고 나니 많은 고민이 남았다.
        먼저 DTO에는 어차피 이미 중복에 대한 문제는 예외처리 함수를 구현해서 현재 HashMap을 사용하도록 해놨다. 하지만 Hash를 이용하기에 나중에 출력과정에서 문제가 생길수 있지않나? 라는 고민이 있다.
        OutputView에 현재 . 즉 Class에서 제공하는 다양한 함수들을 활용하도록 해놓았는데 이것이 더 효율적인지 한번 더 생각해보아야겠다.
    -   Service에서 랜덤 값을 이용해서 이동하는 것에서 최대한 Service에서 직접 데이터를 수정(대입을 이용해서 수집)이 일어나지 않도록 DTO에 업데이트 함수를 만들어서 사용하였다.
        이 부분은 그래도 조금 나름 잘 설계했다고 생각한다.
    

```
### 2024.10.18 Fri
``` 

    - Controller 구현 및 DTO, Service, 예외처리 연결
    - ApplicationTest 통과하기


    ✅ 구현 후 느낀점 / 추가 개선사항 
    
    

```
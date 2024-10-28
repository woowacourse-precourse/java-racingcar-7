1. 자동차 이름들 입력 받기 → [Initialize.java](http://Initialize.java) → initializeCars

1-1 문자열 입력 받아 split해서 Car객체로 저장해주기

1-2 객체로 저장하는 과정에서 공백에 대한 처리해주기

1. 실행 횟수 입력 받기 → [Initialize.java](http://Initialize.java) → initializeAttemptCount

2-1 모든 값 입력 받고 잘못된 이름이 있는지 확인하기 → ValidateValue.java → validateName

2-2 음수이거나 정수가 아닌 경우에 대해 처리하기 → ValidateValue.java → validateAttemptCount

1. 경주를 시작해 랜덤 값에 따라 이동할지 가만히 있을지 판단하고 결과 출력하기 → Racing.java

3-1 각각의 car에 대해 랜덤 값 확인 후 갈지 말지 결정 moveCount에 저장해두기 → carMove

3-2 저장한 값을 토대로 결과 출력해주기 → printRacingResult

1. 최종 우승자 알아내고 출력하기 → [Winner.java](http://Winner.java) → printFinalWinner

4-1 실행 횟수만큼 경주 후 moveCount가 가장 큰 값을 가지는 car가 최종 우승자가 됨

4-2 출력 양식에 맞게 출력해주기

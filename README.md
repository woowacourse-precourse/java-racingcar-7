# java-racingcar-precourse

## Check the function of racingcar and what I need to handle

### 1. 이름 받기
#### &ensp; - 쉼표로 구분 후 String Array로 변환
#### &ensp; - 이름 내 특수문자 존재 시 reject
#### &ensp; - 이름 공백 reject (쉼표가 user input의 맨 앞 혹은 맨 뒤에 오는 경우, 쉼표가 연속으로 입력된 경우, input 자체가 Empty인 경우, 이름 내 공백 포함인 경우)

### 2. 시도 횟수 받기
#### &ensp; - 숫자가 아닐 시, 양의 정수가 아닐 시  reject
#### &ensp; - Int형으로 변환

### 3. 각 자동차의 동작
#### &ensp; - Car class 작성
#### &ensp; - Car.getName(), Car.getLocation(), Car.go(), Car.printLocation() 통해 객체 별 동작 제어
#### &ensp; - 받은 Name을 각 Car에 할당

### 4. Racing 시작
#### &ensp; - 시도 횟수 만큼 존재하는 Car들을 Car.go, 시도 할 때 마다 이름별로 current location print

### 5. Winner 도출
#### &ensp; - max Location을 가진 car의 이름을 우승자로 설정
#### &ensp; - Racing의 결과로 모든 Location이 0인 경우, 공동 우승 처리

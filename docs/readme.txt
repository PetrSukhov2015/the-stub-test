Описание файлов:
stub/test/TheStubTest
Stub.java - класс заглушка пиринмает json, возвращает string
StubTest.java - класс тест - передает валидный json Id задачи и проверяет, что вернулся корректный ответ с заголовком http200
StubTestNotFound.java - класс тест, тестирует, когда такого id нет
StubTestReqFields.java - тестирует, когда нет обязательного поля id 

json/
taskId.json - json на вход stub с валидными значениями
taskIdError.json - json с id задачи, который stub не найдет
taskOutOfReqFieldsId.json - json где нет id, на которое stub ответит ошибкой провкерки обязательных полей

task.json - корректный json, который stub возвращает в случае валидного запроса
notFound.json - stub не нашел такой задачи
error.json - stub не нашел обязательных полей

pom.xml - описание maven библиотек
testng.xml - описание 3-х тестов

Как запускать:
1)установить jdk18, maven на ОС с которой будут запускатсья тесты, прописать в глобальные переменные jdk, jre и maven
	 1.1)https://www.youtube.com/watch?v=yrRmLOcB9fg
	 1.2)https://www.youtube.com/watch?v=oTRmukUvB50
2)проверить, что maven установился mvn -v
3)в консоли перейти в директорию, где находятся pom.xml и testng.xml файлы проекта
	https://www.youtube.com/watch?v=wTUqYxR5XF8
4)выполнить mvn clean test
5)результаты теста отобразятся в консоли и в директории test-output




# Проект по программированию на Java

Этот проект содержит решения четырёх задач на Java, каждая из которых расположена в своей директории.

## Структура проекта

- `Task1.java`: Программа для решения первого задания.
- `Task2.java`: Программа для решения второго задания.
- `Task3.java`: Программа для решения третьего задания, использующая Maven и внешние библиотеки.
- `Task4.java`: Программа для решения четвертого задания.

## Как запустить программы

Каждое задание имеет свои инструкции для компиляции и запуска.

### Задание 1

Перейдите в директорию `src/main/java`.

#### Компиляция
```bash
javac org/example/task1/Task1.java
```
#### Запуск
```bash
java org/example/task1/Task1 <n> <m>
```
Замените `<n>` и `<m>` на соответствующие аргументы программы.

### Задание 2
Перейдите в директорию `src/main/java`.

#### Компиляция
```bash
javac org/example/task2/Task2.java
```
#### Запуск
```bash
java org.example.task2.Task2 org/example/task2/circle.txt org/example/task2/dot.txt
```
### Задание 3
Эта программа требует использования Maven. Убедитесь, что вы находитесь в корневой директории проекта, где расположен файл `pom.xml`.

#### Запуск
```bash
mvn exec:java -Dexec.args="src/main/java/org/example/task3/values.json src/main/java/org/example/task3/tests.json src/main/java/org/example/task3/report.json"
```
### Задание 4   
Перейдите в директорию `src/main/java`.

#### Компиляция
```bash
javac org/example/task4/Task4.java
```
#### Запуск
```bash
java org.example.task4.Task4 org/example/task4/numbers.txt
```
## Зависимости   
Задание 3 использует внешние библиотеки, управляемые через Maven. Для успешного запуска убедитесь, что Maven установлен и настроен правильно.


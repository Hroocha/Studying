package tasks.lesson2;


// никогда не возвращать строку в месте, где можно заранее определить исходы, переделать на enum
/*
1. Продолжаем работать с участниками и выполнением действий. Создайте три класса Человек,
Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
прыгать, все также с выводом информации о действии в консоль.
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
© ВТБ совместно с GeekBrains
7
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина
(для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
3. Создайте два массив: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий. Если участник не смог пройти одно из препятствий, то дальше по
списку он препятствий не идет
*/

public class Main {

    public static void main(String[] args) {
        Action[] members = new Action[]{
                new Cat(5, 1.5), // км и м
                new Human(7, 1.8),
                new Robot(15, 2.2)
        };
        Obstacle[] obstacleCourse = new Obstacle[]{
                new Treadmill(1),
                new Wall(0.5),
                new Treadmill(4),
                new Wall(1.5),
                new Treadmill(6),
                new Wall(1.9),
        };

        for (Action member : members) {
            boolean fail = false;
            for (Obstacle obstacle : obstacleCourse) {
                Result result = obstacle.doAction(member);
                if (result.equals(Result.FAIL)) {
                    System.out.println(member.getClass().getSimpleName() + " не смог");
                    fail = true;
                    break;
                }
                System.out.println(member.getClass().getSimpleName() + " смог");
            }
            if (!fail) {
                System.out.println(member.getClass().getSimpleName() + " прошел все препятствия");
            }
        }


    }


}
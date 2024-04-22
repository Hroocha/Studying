package tasks.lesson9;


public class Main {


    /*1. Реализуйте возможность разметки класса с помощью набора ваших собственных аннотаций
(@Table(title), @Column). Напишите обработчик аннотаций, который позволит по размеченному
классу построить таблицу в базе данных.
2. * Второй обработчик аннотаций должен уметь добавлять объект размеченного класса в
полученную таблицу.
Замечание: Считаем что в проекте нет связанных между собой сущностей, чтобы не
продумывать логику их взаимодействия.*/


    public static void main(String[] args) {

        CreatorInSQL creatorInSql = new CreatorInSQL();
        Students student1 = new Students("Alex", 20);
        System.out.println(creatorInSql.getCreateTableSql(student1));
        System.out.println(creatorInSql.getInsertIntoSql(student1));


//        try {
//            creatorInSql.connect();
////            creatorInSql.statement.executeUpdate("INSERT INTO students (name, age) VALUES ('Bob', 20)");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            creatorInSql.disconnect();
//        }















    }


}

package tasks.lesson9;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatorInSQL {
    private Connection connection;
    public Statement statement;


    //проверка, имеет ли объект аннотацию Table. Если не имеет, бросить подходящее исключение

    //Находишь у obj аннотацию @Table и вытаскиваешь из нее title

    //Получить все field для obj

    //Вычленить все поля с аннотациенй @Column

    //Опираясь на тип, добавить к sql запросу соответсвующий текст
    public String getCreateTableSql(Object obj) throws IllegalArgumentException {
        Class<?> currentObj = obj.getClass();
        if (currentObj.isAnnotationPresent(Table.class)) {
            String title = currentObj.getAnnotation(Table.class).title();
            Field[] fields = currentObj.getDeclaredFields();
            StringBuilder columns = new StringBuilder();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Column.class)) {
                    String type = null;
                    if (f.getType().getTypeName().equals("int") || f.getType().getTypeName().equals("Integer")) {
                        type = "int";
                    } else {
                        type = "varchar (255)";
                    }
                    if (fields[fields.length - 1] == f) {
                        columns.append(f.getName()).append(" ").append(type);
                    } else {
                        columns.append(f.getName()).append(" ").append(type).append(", ");
                    }
                }
            }
            return "CREATE TABLE " + title + " (" + columns + ");";
        } else throw new IllegalArgumentException("Объект не имеет аннотацию Table");
//        return ""; // TODO: 13.02.2024 CREATE TABLE <title> (<field1 type1>, <field2 type2>);
    }

    //проверка, имеет ли объект аннотацию Table. Если не имеет, бросить подходящее исключение

    //Находишь у obj аннотацию @Table и вытаскиваешь из нее title

    //Получить все field для obj

    //Вычленить все поля с аннотациенй @Column

    //Опираясь на тип, добавить к sql запросу соответсвующий текст

    public String getInsertIntoSql(Object obj) throws IllegalArgumentException {
        Class<?> currentObj = obj.getClass();
        if (currentObj.isAnnotationPresent(Table.class)) {
            String title = currentObj.getAnnotation(Table.class).title();
            Field[] fields = currentObj.getDeclaredFields();
            StringBuilder columns = new StringBuilder();
            StringBuilder values = new StringBuilder();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Column.class)) {
                    if (fields[fields.length - 1] == f) {
                        columns.append(f.getName());
                        try {
                            values.append(f.get(obj));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        columns.append(f.getName()).append(", ");
                        try {
                            values.append(f.get(obj)).append(", ");
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            return "INSERT INTO " + title + " (" + columns + ") VALUES (" + values + ");";
        } else throw new IllegalArgumentException("Объект не имеет аннотацию Table");

    }

    public void connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tasks.lesson9", "postgres", "Hroochnastia7");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

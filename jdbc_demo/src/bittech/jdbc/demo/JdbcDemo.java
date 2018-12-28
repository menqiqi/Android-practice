package bittech.jdbc.demo;

import java.sql.*;

public class JdbcDemo {

    private  static final String CONN_URL =
            "jdbc:mysql://localhost:3306/memo?user=root&password=men.si.qi.123&useUnicode=true&characterEncoding=UTF-8";

    private static final String QYERY_SQL =
            "select id,group_id,title,content,is_protected,background,is_remind,remind_time,created_time,modify_time from memo_info";

    public static void main(String[] args)throws ClassNotFoundException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        Class.forName("com.mysql.jdbc.Driver");

        try {
            connection = DriverManager.getConnection(CONN_URL);

            statement = connection.createStatement();

            resultSet= statement.executeQuery(QYERY_SQL);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Date createTime = resultSet.getDate("created_time");

                System.out.println(String.format("Memo: id=%d, title=%s, content=%s, createTime=%s", id,title,content, createTime.toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭结果集
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //关闭命令
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //关闭连接命令
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

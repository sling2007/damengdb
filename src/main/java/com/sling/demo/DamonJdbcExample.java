package com.sling.demo;

/**
 * User: sunling
 * Date: 2024/11/29 11:05
 * Description:
 **/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DamonJdbcExample {

    // 数据库连接信息
    private static final String JDBC_URL = "jdbc:dm://localhost:5236";
    private static final String JDBC_USER = "HMNTECH";
    private static final String JDBC_PASSWORD = "Marine.123";

    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 注册JDBC驱动（如果JDBC驱动没有自动注册）
             Class.forName("dm.jdbc.driver.DmDriver"); // 如果需要手动注册

            // 2. 打开连接
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // 3. 插入数据
            String insertSQL = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, "aba阿斯蒂芬就");
            preparedStatement.setInt(2, 987654321);
            preparedStatement.executeUpdate();

            // 4. 查询数据
            String selectSQL = "SELECT * FROM your_table WHERE column1 != ?";
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, "value1");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // 处理结果集
                System.out.println("Column1: " + resultSet.getString("column1"));
                System.out.println("Column2: " + resultSet.getInt("column2"));
            }

            // 5. 更新数据
            String updateSQL = "UPDATE your_table SET column2 = ? WHERE column1 != ?";
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, 456);
            preparedStatement.setString(2, "value1");
            preparedStatement.executeUpdate();

            // 6. 删除数据
            String deleteSQL = "DELETE FROM your_table WHERE column1 = ?";
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, "value1");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭资源
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
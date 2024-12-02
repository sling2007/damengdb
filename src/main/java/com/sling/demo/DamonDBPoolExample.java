package com.sling.demo;

import com.sling.demo.util.DamonDBDruidPoolUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: sunling
 * Date: 2024/11/29 10:50
 * Description:
 **/
public class DamonDBPoolExample {



    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DamonDBDruidPoolUtil.getConnection();

//            String selectSQL = "SELECT * FROM your_table WHERE column1 != ?";
//            preparedStatement = connection.prepareStatement(selectSQL);
//            preparedStatement.setString(1, "value1");
//            resultSet = preparedStatement.executeQuery();

            String selectSQL = "SELECT * FROM your_table WHERE column2 = ?";
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, 456);
            resultSet = preparedStatement.executeQuery();



            while (resultSet.next()) {
                // 处理结果集
                System.out.println("Column1: " + resultSet.getString("column1"));
                System.out.println("Column2: " + resultSet.getInt("column2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源（注意：连接池中的连接不需要手动关闭，它们会被连接池管理）
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                // 注意：不要关闭从连接池获取的连接！
                // if (connection != null) connection.close(); // 不要这样做！
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package runner;


import utilities.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    //  JDBC ----->Java Database Connectivity

    public static void main(String[] args) throws IOException, SQLException {
        //Connection
        //Statement
        //ResultSet

        Connection connection= DriverManager.getConnection(
                Configuration.getProperties("dbHostname"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        //witout Type scroll insensitive we canot jump ,go nton the next
        ResultSet resultSet = statement.executeQuery("Select * from employees");

        resultSet.next();
        resultSet.next();
        //resultSet.next();



        String myFirstData=resultSet.getString(1);
        System.out.println("FIRST_NAME");
        System.out.println(myFirstData);
       resultSet.next();
       System.out.println("myFirstData");
        System.out.println(resultSet.getObject("FIRST_NAME"));
        resultSet.next();
        System.out.println(resultSet.getObject("employee_id"));

        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        System.out.println("-------------");

        System.out.println(rsMetadata.getColumnCount());
        System.out.println(rsMetadata.getColumnName(5));
        System.out.println(rsMetadata.getColumnType(5));
        System.out.println(rsMetadata.getColumnClassName(1));

        System.out.println("=====================================");

        List<Map<String,Object>> listOfMaps=new ArrayList<>();


        while(resultSet.next()){
            Map<String,Object>row=new HashMap<>();
            for (int i=1; i<=rsMetadata.getColumnCount();i++) {

                row.put(rsMetadata.getColumnName(i),resultSet.getObject(rsMetadata.getColumnName(i)));
            }
            listOfMaps.add(row);

        }
        for (int i=0; i<listOfMaps.size(); i++){
            for (Object key:listOfMaps.get(i).keySet()){
                System.out.println(listOfMaps.get(i).get(key));
            }
        }



    }

    }


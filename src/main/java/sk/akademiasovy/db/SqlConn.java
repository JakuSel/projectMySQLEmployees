package sk.akademiasovy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlConn {

        private Connection conn;
        private final String url = "jdbc:mysql://localhost:3306/";
        private final String dbName = "employees";
        private final String driver = "com.mysql.jdbc.Driver";
        private final String root="root";
        private final String passwordRoot = "";

        public String getSalary(String name){
                String employeeSalary="";

                try {
                        Class.forName(driver).newInstance();
                        conn = DriverManager.getConnection(url+dbName, root, passwordRoot);

                        String queryCmd = "Select salary from salaries inner join employees on " +
                                "employees.emp_no=salaries.emp_no " +
                                "where employees.hero_name = '" + name + "'";
                        System.out.println(queryCmd);
                        PreparedStatement preparedStatement = conn.prepareStatement(queryCmd);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                                employeeSalary = resultSet.getString("salary");
                        }

                } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                }

                return employeeSalary;

        }



        public List<String> getHeroes(){
                List<String> heroes=new ArrayList<>();
                try {
                        Class.forName(driver).newInstance();
                        conn = DriverManager.getConnection(url+dbName, root, passwordRoot);
                        String queryCmd="Select hero_name from employees;";

                        PreparedStatement preparedStatement=conn.prepareStatement(queryCmd);
                        ResultSet resultSet=preparedStatement.executeQuery();

                        while(resultSet.next()){
                                String name=resultSet.getString("hero_name");
                                heroes.add(name);
                        }
                        conn.close();
                }
                catch (Exception e){
                        System.out.println("Err " +e.getMessage());
                }
                return heroes;

        }

        public String getCivilSurrName(String name){
                String civilSurrname="";
                try {
                        Class.forName(driver).newInstance();
                        conn = DriverManager.getConnection(url+dbName, root, passwordRoot);
                        String queryCmd="Select last_name from employees " +
                                "where hero_name='" + name + "';";

                        PreparedStatement preparedStatement=conn.prepareStatement(queryCmd);
                        ResultSet resultSet=preparedStatement.executeQuery();

                        if (resultSet.next()) {
                                civilSurrname = resultSet.getString("last_name");
                        }
                        conn.close();
                }
                catch (Exception e){
                        System.out.println("Err " +e.getMessage());
                }
                System.out.println(civilSurrname+"correcction");
                return civilSurrname;
        }


}

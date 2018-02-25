package sk.akademiasovy.projectmysqlemployees.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MysqlEmployees {
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String dbName = "employees";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String userName2 = "root";
    private final String password = "sql+17";
    private Connection con;

    public List<String> getEmployees()
    {
        List<String> res = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url + dbName, userName2, password);
            String cmd = "SELECT * FROM employees";
            PreparedStatement preparedStatement = con.prepareStatement(cmd);
            ResultSet resultSet = preparedStatement.executeQuery();
            String swap = "";
            ObjEmployee employee = new ObjEmployee();
            while(resultSet.next()){
                System.out.println(resultSet.getString("gender"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setId(resultSet.getString("emp_no"));
                swap = employee.createString();
                res.add(swap);
            }
            con.close();
        }
        catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
        return res;
    }

    public List<String> getSalary(String id)
    {
        List<String> res = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url + dbName, userName2, password);
            String cmd = "SELECT * FROM salaries where emp_no='"+id+"'";
            PreparedStatement preparedStatement = con.prepareStatement(cmd);
            ResultSet resultSet = preparedStatement.executeQuery();
            String swap = "";
            ObjSalary salary = new ObjSalary();
            while(resultSet.next()){
                salary.setId(resultSet.getString("emp_no"));
                salary.setSalary(resultSet.getString("salary"));
                salary.setFrom_date(resultSet.getString("from_date"));
                salary.setTo_date(resultSet.getString("to_date"));
                swap = salary.createString();
                res.add(swap);
            }
            con.close();
        }
        catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
        return res;
    }

}

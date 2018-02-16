package sk.akademiasovy.projectmysqlemployees.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MysqlEmployees {
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String dbName = "employees";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String userName2 = "---";
    private final String password = "---";
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
                employee.setFirstName(resultSet.getNString("first_name"));
                employee.setLastName(resultSet.getNString("last_name"));
                employee.setId(resultSet.getNString("emp_no"));
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
                salary.setId(resultSet.getNString("emp_no"));
                salary.setSalary(resultSet.getNString("salary"));
                salary.setFrom_date(resultSet.getNString("from_date"));
                salary.setTo_date(resultSet.getNString("to_date"));
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

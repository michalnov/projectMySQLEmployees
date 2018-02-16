package sk.akademiasovy.projectmysqlemployees.db;

public class ObjSalary {
    private String id;
    private String salary;
    private String from_date;
    private String to_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String createString()
    {
        String swap = "{\"id\":\"";
        swap = swap + this.id;
        swap = swap + "\",\"salary\":\"";
        swap = swap + this.salary;
        swap = swap + "\",\"from_date\":\"";
        swap = swap + this.from_date;
        swap = swap + "\",\"to_date\":\"";
        swap = swap + this.to_date;
        swap = swap + "\"}";
        return swap;
    }
}

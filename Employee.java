package inheritance;
class Employee {
    private String name;
    private int id,ms;

    public Employee(String name,int id,int ms){
        this.name = name;
        this.id = id;
        this.ms = ms;
    }

    public int yearlySalary()
    {
        return this.ms*12;
    }

    public String getDetails()
    {
        String d = "Name = " +this.name+" id = "+this.id+" ms = "+this.ms+" yearly salary = "+this.yearlySalary();
        return d;
    }

}

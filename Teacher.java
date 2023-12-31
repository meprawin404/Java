package inheritance;
class Teacher extends inheritance.Employee {
    private int no_sub;

    public Teacher(String name, int id, int ms, int no_sub){
        super(name,id,ms);
        this.no_sub = no_sub;
    }

    @Override
    public int yearlySalary(){
        return super.yearlySalary()+this.no_sub*1000;
    }

    @Override
    public String getDetails()
    {
        return super.getDetails()+"no of subjects = "+this.no_sub;
    }
}

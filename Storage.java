public class Storage {
    private String Capacity;
    private String model;
    boolean type;

    public Storage(String Capacity,String model, boolean type){
        this.Capacity = Capacity;
        this.model = model;
        this.type = type;
    }

    public String toString(){
        String t = type?"SSD":"HHD";
        return "capacity = "+Capacity+" model = "+model+" Tyep = "+t;
    }
}

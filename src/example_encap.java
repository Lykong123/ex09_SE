public class example_encap {
    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static void main(String args[]){
        example_encap ex = new example_encap();
        ex.setName("kong");
        System.out.println(ex.getName());
    }
}

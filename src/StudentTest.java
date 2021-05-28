import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentTest {
  public static void main(String[] args)throws Exception{
      Student s = Student.dataInput();
      System.out.println(s);
  }
}

class Student {
    private int id;
    private String name, telephone_number, city, groupName;
    private Date dateOfBirth;

    FiledUtil filedUtil = new FiledUtil();
    Scanner sc = new Scanner(System.in);
    public Student() {
    }

    public Student(int id, String name, String telephone_number, String city, String groupName, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.telephone_number = telephone_number;
        this.city = city;
        this.groupName = groupName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id>0&& id< 100){
            this.id = id;
        }else{
            System.out.println("Invalid id");
            throw new IllegalArgumentException("Out of range");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        filedUtil.check_null_empty_blank(name, "name");
        this.name = name;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) throws PhoneNumberExeption{
        PhoneNumberExeption phoneNumberExeption = new PhoneNumberExeption();
        Pattern pattern = Pattern.compile("(\\+855|0)[0-9]{8,9}$");
        Matcher matcher = pattern.matcher(telephone_number);
        boolean matchFound = matcher.find();
        if(matchFound){
            this.telephone_number = telephone_number;
        }else throw phoneNumberExeption;
        //if(telephone_number.length()==9 || telephone_number.length()==8){
          //  this.telephone_number = telephone_number;
        //}
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        filedUtil.check_null_empty_blank(city, "City");
        this.city = city;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) throws GroupException{
        Pattern pattern = Pattern.compile("(I[1-5]|T[1-2])[A-Z]{1,2}$");
        Matcher match = pattern.matcher(groupName);
        boolean matchFound = match.find();
        if(matchFound){
            this.groupName = groupName;
        }else{
            throw new GroupException();
        }
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)throws BirthDateException{
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 14);        //equal or more than 15 years
        Date fifthYearOld = cal.getTime();
        if (dateOfBirth.compareTo(fifthYearOld) <= 0) {
            this.dateOfBirth = dateOfBirth;
        }else {
            throw new BirthDateException();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone_number='+855" + telephone_number + '\'' +
                ", city='" + city + '\'' +
                ", groupName='" + groupName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    class BirthDateException extends Exception{
        public BirthDateException(){
            super("Invalid date of birth");
        }
        public BirthDateException(String message){
            super(message);
        }
    }

    class FiledUtil{
        public void check_null_empty_blank(String field, String label){
            if(field == null){
               throw new NullPointerException(label+" should not be null");
            }
            if(field.isEmpty() || field.isBlank()){
                throw new IllegalArgumentException(label+" should not be empty or blank");
            }
        }
    }

    class PhoneNumberExeption extends Exception{
        public PhoneNumberExeption(){
            super("Invalid telephone");
        }
    }

    class GroupException extends Exception{
        public GroupException(){
            super("Group Invalid");
        }
    }

    //method to input data
    public static Student dataInput()throws Exception{
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.print("Student ID: ");
        s.setId(Integer.parseInt(sc.nextLine()));
        System.out.print("Student name: ");
        s.setName(sc.nextLine());
        System.out.print("Student date of birth(dd/MM/yyyy): ");
        String dob = sc.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        s.setDateOfBirth(date);
        System.out.print("Student city: ");
        s.setCity(sc.nextLine());
        System.out.print("Student telephone number (+855): ");
        s.setTelephone_number(sc.nextLine());
        System.out.print("Student group name(I4 or T1): ");
        s.setGroupName(sc.nextLine());
        return s;
    }
}

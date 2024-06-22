import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Librarian {
    private List<Object> getDetails() {
        return details;
    }

    private void setDetails(List<Object> details) {
        this.details = details;
    }

    public List<Object> details = new ArrayList<>();
    public static Vector<String> Name = new Vector<>();
    public static Vector<Integer> Age = new Vector<>();
    public static Vector<String> Phone = new Vector<>();
    public static Vector<String> mem_Id = new Vector<>();


    public void REG_mem(String name, int age, String phone_no){
        if (Phone.contains(phone_no)){
            System.out.println("You had already registered");
        }
        else{
            Name.add(name);
            Phone.add(phone_no);
            Age.add(age);
            mem_Id.add(phone_no+age); // mem id is the addition on phone number and age in integer
            System.out.println("member successfully registered with member ID : " + mem_Id.lastElement() );
            System.out.println("---------------------------------");

            member.penalty.put(phone_no , 0);
            member.student.put(phone_no, details);
        }
    }

    public void remove_mem(String phone) {
        if (Phone.contains(phone)) {
            int idx = Phone.indexOf(phone);
            mem_Id.remove(idx);
            Phone.remove(idx);
            Name.remove(idx);
            Age.remove(idx);
        } else {
            System.out.println("No Such Member Exist In The Library");
        }

        member.student.remove(phone);
        member.penalty.remove(phone);
    }

    public static void viewMembers(){
        for (int i = 0; i < mem_Id.size(); i++){
            System.out.println("Name: "+Name.get(i));
            System.out.println("Age: "+Age.get(i));
            System.out.println("Phone: "+Phone.get(i));
            System.out.println("Member ID: "+ mem_Id.get(i));
            System.out.println("---------------------------------");
        }
    }



}

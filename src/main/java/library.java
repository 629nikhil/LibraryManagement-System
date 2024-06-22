import java.util.*;

public class library {
    public static List<Integer> Book_ID = new ArrayList<Integer>();
    public static List<String> Title = new ArrayList<>();
    public static List<String> Author = new ArrayList<>();

    public static List<String> getAuthor() {
        return Author;
    }

    public static void setAuthor(List<String> author) {
        Author = author;
    }
//    public static Vector<Integer> Total = new Vector<>();

    int temp = 1;

    void add_book(String title, String author, int total){

        for (int i = 0 ; i < total; i++){
//            if (Book_ID.contains(book)){  // if book id  is already exist then its copies will be added.
//                int idx = Book_ID.indexOf(book);
//                int old = Total.get(idx);
//                Total.set(idx, old+total);
//            }

                Book_ID.add(temp);
                Author.add(author);
//                Total.add(total);
                Title.add(title);
                temp++;

        }
        System.out.println("Book Added Successfully!..");
        System.out.println("---------------------------------");
    }

    public static void remove_book(int book_id) {
        int temp = Book_ID.indexOf(book_id);
        if (temp != -1) {

                Book_ID.remove(temp);
                Title.remove(temp);
                Author.remove(temp);
//                Total.remove(temp);

        } else {
            System.out.println("Book does not exist.");
        }
    }

    public void viewBooks(){
        if (Title.isEmpty()) System.out.println("No book is present in the library.");
        for (int i = 0; i < Title.size(); i++){
            System.out.println("Name: "+Title.get(i));
            System.out.println("Book ID: "+Book_ID.get(i));
            System.out.println("Author: "+Author.get(i));
            System.out.println("---------------------------------");
        }
    }


}

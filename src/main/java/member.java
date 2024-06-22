import java.util.*;
import java.time.Instant;
import java.time.Duration;
public class member {
    public static List<Object> book_info = new ArrayList<>();
    public List<Object> book_penal = new ArrayList<>();
    public static HashMap<String, List<Object>> student = new HashMap<>();

    private Instant getReturned_time() {
        return Returned_time;
    }

    private void setReturned_time(Instant returned_time) {
        Returned_time = returned_time;
    }

    public HashMap<String, List<Object>> penal = new HashMap<>();

    public static HashMap<String, Integer> penalty = new HashMap<>();



    int temp = 5;

    Instant Issue_time;
    Instant Returned_time;



    void login(String name, String phone_no) {
        if (Librarian.Phone.contains(phone_no) && Librarian.Name.contains(name)) {
            int idx = Librarian.Phone.indexOf(phone_no);
            System.out.println("Welcome " + name + ". Member ID: " + Librarian.mem_Id.get(idx));
            System.out.println("---------------------------------");
            temp = 5;

            // Create a new book list for the member if they haven't logged in before
            if (!student.containsKey(phone_no)) {
                student.put(phone_no, new ArrayList<>());
            }
        } else {
            System.out.println("Member with Name: " + name + " and Phone No: " + phone_no + " doesn't exist.");
            System.out.println("---------------------------------");
            temp = -1;
        }
    }


    public void My_books(String phone) {
        System.out.println("---------------------------------");
        if (student.get(phone).isEmpty()) {
            System.out.println("Don't have any book.");
        } else {
            System.out.println(student.get(phone));
            int temp3 = student.get(phone).size();
            int p = 0;
            int j = 1;
            int k = 2;
            while (k < temp3) {
                System.out.println("Book name: " + student.get(phone).get(p));
                p = p + 4;
                System.out.println("Author name: " + student.get(phone).get(j));
                j = j + 4;
                System.out.println("Book_ID: " + student.get(phone).get(k));
                k = k + 4;
                System.out.println("---------------------------------");
            }
        }
        System.out.println("---------------------------------");
    }

    public int fineAmount = 0;
    int currentamt = -1;

    public void Issue_book(int book_id, String phone) {
        // Calculate the fine amount for the member
        if (student.get(phone) != null && student.get(phone).size() >= 8) {
            System.out.println("You can't issue more than two books.");
            return; // Exit the method without issuing the book
        }
//        System.out.println(fineAmount);
        if (fineAmount > 0) {
            currentamt = -1;
        }
        else currentamt = 0;

        if (currentamt == -1) {
            System.out.println("Please clear the fine of " + fineAmount + " before issuing a book.");
            return; // Exit the method without issuing the book
        }

        if (library.Book_ID.contains(book_id) && currentamt == 0) {
            int id = library.Book_ID.indexOf(book_id);
            String book = library.Title.get(id);
            String title = library.Author.get(id);

            student.computeIfAbsent(phone, k -> new ArrayList<>());

            library.remove_book(book_id);
            Issue_time = Instant.now();

            book_info.add(book);
            book_info.add(title);
            book_info.add(book_id);
            book_info.add(Issue_time);

            student.put(phone, book_info);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void PayFine(String phone) {

//         cal_fine(phone);// Calculate the fine amount for the member
//        System.out.println(fineAmount);
        if (fineAmount > 0) {
            System.out.println("You have to pay: " + fineAmount);

            System.out.println("Please enter the amount: ");
            Scanner scanner = new Scanner(System.in);
            int amt = scanner.nextInt();
            scanner.nextLine();

            if (amt == fineAmount) {
                // Clear the fine by setting it to 0 in the penalty map
//                penalty.put(phone, 0);
                System.out.println("Fine paid successfully.");
                currentamt = 0;
//                System.out.println(fineAmount);
            } else {
                System.out.println("Payment amount does not match the fine.");
            }
        } else {
            System.out.println("No outstanding fine.");
        }
//        System.out.println(fineAmount);
        fineAmount = 0;
    }




    public void return_book(int book, String Phone) {
//        System.out.println(student);
        List<Object> memberBooks = student.get(Phone);
        int ids = memberBooks.indexOf(book);

        if (ids != -1) {
//            System.out.println("Found book with ID: " + book);
//            System.out.println("Title: " + memberBooks.get(ids - 2));
//            System.out.println("Author: " + memberBooks.get(ids - 1));

            String title = (String) memberBooks.get(ids - 2);
            String author = (String) memberBooks.get(ids - 1);
            Returned_time = Instant.now();
//            memberBooks.add(ids+2, Returned_time);
//            System.out.println(student);
            Instant n = (Instant) student.get(Phone).get(ids + 1);
            long secondsDifference = Duration.between(n, Returned_time).getSeconds();
            book_penal.add(secondsDifference);

            penal.put(Phone,book_penal);
//            System.out.println(book_penal);
//            System.out.println(penal);
//            System.out.println(Returned_time);
//            System.out.println(memberBooks);
            memberBooks.remove(ids - 2);
//            System.out.println(memberBooks);
            memberBooks.remove(ids-2);
//            System.out.println(memberBooks);
            memberBooks.remove((Integer) book); // Remove book as Integer to avoid confusion
//            System.out.println(memberBooks);
            memberBooks.remove(ids-2);

            library.Book_ID.add(book);
            library.Author.add(author);
            library.Title.add(title);

            System.out.println("Book returned successfully.");
            Returned_time = Instant.now();
        } else {
            System.out.println("Book not found in member's list.");
        }
        cal_fine(Phone);
    }

    public void cal_fine(String phone) {
        if (fineAmount == 0){
            int size=0;
            if(penal.containsKey(phone)) {
                size = penal.get(phone).size();
            }
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += (int) ((long)penal.get(phone).get(i)-10);
            }
            int fine = sum * 3;
            if (fine > 0) fineAmount = sum;
            else {
                System.out.println("NO fine");
            }

            System.out.println(penalty);
            System.out.println(fineAmount);

        }

//        return sum;
    }
    public static void getAllMembersWithIssuedBooks() {
        System.out.println("Members with Issued Books:");
        System.out.println("---------------------------------");

        for (String phone : student.keySet()) {
            List<Object> books = student.get(phone);

            if (books != null && !books.isEmpty()) {
                System.out.println("Member Phone: " + phone);
                System.out.println("---------------------------------");
                for (int i = 0; i < books.size(); i += 4) {
                    String book = (String) books.get(i);
                    String title = (String) books.get(i + 1);
                    int bookId = (int) books.get(i + 2);
                    Instant issueTime = (Instant) books.get(i + 3);

                    System.out.println("Book Name: " + book);
                    System.out.println("Book Title: " + title);
                    System.out.println("Book ID: " + bookId);
                    System.out.println("Issue Time: " + issueTime);
                    System.out.println("---------------------------------");
                }
            }
            else {
                System.out.println("No member has issued any book");
                System.out.println("---------------------------------");
                System.out.println("Total registered members of the library is: ");
                System.out.println("---------------------------------");
                Librarian.viewMembers();
            }
        }

        System.out.println("---------------------------------");
    }


}

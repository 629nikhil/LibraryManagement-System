import java.beans.Customizer;
import java.util.*;

public class assignment_1 {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("Library Portal Initialized…");
        System.out.println("---------------------------------");
        Librarian Member = new Librarian();

        library lib = new library();

        int var = 0;

        while (true){
            try {
                System.out.println("1. Enter as a librarian");
                System.out.println("2. Enter as a member");
                System.out.println("3. Exit");
                System.out.println("---------------------------------");
                System.out.println("Please enter your choice: ");
                Scanner sc = new Scanner(System.in);
                int a = sc.nextInt();

                if (a == 1) {
                    while (true) {
                        try{
                            System.out.println("1. Register a member");
                            System.out.println("2. Remove a member");
                            System.out.println("3. Add a book");
                            System.out.println("4. Remove a book");
                            System.out.println("5. View all members along with their books");
                            System.out.println("6. View all books");
                            System.out.println("7. Back");
                            System.out.print("Enter your choice: ");

                            Scanner scanner = new Scanner(System.in);
                            int choice = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("---------------------------------");

                            if (choice == 1) {
                                Scanner name = new Scanner(System.in); //System.in is a standard input stream
                                System.out.print("Name :  ");
                                String str = name.nextLine();

                                Scanner age = new Scanner(System.in);
                                System.out.println("Age : ");
                                int Age = age.nextInt();
                                age.nextLine();

                                Scanner phone = new Scanner(System.in);
                                System.out.println("Phone no. : ");
                                String Phone = phone.nextLine();
                                System.out.println("---------------------------------");


                                Member.REG_mem(str, Age, Phone);

                                //                        System.out.println(Librarian.Name);
                                //                        System.out.println(member.Age);
                                //                        System.out.println(Librarian.mem_Id);

                            } else if (choice == 2) {
                                Scanner meMid = new Scanner(System.in);
                                System.out.println("Phone : ");
                                String phone = meMid.nextLine();
                                System.out.println("---------------------------------");

                                Member.remove_mem(phone);

                                System.out.println("Member removed successfully");

                                //                        System.out.println(Librarian.Name);
                                //                        System.out.println(member.Age);
                                //                        System.out.println(Librarian.mem_Id);
                            } else if (choice == 3) {
                                Scanner name = new Scanner(System.in); //System.in is a standard input stream
                                System.out.print(" Book Name :  ");
                                String Book_name = name.nextLine();

                                //                        Scanner Book = new Scanner(System.in);
                                //                        System.out.println("book ID : ");
                                //                        int Book_ID = Book.nextInt();
                                //                        age.nextLine();

                                Scanner author = new Scanner(System.in);
                                System.out.println("Author name : ");
                                String Author = author.nextLine();

                                Scanner total = new Scanner(System.in);
                                System.out.println("Total copies of book : ");
                                int Total = total.nextInt();

                                System.out.println("---------------------------------");

                                lib.add_book(Book_name, Author, Total);

                                //                        System.out.println(library.Author);
                                //                        System.out.println(library.Title);
                                //                        System.out.println(library.Book_ID);
                                //                        System.out.println(library.Total);

                            } else if (choice == 4) {
                                Scanner Book = new Scanner(System.in);
                                System.out.println("book ID : ");
                                int Book_ID = Book.nextInt();

                                library.remove_book(Book_ID);

                                //                        System.out.println(library.Author);
                                //                        System.out.println(library.Title);
                                //                        System.out.println(library.Book_ID);
                                //                        System.out.println(library.Total);

                            } else if (choice == 5) {
                                member.getAllMembersWithIssuedBooks();
                            } else if (choice == 6) {
                                lib.viewBooks();
                            } else if (choice == 7) {
                                break;
                            }

                        }catch (InputMismatchException e){
                            System.out.println("Please enter a valid input");
                        }
                    }

                } else if (a == 2) {
                    System.out.println("---------------------------------");
                    System.out.println("Please enter your details.");
                    Scanner name = new Scanner(System.in); //System.in is a standard input stream
                    System.out.print("Name :  ");
                    String str = name.nextLine();

                    Scanner phone = new Scanner(System.in);
                    System.out.println("Phone no. : ");
                    String Phone = phone.next();
                    System.out.println("---------------------------------");
                    member customer = new member();
                    customer.login(str, Phone);
                    if (customer.temp == -1) continue;

                    while (true) {
                        try {
                            System.out.println("1. List Available Books");
                            System.out.println("2. List My Books");
                            System.out.println("3. Issue Book");
                            System.out.println("4. Return Book");
                            System.out.println("5. Pay Fine");
                            System.out.println("6. Back");
                            System.out.print("Select an option: ");
                            System.out.println("---------------------------------");

                            Scanner scanner = new Scanner(System.in);
                            int choice = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("---------------------------------");

                            if (choice == 1) {
                                lib.viewBooks();
                            } else if (choice == 2) {
                                customer.My_books(Phone);
                            } else if (choice == 3) {

                                //                        System.out.println(library.Title);
                                //                        System.out.println(library.Author);
                                //                        System.out.println(library.Book_ID);

                                Scanner Book = new Scanner(System.in);
                                System.out.println("book ID : ");
                                int Book_ID = Book.nextInt();

                                customer.Issue_book(Book_ID, Phone);

                                //                        System.out.println(customer.student);

                                //                        System.out.println(library.Title);
                                //                        System.out.println(library.Author);
                                //                        System.out.println(library.Book_ID);
                                //                        customer. = new ArrayList<>();

                            } else if (choice == 4) {
                                //                        if (var < 0) System.out.println("You Don't have any book for return");
                                //                        System.out.println(library.Title);
                                //                        System.out.println(library.Author);
                                //                        System.out.println(library.Book_ID);

                                Scanner Book = new Scanner(System.in);
                                System.out.println("book ID : ");
                                int Book_ID = Book.nextInt();

                                //                        System.out.println(library.Book_ID);
                                customer.return_book(Book_ID, Phone);
                                //                        System.out.println(library.Book_ID);

                                //                        System.out.println(library.Title);
                                //                        System.out.println(library.Author);
                                //                        System.out.println(library.Book_ID);

                            } else if (choice == 5) {
                                customer.PayFine(Phone);
                            } else if (choice == 6) {
                                member.book_info = new ArrayList<>();
                                break;
                            }
                        }catch(InputMismatchException e){
                            System.out.println("Please enter a valid input.");
                        }
                    }
                } else if (a == 3) {
                    System.out.println("Thanks for visiting, see you soon");
                    System.out.println("---------------------------------");
                    break;
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a valid input.");
            }

        }
    }
}

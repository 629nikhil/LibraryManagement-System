Name: Nikhil
Roll No.: 2022321
Section: A
Topic: AP-ASSIGNMENT-1


This whole Assignment-1 is a Project which has Build System : Maven
The file pom.xml has all the info regrading the build system and other details.
The main code files are in the folder : /src/main/java/assignment_1



---:Steps to Run The Project:---
1. Compile the whole project using Maven tools  tab in the right corner of IntelliIj.
2. Double-Click on the compile tool it will compile all the project source files.
3. Navigate to the folder which contains all the source code: /src/main/java/AP_A1. It will have three files: "Main,java" , "Librarian.java" ,"Member.java".
4. Now select the file "Main.java".
5. Now run this selected file. This file uses the other two files for the librarian and member functions .

Note : I have imported all the library by just one command i.e import java.util.*; instead of writing individual import commands.


:---Data Structures used:---
The program uses data structures such as List, Map, and arrays to store information about members and books.
:-->I had made 3 clsses as below:
1. Member.java
2. Librarian.java
3. library.java

In Member.java i had created the functions called login, mybooks, issuebooks, retrunbook, cal_fine, payfine, getAllMembersWithIssuedBooks.
In Librarian.java i had created the function called reg_mem, remove_mem, viewMember.
In Library.java i had created the function called addBook, removeBook, viewmember.



:---Description of the Logic used to develop the project:---
I have created three classes : Main , Librarian , Member . Now the main file for overall execution is: Main.java
Rest other files are helper files i.e - are desperate classes having some methods .
Inside the loop, the program presents a user-friendly menu, displaying available options .
The program uses the Scanner class to read the user's choice as a string.
The user's choice is compared using Objects.equals(choice, ...) to determine the action to take based on the selected option.
If the user selects "Enter as a Librarian" (option 1), it creates an instance of the Librarian class, allowing librarians to manage the library.
If the user selects "Enter as a Member" (option 2), it prompts the user to enter their name and phone number and checks if a member with those details exists. If found, the user can interact with their member account.
If the user selects "Exit" (option 3), the loop termination condition is met.
Now after choosing a proper branch the controlled is transfer to the appropriate class which have its methods and thus all functionalities are carried out.
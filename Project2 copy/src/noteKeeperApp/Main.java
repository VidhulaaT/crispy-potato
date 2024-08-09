package noteKeeperApp;

import java.util.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static User userMenu(UserHandler uh){

        int id = 1;

        while(true){
            System.out.println("Add user - 1");
            System.out.println("Delete user - 2");
            System.out.println("Login - 3");
            System.out.println("Display users - 4");
            System.out.println("Exit - 5");

            int input = sc.nextInt();

            switch(input){

                case 1:
                    sc.nextLine();
                    System.out.println("Enter User name :");
                    String name = sc.nextLine();

                    uh.insertUser(id,name);
                    id++;
                    break;

                case 2:
                    System.out.println("Enter user id to delete :");
                    int id1 = sc.nextInt();
                    //sc.nextLine();

                    boolean checkdelete = uh.deleteUser(id1);
                    if(!checkdelete){
                        System.out.println("User doesn't exist ");
                    }
                    break;


                case 3:
                    sc.nextLine();
                    System.out.println("Enter the user id :");
                    int id2 = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the user name :");
                    String name2 = sc.nextLine();

                    User u = uh.userLogin(id2, name2);
                    if(u != null){
                        notesMenu(uh);
//                        System.out.println("Login");
                    }
                    else{
                        System.out.println("Enter valid id and name");
                    }
                    break;


                case 4:
                    uh.displayUsers();
                    break;

                case 5:
                    return null;


            }
        }
    }
    public static void notesMenu(UserHandler u){
        int nid = 1;
        int input;

        while(true){


            System.out.println("Add Notes - 1");
            System.out.println("Edit Notes - 2");
            System.out.println("Delete Notes - 3");
            System.out.println("Display Notes - 4");
            System.out.println("Exit - 5");


            input = sc.nextInt();
            //sc.nextLine();

            switch (input) {


                case 1:
                    sc.nextLine();
                    System.out.println("Enter the Title :");
                    String title = sc.nextLine();

                    System.out.println("Enter the Content :");
                    String cont = sc.nextLine();

                    u.addNote(nid, title, cont);
                    nid++;
                    break;


                case 2:
                    System.out.println("Enter id :");
                    int id2 = sc.nextInt();
                    System.out.println("Edit title - 1");
                    System.out.println("Edit content - 2");
                    System.out.println("Edit both - 3");

                    int inp = sc.nextInt();
                    sc.nextLine();
                    String[] details = new String[2];
                    if (inp == 1 || inp == 3) {
                        System.out.println("Enter new title :");
                        details[0] = sc.nextLine();
                    }
                    if (inp == 2 || inp == 3) {
                        System.out.println("Enter new content :");
                        details[1] = sc.nextLine();
                    }
                    u.edit(inp,id2,details);

                    break;


                case 3:
                    System.out.println("Enter the Note id to delete");
                    int id1 = sc.nextInt();

                    u.delete(id1);
                    break;

                case 4:
                    u.displayNotes();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Enter a valid input ..");
            }

        }
    }




    public static void main(String[] args){
        UserHandler uh = new UserHandler();

        User u = userMenu(uh);

        if(u == null){
            System.out.println("Program terminated ");
        }
    }
}

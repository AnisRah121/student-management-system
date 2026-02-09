package studentDriver;

import java.util.Scanner;

import Entity.Student;
import StudentService.StudentServise;

public class Driver {

    public static void main(String[] args) {

        StudentServise servise = new StudentServise();  
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.println("\n===== WELCOME TO MY SCHOOL =====");
            System.out.println("enter 1 to save the data");	
            System.out.println("enter 2 to update the data");	
            System.out.println("enter 3 to fetch all data");
            System.out.println("enter 4 to delete the data");
            System.out.println("enter 5 to exit");	

            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:  // INSERT
                    System.out.println("enter student id :");
                    int id = sc.nextInt();

                    System.out.println("enter student name :");
                    String name = sc.next();

                    System.out.println("enter student age :");
                    int age = sc.nextInt();

                    Student st = new Student();
                    st.setId(id);
                    st.setName(name);
                    st.setAge(age);

                    int res = servise.save(st);
                    if (res != 0) {
                        System.out.println("data saved");
                    } else {
                        System.out.println("save failed");
                    }
                    break;

                case 2:  // UPDATE
                    System.out.println("enter student id to update :");
                    int uid = sc.nextInt();

                    System.out.println("enter new student name :");
                    String newName = sc.next();

                    System.out.println("enter new student age :");
                    int newAge = sc.nextInt();

                    Student ust = new Student();
                    ust.setId(uid);
                    ust.setName(newName);
                    ust.setAge(newAge);

                    int ures = servise.update(ust);
                    if (ures != 0) {
                        System.out.println("data updated");
                    } else {
                        System.out.println("update failed");
                    }
                    break;
                    
                case 3: // FETCH ALL
                    System.out.println("----- STUDENT LIST -----");
                    for(Student s : servise.fetchAll()) {
                        System.out.println(s);
                    }
                    break;
                	
                case 4: // DELETE
                	System.out.println("enter id to be deleted");
                	int idd = sc.nextInt();
                	int res1 = servise.delete(idd);
                	if(res1 != 0) {
                		System.out.println("data deleted");
                	}else {
                        System.out.println("delete failed");
                    }
                	break;
                	
                case 5: // EXIT
                	if(servise.exitss())
                	{
                		flag = false;
                	}
                	break;

                default:
                    System.out.println("invalid choice");
                    break;
            }
        }
        sc.close();
    }
}

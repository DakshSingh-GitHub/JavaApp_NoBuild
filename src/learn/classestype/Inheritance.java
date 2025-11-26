package learn.classestype;
// Inheritance increases the reusability of code, the class which has properties is the "parent" class and the class which inherits those properties is the "child" class.
// Types of Inheritance: Single Inheritance, Multilevel Inheritance, Hierarchical Inheritance, Multiple Inheritance (not supported in Java using classes).

// Single Inheritance Example:
class School {
    String school_name;
    String school_address;

    public void displaySchoolInfo() {
        System.out.println("School Name: " + school_name);
        System.out.println("School Address: " + school_address);
    }
}

class Teacher extends School {
    String teacher_name;
    String subject;
    String teacher_id;
    String teacher_address;

    public void displayInfo() {
        System.out.println("School Name: " + school_name);
        System.out.println("School Address: " + school_address);
        System.out.println("Teacher Name: " + teacher_name);
        System.out.println("Subject: " + subject);
        System.out.println("Teacher ID: " + teacher_id);
        System.out.println("Teacher Address: " + teacher_address);
    }
}

// Multilevel Inheritance Example:

class AssistantTeacher extends Teacher {
    String assistant_id;
    String assistant_name;
    // Can assign which teacher they assist
}

// Hierarchical Inheritance Example:

class Student extends School {
    String student_name;
    String student_id;
    String student_address;
    // Can assign which class they belong to
}

public class Inheritance {
    public static void main(String[] args) {
        Teacher natthu = new Teacher();
        natthu.school_name = "ABC High School";
        natthu.school_address = "123 Main St";
        natthu.teacher_name = "Natthu Kumar";
        natthu.subject = "Mathematics";
        natthu.teacher_id = "T001";
        natthu.teacher_address = "456 Elm St";
        // natthu.displayInfo();
        natthu.displaySchoolInfo();
    }
}

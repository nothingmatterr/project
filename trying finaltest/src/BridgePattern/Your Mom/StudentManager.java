import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        studentList = new MyLinkedList();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        this.studentList.append(student);

    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        this.studentList.insert(student, index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        this.studentList.remove(index);
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return (Student) this.studentList.get(index);
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán tăng dần.
     * @return
     */
    public MyList sortMathsGradeIncreasing() {
        int n = studentList.size();
        Student temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(((Student)studentList.get(j-1)).getMathsGrade() > ((Student)studentList.get(j)).getMathsGrade()){
                    //swap elements
                    temp = (Student)studentList.get(j-1);
                    studentList.set(studentList.get(j), j-1);
                    studentList.set(temp, j);
                }
            }
        }
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán giảm dần.
     * @return
     */
    public MyList sortMathsGradeDecreasing() {
        int n = studentList.size();
        Student temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(((Student)studentList.get(j-1)).getMathsGrade() < ((Student)studentList.get(j)).getMathsGrade()){
                    //swap elements
                    temp = (Student)studentList.get(j-1);
                    studentList.set(studentList.get(j), j-1);
                    studentList.set(temp, j);
                }
            }
        }
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình tăng dần.
     * @return
     */
    public MyList sortAverageGradeIncreasing() {
        /* TODO */
        int n = studentList.size();
        Student temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(((Student)studentList.get(j-1)).getAverageGrade() > ((Student)studentList.get(j)).getAverageGrade()){
                    //swap elements
                    temp = (Student)studentList.get(j-1);
                    studentList.set(studentList.get(j), j-1);
                    studentList.set(temp, j);
                }
            }
        }
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình giảm dần.
     * @return
     */
    public MyList sortAverageGradeDecreasing() {
        /* TODO */
        int n = studentList.size();
        Student temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(((Student)studentList.get(j-1)).getAverageGrade() < ((Student)studentList.get(j)).getAverageGrade()){
                    //swap elements
                    temp = (Student)studentList.get(j-1);
                    studentList.set(studentList.get(j), j-1);
                    studentList.set(temp, j);
                }
            }
        }
        return studentList;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán cao nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestMathsGrade(int howMany) {
        /* TODO */
        MyList res = sortMathsGradeDecreasing();
        if (res.size() > 0) {
            return (MyList) res.get(0);
        } else {
            return null; // or throw an exception
        }
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán thấp nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestMathsGrade(int howMany) {
        /* TODO */
        MyList res = sortMathsGradeIncreasing();
        if (res.size() > 0) {
            return (MyList) res.get(0);
        } else {
            return null; // or throw an exception
        }
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình cao nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestAverageGrade(int howMany) {
        /* TODO */
        MyList res = sortAverageGradeDecreasing();
        if (res.size() > 0) {
            return (MyList) res.get(0);
        } else {
            return null; // or throw an exception
        }
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình thấp nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestAverageGrade(int howMany) {
        /* TODO */
        MyList res = sortAverageGradeIncreasing();
        if (res.size() > 0) {
            return (MyList) res.get(0);
        } else {
            return null; // or throw an exception
        }
    }

    public static String idOfStudentsToString(MyList studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        MyIterator it = studentList.Iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(MyList studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        MyIterator it = studentList.Iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }

}
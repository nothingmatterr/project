import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        testOriginalData();
        /*
        TODO

        - Viết code để test cho tất cả các hàm bên dưới.
        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_CandidateManager>.txt (Ví dụ, NguyenVanA_123456_CandidateManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_CandidateManager>.zip (Ví dụ, NguyenVanA_123456_CandidateManager.zip),
        nộp lên classroom.
         */
        testFilterStudentsHighestMathsGrade();
        testFilterStudentsLowestMathsGrade();
        testFilterStudentsHighestAverageGrade();
        testFilterStudentsLowestAverageGrade();
        testSortMathsGradeIncreasing();
        testSortMathsGradeDecreasing();
        testSortAverageGradeIncreasing();
        testSortAverageGradeDecreasing();

    }

    public static void init() {
        String filePath = "C:\\Users\\Laptop K1\\IdeaProjects\\Main\\OOP\\src\\Cac_De_OOP_CK\\StudentManager2\\students.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                Student student = new Student(
                        dataList.get(0), // id
                        dataList.get(1), // lastname
                        dataList.get(2), // firstname
                        Integer.parseInt(dataList.get(3)), // yearOfBirth
                        Double.parseDouble(dataList.get(4)), // mathsGrade
                        Double.parseDouble(dataList.get(5)), // physicsGrade
                        Double.parseDouble(dataList.get(6)) // chemistryGrade
                );
                StudentManager.getInstance().append(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        init();
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        System.out.println("\nTesting sort by maths grade in increasing order:");




        // Get the list of students
        MyList students = StudentManager.getInstance().getStudentList();

        // Sort the students by maths grade in increasing order using bubble sort
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (((Student)students.get(j)).getMathsGrade() > ((Student)students.get(j + 1)).getMathsGrade()) {
                    // Swap students[j+1] and students[i]
                    Student temp = (Student)students.get(j);
                    students.set((Student)students.get(j + 1), j);
                    students.set(temp, j + 1);
                }
            }
        }

        // Print the sorted list of students
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstname() + " " + student.getLastname() + ", Maths Grade: " + student.getMathsGrade());
        }
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        System.out.println("\nTesting sort by maths grade in decreasing order:");

        MyList students = StudentManager.getInstance().getStudentList();
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (((Student)students.get(j)).getMathsGrade() < ((Student)students.get(j + 1)).getMathsGrade()) {
                    Student temp = (Student)students.get(j);
                    students.set((Student)students.get(j + 1), j);
                    students.set(temp, j + 1);
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstname() + " " + student.getLastname() + ", Maths Grade: " + student.getMathsGrade());
        }
    }

    public static void testSortAverageGradeIncreasing() {
        /* TODO */
        System.out.println("\nTesting sort by average grade in increasing order:");

        MyList students = StudentManager.getInstance().getStudentList();
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (((Student)students.get(j)).getAverageGrade() > ((Student)students.get(j + 1)).getAverageGrade()) {
                    Student temp = (Student)students.get(j);
                    students.set((Student)students.get(j + 1), j);
                    students.set(temp, j + 1);
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstname() + " " + student.getLastname() + ", Average Grade: " + student.getAverageGrade());
        }
    }

    public static void testSortAverageGradeDecreasing() {
        /* TODO */
        System.out.println("\nTesting sort by average grade in decreasing order:");

        MyList students = StudentManager.getInstance().getStudentList();
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (((Student)students.get(j)).getAverageGrade() < ((Student)students.get(j + 1)).getAverageGrade()) {
                    Student temp = (Student)students.get(j);
                    students.set((Student)students.get(j + 1), j);
                    students.set(temp, j + 1);
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstname() + " " + student.getLastname() + ", Average Grade: " + student.getAverageGrade());
        }
    }

    public static void testFilterStudentsHighestMathsGrade() {
        /* TODO */
        System.out.println("\nTesting filter students with highest maths grade:");

        MyList students = StudentManager.getInstance().getStudentList();
        double highestMathsGrade = 0;
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            if (student.getMathsGrade() > highestMathsGrade) {
                highestMathsGrade = student.getMathsGrade();
            }
        }
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            if (student.getMathsGrade() == highestMathsGrade) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstname() + " " + student.getLastname() + ", Maths Grade: " + student.getMathsGrade());
            }
        }
    }

    public static void testFilterStudentsLowestMathsGrade() {
        /* TODO */
        System.out.println("\nTesting filter students with lowest maths grade:");
        MyList students = StudentManager.getInstance().getStudentList();
        double lowestMathsGrade = 10;
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            if (student.getMathsGrade() < lowestMathsGrade) {
                lowestMathsGrade = student.getMathsGrade();
            }
        }
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            if (student.getMathsGrade() == lowestMathsGrade) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstname() + " " + student.getLastname() + ", Maths Grade: " + student.getMathsGrade());
            }
        }
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        System.out.println("\nTesting filter students with highest average grade:");

        MyList students = StudentManager.getInstance().getStudentList();
        double highestAverageGrade = 0;
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            if (student.getAverageGrade() > highestAverageGrade) {
                highestAverageGrade = student.getAverageGrade();
            }
        }
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            if (student.getAverageGrade() == highestAverageGrade) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstname() + " " + student.getLastname() + ", Average Grade: " + student.getAverageGrade());
            }
        }
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        System.out.println("\nTesting filter students with lowest average grade:");
        MyList students = StudentManager.getInstance().getStudentList();
        double lowestAverageGrade = 999;
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            if (student.getAverageGrade() < lowestAverageGrade) {
                lowestAverageGrade = student.getAverageGrade();
            }
        }
        for (int i = 0; i < students.size(); i++) {
            Student student = (Student)students.get(i);
            if (student.getAverageGrade() == lowestAverageGrade) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstname() + " " + student.getLastname() + ", Average Grade: " + student.getAverageGrade());
            }
        }
    }

}

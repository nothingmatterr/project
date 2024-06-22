public class Student {
    private String id;
    private String lastname;
    private String firstname;
    private int yearOfBirth;
    private double mathsGrade;
    private double physicsGrade;
    private double chemistryGrade;

    private Student() {}

    public Student(String id, String lastname, String firstname, int yearOfBirth, double mathsGrade, double physicsGrade, double chemistryGrade) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.yearOfBirth = yearOfBirth;
        this.mathsGrade = mathsGrade;
        this.physicsGrade = physicsGrade;
        this.chemistryGrade = chemistryGrade;
    }

    public static class StudentBuilder {
        private String id;
        private String lastname;
        private String firstname;
        private int yearOfBirth;
        private double mathsGrade;
        private double physicsGrade;
        private double chemistryGrade;

        public StudentBuilder(String id) {
            this.id = id;
        }

        public StudentBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public StudentBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public StudentBuilder withYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public StudentBuilder withMathsGrade(double mathsGrade) {
            this.mathsGrade = mathsGrade;
            return this;
        }

        public StudentBuilder withPhysicsGrade(double physicsGrade) {
            this.physicsGrade = physicsGrade;
            return this;
        }

        public StudentBuilder withChemistryGrade(double chemistryGrade) {
            this.chemistryGrade = chemistryGrade;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.id = this.id;
            student.lastname = this.lastname;
            student.firstname = this.firstname;
            student.yearOfBirth = this.yearOfBirth;
            student.mathsGrade = this.mathsGrade;
            student.physicsGrade = this.physicsGrade;
            student.chemistryGrade = this.chemistryGrade;
            return student;
        }
    }

    public String getId() {
        return this.id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    public double getMathsGrade() {
        return this.mathsGrade;
    }

    public double getPhysicsGrade() {
        return this.physicsGrade;
    }

    public double getChemistryGrade() {
        return this.chemistryGrade;
    }

    public double getAverageGrade() {
        return (this.mathsGrade + this.physicsGrade + this.chemistryGrade) / 3;
    }
}
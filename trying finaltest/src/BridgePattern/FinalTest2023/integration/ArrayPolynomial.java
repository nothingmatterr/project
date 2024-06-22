package BridgePattern.FinalTest2023.integration;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is not bound");
        }
        return coefficents[index];
    }
    public ArrayPolynomial(double[] coefficents) {
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
        for (double coeficient0 : coefficents) {
            append(coeficient0);
        }
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] coefficient0 = new double[size];
        for (int i = 0; i < coefficents.length; i++) {
            coefficient0[i] = coefficient(i);
        }
        return coefficient0;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        /* TODO */
        if (coefficents.length == size) {
            enlarge();
        }
        coefficents[size] = coefficient;
        size++;
        return this;

    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > coefficents.length) {
            throw new IndexOutOfBoundsException("Index is not bound");
        }
        if (size == coefficents.length) {
            enlarge();
        }
        for (int i = index; i < size ;i++) {
            coefficents[i + 1] = coefficents[i];
        }
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > coefficents.length) {
            throw new IndexOutOfBoundsException("Index is not bound");
        }
        coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients().length - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double sum = 0.0;
        for (int i = coefficents.length -1  ; i >= 0 ; i++) {
            sum +=  coefficents[i] * x + sum;
        }
        return sum;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        return new ArrayPolynomial(differentiate());
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        int degree1 = degree();
        int degrer2 = another.degree();
        int degree = Math.max(degree1, degrer2);
        double[] coefficient0 = new double[degree + 1];
        for (int i = 0; i <= degree1; i++) {
            coefficient0[i] += (i <= degree1)? this.coefficient(i):0;
            coefficient0[i] += (i <= degree1)? another.coefficient(i) :0;
        }
        ArrayPolynomial plusPolunomial = new ArrayPolynomial(coefficient0);
        return plusPolunomial;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        int degree1 = degree();
        int degrer2 = another.degree();
        int degree = Math.max(degree1, degrer2);
        double[] coefficient0 = new double[degree + 1];
        for (int i = 0; i <= degree1; i++) {
            coefficient0[i] += (i <= degree1)? this.coefficient(i) : 0;
            coefficient0[i] -= (i <= degree1)? another.coefficient(i) : 0;
        }
        ArrayPolynomial minusPolunomial = new ArrayPolynomial(coefficient0);
        return minusPolunomial;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        int degree1 = degree();
        int degree2 = another.degree();
        int degree = degree2 + degree1;
        double[] coefficient0 = new double[degree + 1];
        for (int i = 0; i <= degree; ) {

        }
        return null;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        double[] coefficent0 = new double[size * 2]; // cách mở rộng kiểu dữ liệu của arraylist(vector)
        for (int i = 0; i < size * 2; i++) {
            coefficent0[i] = coefficents[i];
        }
        coefficents = coefficent0;
    }
}

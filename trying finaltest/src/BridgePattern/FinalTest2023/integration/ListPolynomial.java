package BridgePattern.FinalTest2023.integration;

import java.util.LinkedList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        this.coefficients = new LinkedList<Double>();
    }
    public ListPolynomial(double[] coefficients) {
        this.coefficients = new LinkedList<Double>();
        for (double coefficient : coefficients) {
            append(coefficient);
        }
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
         return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] coefficient0 = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            coefficient0[i] = coefficients.get(i);
        }
        return coefficient0;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        /* TODO */
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        coefficients.set(index,coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double sum = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            sum += x * coefficient(i) + sum;
        }
        return sum;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        return new ListPolynomial(differentiate());

    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        int degree1 = this.degree();
        int degree2 = another.degree();
        int degree = Math.max(degree1, degree2);
        double[] plusPolynomial = new double[degree + 1];
        for (int i = 0 ; i <= degree; i++) {
            plusPolynomial[i] = (i <= degree)? + coefficient(i) : 0;
            plusPolynomial[i] = (i <= degree)? + another.coefficient(i) : 0;
        }
        ListPolynomial listPolynomial = new ListPolynomial(plusPolynomial);
        return listPolynomial;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        return null;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        return null;
    }
}

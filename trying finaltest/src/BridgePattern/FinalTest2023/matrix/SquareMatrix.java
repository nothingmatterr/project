package BridgePattern.FinalTest2023.matrix;

import java.util.ArrayList;
import java.util.Collections;

public class SquareMatrix {
    private int[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    public SquareMatrix(int size) {
        initRandom(size);
    }
    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    private void initRandom(int size) {
        /* TODO */
        data = new int[size][size];
        for (int i = 0; i < size -1; i++) {
            for (int j = 0 ; j < size  - 1; j++) {
                data[i][j] = (int)(Math.random() *99 + 1);
            }
        }
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public int[] principalDiagonal() {
        /* TODO */
        int[] mainDiagonal = new int[data.length];
        for (int i = 0; i < data.length ; i++) {
            mainDiagonal[i] = data[i][i];
        }
        return mainDiagonal;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public int[] secondaryDiagonal() {
        /* TODO */
        int[] antidiagonal = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            antidiagonal[i] = data[i][data.length - i - 1];
        }
        return antidiagonal;
    }

    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     * @return các số nguyên tố trong ma trận.
     */
    public int[] primes() {
        /* TODO */
        ArrayList<Integer> primesNumber = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (isPrime(data[i][j])) {
                    primesNumber.add(data[i][j]);
                }
            }
        }
        int[] a = new int[primesNumber.size()];
        for (int i = 0; i < primesNumber.size(); i++) {
            a[i] = primesNumber.get(i);
        }
        return a;
    }
    public boolean isPrime(int a) {
        if (a < 2 ) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public SquareMatrix getSortedMatrix() {
        /* TODO */
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                array.add(data[i][j]);
            }
        }
        Collections.sort(array);
        int[][] sortedMatrix = new int[data.length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                sortedMatrix[i][j] = array.get(i * data.length + j);
            }
        }
        setData(sortedMatrix);
        return this;
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public int get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, int value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public SquareMatrix add(SquareMatrix that) {
        /* TODO */
        int[][] thatMatrix = that.getData();
        int[][] addMatrix = new int[data.length][data.length];
        if (thatMatrix.length != data.length) {
            System.out.println("Matrix must equal dim");
            return null;
        }
        else {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    addMatrix[i][j] = thatMatrix[i][j] + data[i][j];
                }
            }
            setData(addMatrix);
            return this;
        }
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public SquareMatrix minus(SquareMatrix that) {
        /* TODO */
        int[][] thatMatrix = that.getData();
        int[][] minusMatrix = new int[data.length][data.length];
        if (thatMatrix.length != data.length) {
            System.out.println("Matrix must equal dim");
            return null;
        }
        else {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    minusMatrix[i][j] = data[i][j] - minusMatrix[i][j];
                }
            }
            setData(minusMatrix);
            return this;
        }
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public SquareMatrix multiply(SquareMatrix that) {
        /* TODO */
        int[][] thatMatrix = that.getData();
        int[][] multiplyMatrix = new int[data.length][data.length];
        if (thatMatrix.length != data.length) {
            System.out.println("Matrix must equal dim");
            return null;
        }
        for (int i = 0 ; i < data.length; i++) {
            for (int j = 0 ; j < data.length; j++) {
                multiplyMatrix[i][j] = thatMatrix[i][j] * data[i][j];
            }
        }
        setData(multiplyMatrix);
        return this;
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public SquareMatrix scaled(int value) {
        /* TODO */
        int[][] scaledMatrix = new int[data.length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                scaledMatrix[i][j] = value * data[i][j];
            }
        }
        setData(scaledMatrix);
        return this;
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public SquareMatrix transpose() {
        /* TODO */
        int[][] transposeMatrix = new int[data.length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                transposeMatrix[i][j] = data[j][i];
            }
        }
        setData(transposeMatrix);
        return this;
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn ma trận, ví dụ
     *   1 2 3
     *   4 5 6
     *   7 8 9
     * @return một chuỗi mô tả ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                sb.append(String.format("%-5d ", data[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

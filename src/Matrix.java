
import java.util.ArrayList;

public class Matrix {

    private ArrayList<ArrayList<Double>> matrix;
    private int length;
    private Double noAdjacencyValue = Double.POSITIVE_INFINITY;

    /**
     * Instantiates a matrix with length 1
     */
    public Matrix() {
        this.matrix = new ArrayList<>();
        this.matrix.add(new ArrayList<>());
        this.matrix.get(0).add(0.0);
        this.length = getMatrixSize();
    }

    /**
     * Instantiates a matrix with pre determined length
     */
    public Matrix(int size) {
        this.matrix = new ArrayList<>();
        this.matrix.add(new ArrayList<>());
        this.matrix.get(0).add(0.0);
        this.length = getMatrixSize();
        upSize(size - 1);
    }

    /**
     * Gets value from position (X, Y)
     *
     * @param x | Position of X Axis on the matrix
     * @param y | Position of Y Axis on the matrix
     * @return
     */
    public Double getValueFrom(int x, int y) {
        return matrix.get(y).get(x);
    }

    /**
     * Gets the value that represents that there is no adjacency
     *
     * @return the value
     */
    public Double getNoAdjacencyValue() {
        return this.noAdjacencyValue;
    }

    /**
     * Gets all adjacencies from y axis
     *
     * @param y The position of the Y axis
     * @return The number of adjacencies
     */
    public int getAdjacenciesCountFrom(int y) {
        int cont = 0;
        for (int x = 0; x < getMatrixSize(); x++) {
            Double value = matrix.get(y).get(x);
            if (value != getNoAdjacencyValue() && value != 0) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Gets adjacency value from specified position
     *
     * @return value
     */
    public Double getAdjacencyOf(int y, int x) {
        return matrix.get(y).get(x);
    }

    /**
     * Gets matrix size
     *
     * @return matrix size
     */
    public int getMatrixSize() {
        return matrix.size();
    }

    /**
     * Sets the value that represents no adjacency in the matrix
     *
     * @param value
     */
    public void setNoAdjacencyValue(Double value) {
        updateNoAdjacencyValue(value);
        this.noAdjacencyValue = value;
    }

    /**
     * Sets a specified value on a specified (X, Y) coordinate
     *
     * @param x     | X Axis
     * @param y     | Y Axis
     * @param value The value of the adjacency
     */
    public void setOn(int x, int y, Double value) {
        matrix.get(y).set(x, value);
    }

    /**
     * Set adjacency between the coordinates
     *
     * @param x     | X Axis
     * @param y     | Y Axis
     * @param value The value of the adjacency
     */
    public void setAdjacencyOn(int x, int y, Double value) {
        if (x != y) {
            matrix.get(y).set(x, value);
            matrix.get(x).set(y, value);
        }
    }

    /**
     * Increments the size of the matrix by one
     */
    public void upSize() {
        ArrayList<Double> aux = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            aux.add(noAdjacencyValue);
        }
        length++;
        matrix.add(aux);

        for (int i = 0; i < length; i++) {
            matrix.get(i).add(noAdjacencyValue);
        }
        matrix.get(length - 1).set(length - 1, 0.0);
    }

    /**
     * Increments the size of the matrix by a specified value
     *
     * @param length Total of times the matrix will be incremented
     */
    public void upSize(int length) {
        for (int i = 0; i < length; i++) {
            upSize();
        }
    }

    /**
     * Resets every adjacency on the matrix
     */
    public void resetAdjacency() {
        for (int i = 0; i < getMatrixSize(); i++) {
            for (int j = 0; j < getMatrixSize(); j++) {
                if (matrix.get(i).get(j) != 0.0) {
                    matrix.get(i).set(j, noAdjacencyValue);
                }
            }
        }
    }

    /**
     * removes adjacency from specified coordinates
     * @param x | X Axis
     * @param y | Y Axis
     */
    public void removeAdjacencyOn(int x, int y) {
        matrix.get(y).set(x, noAdjacencyValue);
    }

    /**
     * resets ENTIRE matrix
     */
    public void reset() {
        this.matrix = new ArrayList<>();
        this.matrix.add(new ArrayList<>());
        this.matrix.get(0).add(noAdjacencyValue);
        this.length = 0;
    }

    /**
     * updates the old value of noAdjacencyValue with the new one
     * @param newValue new value of noAdjacencyValue
     */
    private void updateNoAdjacencyValue(Double newValue) {
        Double oldValue = this.noAdjacencyValue;
        for(int i = 0; i < getMatrixSize(); i++) {
            for(int j = 0; j < getMatrixSize(); j++) {
                if(matrix.get(j).get(i) == oldValue) {
                    matrix.get(j).set(i, newValue);
                }
            }
        }
    }

    /**
     * prints matrix
     */
    public void print() {
        System.out.printf("length: %d\n", length);
        String numberTable = "| + | ";
        for (int i = 0; i < getMatrixSize(); i++) {
            numberTable += i + " | ";
        }
        System.out.println(numberTable);
        for (int i = 0; i < matrix.size(); i++) {
            System.out.printf("| %d | ", i);
            for (int j = 0; j < matrix.get(i).size(); j++) {
                Double value = matrix.get(i).get(j);
                if (value == noAdjacencyValue) {
                    System.out.printf("x | ");
                } else {
                    System.out.printf("%.0f | ", value);
                }
            }
            System.out.println();
        }
    }

}

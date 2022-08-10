
import java.util.ArrayList;

public class Matrix {

    private ArrayList<ArrayList<Double>> matriz;
    private int length;
    private Double valorAdjacencia = Double.POSITIVE_INFINITY;

    /**
     * Instantiates a matrix with length 1
     */
    public Matrix() {
        this.matriz = new ArrayList<>();
        this.matriz.add(new ArrayList<>());
        this.matriz.get(0).add(0.0);
        this.length = getMatrixSize();
    }

    /**
     * Instantiates a matrix with pre determined length
     */
    public Matrix(int size) {
        this.matriz = new ArrayList<>();
        this.matriz.add(new ArrayList<>());
        this.matriz.get(0).add(0.0);
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
    public Double getValores(int x, int y) {
        return matriz.get(y).get(x);
    }

    /**
     * Gets the value that represents that there is no adjacency
     *
     * @return the value
     */
    public Double getValorAdjacencia() {
        return this.valorAdjacencia;
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
            Double value = matriz.get(y).get(x);
            if (value != getValorAdjacencia() && value != 0) {
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
        return matriz.get(y).get(x);
    }

    /**
     * Gets matrix size
     *
     * @return matrix size
     */
    public int getMatrixSize() {
        return matriz.size();
    }

    /**
     * Sets the value that represents no adjacency in the matrix
     *
     * @param value
     */
    public void setValorAdjacencia(Double value) {
        updateValorAdjacencia(value);
        this.valorAdjacencia = value;
    }

    /**
     * Sets a specified value on a specified (X, Y) coordinate
     *
     * @param x     | X Axis
     * @param y     | Y Axis
     * @param value The value of the adjacency
     */
    public void setOn(int x, int y, Double value) {
        matriz.get(y).set(x, value);
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
            matriz.get(y).set(x, value);
            matriz.get(x).set(y, value);
        }
    }

    /**
     * Increments the size of the matrix by one
     */
    public void upSize() {
        ArrayList<Double> aux = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            aux.add(valorAdjacencia);
        }
        length++;
        matriz.add(aux);

        for (int i = 0; i < length; i++) {
            matriz.get(i).add(valorAdjacencia);
        }
        matriz.get(length - 1).set(length - 1, 0.0);
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
                if (matriz.get(i).get(j) != 0.0) {
                    matriz.get(i).set(j, valorAdjacencia);
                }
            }
        }
    }

    /**
     * removes adjacency from specified coordinates
     * @param x | X Axis
     * @param y | Y Axis
     */
    public void removeAdjacencia(int x, int y) {
        matriz.get(y).set(x, valorAdjacencia);
    }

    /**
     * resets ENTIRE matrix
     */
    public void reset() {
        this.matriz = new ArrayList<>();
        this.matriz.add(new ArrayList<>());
        this.matriz.get(0).add(valorAdjacencia);
        this.length = 0;
    }

    /**
     * updates the old value of noAdjacencyValue with the new one
     * @param newValue new value of noAdjacencyValue
     */
    private void updateValorAdjacencia(Double newValue) {
        Double oldValue = this.valorAdjacencia;
        for(int i = 0; i < getMatrixSize(); i++) {
            for(int j = 0; j < getMatrixSize(); j++) {
                if(matriz.get(j).get(i) == oldValue) {
                    matriz.get(j).set(i, newValue);
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
        for (int i = 0; i < matriz.size(); i++) {
            System.out.printf("| %d | ", i);
            for (int j = 0; j < matriz.get(i).size(); j++) {
                Double value = matriz.get(i).get(j);
                if (value == valorAdjacencia) {
                    System.out.printf("x | ");
                } else {
                    System.out.printf("%.0f | ", value);
                }
            }
            System.out.println();
        }
    }

}

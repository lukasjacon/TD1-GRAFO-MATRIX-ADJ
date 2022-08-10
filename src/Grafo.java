
import java.util.ArrayList;

public class Grafo {

    private ArrayList<Nodes> nodes;
    private Matriz matriz;

    // Esse é o grafo
    public Grafo() {
        nodes = new ArrayList<>();
        matriz = new Matriz();
    }

    public Grafo(int nodeQuantity) {
        nodeQuantity--;
        nodes = new ArrayList<>();
        matriz = new Matriz();
        for(int i = 0; i < nodeQuantity; i++) {
            addNode();
        }
    }

    public void addNode() {
        nodes.add(new Nodes());
        matriz.upSize();
    }

    public void cria_adjacencia(int i, int j, int P) {
        matriz.setAdjacencyOn(i, j, (double)P);
    }

    public void remove_adjacencia(int i, int j) {
        matriz.removeAdjacencia(i, j);
    }

    public void imprime_adjacencias() {
        matriz.print();
    }

    public void seta_informacao(int i, String V) {
        nodes.get(i).setValue(V);
    }

    public int adjacentes(int i/*, adj*/) {
        return matriz.getAdjacenciesCountFrom(i);
    }

}

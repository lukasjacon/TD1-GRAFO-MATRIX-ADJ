
import java.util.ArrayList;

public class Grafo {

    private ArrayList<No> Nos;
    private Matriz matriz;

    // Esse é o grafo
    public Grafo() {
        Nos = new ArrayList<>();
        matriz = new Matriz();
    }

    public Grafo(int quantidadeNos) {
        quantidadeNos--;
        Nos = new ArrayList<>();
        matriz = new Matriz();
        for(int i = 0; i < quantidadeNos; i++) {
            adicionaNo();
        }
    }

    public void adicionaNo() {
        Nos.add(new No());
        matriz.upSize();
    }

    public void cria_adjacencia(int i, int j, int P) {
        matriz.adjacencia(i, j, (double)P);
    }

    public void remove_adjacencia(int i, int j) {
        matriz.removeAdjacencia(i, j);
    }

    public void imprime_adjacencias() {
        matriz.print();
    }

    public void seta_informacao(int i, String V) {
        Nos.get(i).setValor(V);
    }

    public int adjacentes(int i/*, adj*/) {
        return matriz.quantidadeAdjacencias(i);
    }

}

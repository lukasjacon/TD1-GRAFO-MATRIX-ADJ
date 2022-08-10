
public class Main {

    public static void main(String[] args) {
        Graph grafo = new Graph(5);
        grafo.cria_adjacencia(4, 3, 2);
        grafo.cria_adjacencia(4, 2, 9);
        grafo.imprime_adjacencias();

        System.out.printf("Adjacências em %d: %d\n", 4,grafo.adjacentes(4));
        System.out.printf("Adjacências em %d: %d\n", 2,grafo.adjacentes(2));
    }

}

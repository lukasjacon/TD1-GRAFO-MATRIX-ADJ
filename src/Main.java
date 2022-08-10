
public class Main {

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        grafo.cria_adjacencia(4, 3, 2);
        grafo.cria_adjacencia(4, 2, 9);
        grafo.imprime_adjacencias();

        System.out.printf("Total adjacencies na linha %d: %d\n", 4,grafo.adjacentes(4));
        System.out.printf("Total adjacencies na linha %d: %d\n", 2,grafo.adjacentes(2));
    }

}

package guloso;

import java.util.Arrays;

public class Guloso {
    public static int darTroco(int quantia, int[] moedas) {
        // Ordenar as moedas em ordem decrescente
        Arrays.sort(moedas);// ordenan
        int numMoedas = 0;
        int index = moedas.length - 1;

        // Iterar sobre as moedas e dar o troco
        while (quantia > 0 && index >= 0) {
            if (moedas[index] <= quantia) {
                int numMoedasDessaDenominacao = quantia / moedas[index];
                numMoedas += numMoedasDessaDenominacao;
                quantia -= numMoedasDessaDenominacao * moedas[index];
            }
            index--;
        }
        return numMoedas;
    }

    public static void main(String[] args) {
        int quantia = 18;
        int[] moedas = { 5, 2, 1 };
        System.out.println("Número mínimo de moedas necessário para dar troco: " + darTroco(quantia, moedas));
    }
}

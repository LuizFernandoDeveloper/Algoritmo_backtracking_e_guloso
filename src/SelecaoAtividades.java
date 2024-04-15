public class App {

import java.util.*;

class Atividade {
    int inicio, fim;

    public Atividade(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
}

public class SelecaoAtividades {
    public static List<Atividade> selecionarAtividades(List<Atividade> atividades) {
        List<Atividade> selecionadas = new ArrayList<>();
        if (atividades.isEmpty())
            return selecionadas;

        // Ordena as atividades pelo tempo de fim
        Collections.sort(atividades, Comparator.comparingInt(a -> a.fim));

        // A primeira atividade sempre será selecionada
        selecionadas.add(atividades.get(0));

        // Inicializa o tempo de fim da última atividade selecionada
        int fimUltimaSelecionada = atividades.get(0).fim;

        // Percorre as atividades e seleciona aquelas que não se sobrepõem
        for (int i = 1; i < atividades.size(); i++) {
            if (atividades.get(i).inicio >= fimUltimaSelecionada) {
                selecionadas.add(atividades.get(i));
                fimUltimaSelecionada = atividades.get(i).fim;
            }
        }
        return selecionadas;
    }

    public static void main(String[] args) {
        List<Atividade> atividades = new ArrayList<>();
        atividades.add(new Atividade(1, 4));
        atividades.add(new Atividade(3, 5));
        atividades.add(new Atividade(0, 6));
        atividades.add(new Atividade(5, 7));
        atividades.add(new Atividade(3, 8));
        atividades.add(new Atividade(5, 9));
        atividades.add(new Atividade(6, 10));
        atividades.add(new Atividade(8, 11));
        atividades.add(new Atividade(8, 12));
        atividades.add(new Atividade(2, 13));
        atividades.add(new Atividade(12, 14));

        List<Atividade> selecionadas = selecionarAtividades(atividades);
        System.out.println("Atividades selecionadas:");
        for (Atividade atividade : selecionadas) {
            System.out.println("Inicio: " + atividade.inicio + ", Fim: " + atividade.fim);
        }
    }

}

}

import java.util.Random;

public class Tabuleiro {

    private char[][] tabuleiro = new char[8][8];
    private int[] posicaoTesouro;

    private void adicionarTesouro() {
        Random rand = new Random();
        int linha,coluna;

        do {
            linha = rand.nextInt(8);
            coluna = rand.nextInt(8);
        } while (linha == 0 && coluna == 0);

        this.posicaoTesouro = new int[]{linha, coluna};
    }

    private void preencherTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    public void iniciarTabuleiro() {
        preencherTabuleiro();
        adicionarTesouro();

        System.out.println("Tesouro: " + posicaoTesouro[0] + ", " + posicaoTesouro[1]);

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }

    }

}

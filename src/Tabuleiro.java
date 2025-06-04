import java.util.Random;

public class Tabuleiro {

    private char[][] tabuleiro = new char[8][8];

    private void adicionarTesouro() {
        Random rand = new Random();
        int linha = rand.nextInt(8);
        int coluna = rand.nextInt(8);
        tabuleiro[linha][coluna]='T';
    }

    public void iniciarTabuleiro() {

        adicionarTesouro();

    }

}

import java.util.Scanner;

public class Jogo {

    Tabuleiro tabuleiro;
    Scanner teclado;

    public Jogo(Scanner scanner) {
        this.tabuleiro = new Tabuleiro();
        this.teclado = scanner;
    }

    public void iniciar() {


        tabuleiro.iniciarTabuleiro();
        tabuleiro.mostrarTabuleiro();

        do {
            System.out.println();
            System.out.println("Digite o movimento: (ABAIXO, ACIMA, DIREITA, ESQUERDA): ");
            String movimento = teclado.nextLine().toUpperCase();

            if (movimento.equals("SAIR")) {
                System.out.println("Saindo...");
                break;
            }


            this.tabuleiro.movimentacaoJogador(movimento);

            if (this.tabuleiro.jogoEncerrou()) {
                System.out.println("PARABENS! VOCE ENCONTROU O TESOURO!");
                System.out.println("Número de tentativas: " + this.tabuleiro.qtdTentativas());
                System.out.println();
                this.tabuleiro.mostrarTabuleiro();
                break;
            }


            this.tabuleiro.mostrarTabuleiro();

        } while (true);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogo jogo = new Jogo(sc);

        jogo.iniciar();
    }

}

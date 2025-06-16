import java.util.Scanner;

public class Jogo {

    Tabuleiro tabuleiro;
    Jogador jogador;
    Scanner teclado;

    public Jogo(Scanner scanner) {
        this.tabuleiro = new Tabuleiro();
        this.jogador = new Jogador(this.tabuleiro);
        this.teclado = scanner;
    }

    public void iniciar() {
        tabuleiro.iniciarTabuleiro();
        tabuleiro.mostrarTabuleiro();

        do {
            System.out.println("Digite o movimento: (ABAIXO, ACIMA, DIREITA, ESQUERDA): ");
            String movimento = teclado.nextLine();

            if (movimento.equals("SAIR")) {
                System.out.println("Saindo...");
                break;
            }


            this.jogador.andar(movimento);

            if (this.tabuleiro.jogoEncerrou()) {
                System.out.println("PARABENS! VOCE ENCONTROU O TESOURO!");
                break;
            }

            this.tabuleiro.mostrarTabuleiro();

        } while (true);

    }

}

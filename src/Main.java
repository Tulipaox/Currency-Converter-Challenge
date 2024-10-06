import br.com.metodoscurrency.metodos;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcao = 0;
        double ammount = 0;

        Scanner leitura = new Scanner(System.in);
        metodos moeda = new metodos();


        moeda.menuOne();
        while (opcao != 10) {
            moeda.menu();
            opcao = leitura.nextInt();
            switch (opcao) {
                case 1:
                    moeda.mensagem();
                    ammount = leitura.nextDouble();
                    moeda.getConversor("USD", "ARS", ammount);
                    moeda.menuTwo();
                    break;
                case 2:
                    moeda.mensagem();
                    ammount = leitura.nextDouble();
                    moeda.getConversor("ARS", "USD", ammount);
                    moeda.menuTwo();
                    break;
                case 3:
                    moeda.mensagem();
                    ammount = leitura.nextDouble();
                    moeda.getConversor("USD", "BRL", ammount);
                    moeda.menuTwo();
                    break;
                case 4:
                    moeda.mensagem();
                    ammount = leitura.nextDouble();
                    moeda.getConversor("BRL", "USD", ammount);
                    moeda.menuTwo();
                    break;
                case 5:
                    moeda.mensagem();
                    ammount = leitura.nextDouble();
                    moeda.getConversor("USD", "COP", ammount);
                    moeda.menuTwo();
                    break;
                case 6:
                    moeda.mensagem();
                    ammount = leitura.nextDouble();
                    moeda.getConversor("COP", "USD", ammount);
                    moeda.menuTwo();
                    break;
                case 7:
                    moeda.ListOfMoney();
                    break;
                case 8:
                    System.out.println("Digite o Código do País Exp: [USD] para converter ");
                    String paisOne = leitura.next();
                    System.out.println("Digite o Código do País para qual sera convertido Exp: [BRL]");
                    String paisTwo = leitura.next();
                    System.out.println("Digite o valor para conversão");
                    ammount = leitura.nextDouble();
                    moeda.getConversor(paisOne, paisTwo, ammount);
                    moeda.menuTwo();
                    break;
                case 9:
                    moeda.ListdeCodigo();
                    break;
                case 10:
                    System.out.println("************************************");
                    System.out.println("Encerrando.......");
                    System.out.println("************************************");
                    break;
                default:
                    System.out.println("Escolha uma opção valida\n");
                    break;
            }

        }
        }
}
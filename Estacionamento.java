import java.util.Scanner;

public class Estacionamento {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {

            System.out.println("Sistema de Estacionamento");
            System.out.println("=====================================");
            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Cadastrar Vaga");
            System.out.println("3 - Realizar Locação de Vaga");
            System.out.println("4 - Desocupar Vaga");
            System.out.println("5 - Listar Veículos");
            System.out.println("6 - Listar Vagas");
            System.out.println("7 - Listar Locações");
            System.out.println("8 - Deletar Veículo");
            System.out.println("9 - Deletar Vaga");
            System.out.println("10 - Deletar Locação");
            System.out.println("0 - Sair");
            System.out.println("=====================================");
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("==== Cadastrar Veículo ====");
                    DefinirTipo(sc);
                    break;

                case 2:
                    System.out.println("==== Cadastrar Vaga ====");
                    CadastrarVaga(sc);
                    break;

                case 3:
                    System.out.println("==== Realizar uma Locação ====");
                    CadastrarLocacao(sc);
                    break;

                case 4:
                    System.out.println("==== Desocupar uma Vaga ====");
                    DesocuparVaga(sc);
                    break;

                case 5:
                    System.out.println("==== Listar Veículos ====");
                    ListarVeiculos();
                    break;

                case 6:
                    System.out.println("==== Listar Vagas ====");
                    ListarVagas();
                    break;

                case 7:
                    System.out.println("==== Listar Locações ====");
                    ListarLocacoes();
                    break;

                case 8:
                    System.out.println("==== Deletar Veículo ====");
                    DeletarVeiculo();
                    break;

                case 9:
                    System.out.println("==== Deletar Vaga ====");
                    DeletarVaga();
                    break;

                case 10:
                    System.out.println("==== Deletar Locação ====");
                    DeletarLocacao();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
            
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }

    public static void DefinirTipo(Scanner sc){

        int tipo = 0;

        do {
            System.out.println("Escolha uma opção válida: ");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Bicicleta");
            tipo = sc.nextInt();

            switch (tipo) {
                case 1:
                    CadastrarCarro(sc);
                    break;
                case 2:
                    CadastrarMoto(sc);
                    break;
                case 3:
                    CadastrarBicicleta(sc);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (tipo != 1 || tipo != 2 || tipo != 3);
    }

    public static void CadastrarCarro(Scanner sc){

        System.out.println("==== Cadastrar Carro ====");
        System.out.print("Digite o nome do carro: ");
        String nome = sc.next();
        System.out.print("Digite a placa do carro: ");
        String placa = sc.next();
        System.out.print("Digite a cor do carro: ");
        String cor = sc.next();

        new Carro(nome, placa, cor);
    }

    public static void CadastrarMoto(Scanner sc){

        System.out.println("==== Cadastrar Moto ====");
        System.out.print("Digite o nome do Moto: ");
        String nome = sc.next();
        System.out.print("Digite as cilindradas da Moto: ");
        int cilindradas = sc.nextInt();
        System.out.print("Digite a placa da Moto: ");
        String placa = sc.next();

        new Moto(nome, cilindradas, placa);
    }

    public static void CadastrarBicicleta(Scanner sc){

        System.out.println("==== Cadastrar Bicicleta ====");
        System.out.print("Digite o nome da Bicicleta: ");
        String nome = sc.next();
        System.out.print("Digite a cor da Bicicleta: ");
        String cor = sc.next();
        System.out.print("Digite a marca da Bicicleta: ");
        String marca = sc.next();

        new Bicicleta(nome, marca, cor);
    }

    public static void CadastrarVaga(Scanner sc){

        String tipo = "";

        System.out.println("==== Cadastrar Vaga ====");
        System.out.print("Digite o número da vaga: ");
        String numero = sc.next();

        do {
            System.out.print("Digite o tipo da vaga: [C]arro, [M]oto, [B]icicleta");
            tipo = sc.next();

            if (tipo != "C" || tipo != "M" || tipo != "B") {
                System.out.println("Opção inválida!");
            }
        } while (tipo != "C" || tipo != "M" || tipo != "B");

        System.out.print("Digite o preço da vaga: ");
        double preco = sc.nextDouble();
        System.out.print("Digite o tamanho: ");
        double tamanho = sc.nextDouble();

        new Vaga(numero, tipo, preco, tamanho);
    }

    public static void CadastrarLocacao(Scanner sc){

        System.out.println("==== Realizar uma Locação ====");
        System.out.println("Insira a data de locação: ");
        String data = sc.next();
        System.out.println("Insira o veículo: ");
        int idVeiculo = sc.nextInt();
        try {
            Veiculo veiculo = Veiculo.getVeiculoById(idVeiculo);
            System.out.println("Insira a vaga: ");
            int idVaga = sc.nextInt();
            Vaga vaga = Vaga.getVagaById(idVaga);
            if (vaga.isOcupada()) {
                throw new Exception("Vaga ocupada!");
            } else {
                new Locacao(data, vaga, veiculo);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DesocuparVaga(Scanner sc){
        System.out.println("==== Desocupar uma Vaga ====");
        System.out.println("Insira a vaga que será desocupada: ");
        int idVaga = sc.nextInt();

        try {
            Vaga vaga = Vaga.getVagaById(idVaga);
            if (!vaga.isOcupada()) {
                throw new Exception("Vaga já está desocupada!");
            }
            vaga.setOcupada(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ListarVeiculos(){

    }

    public static void ListarVagas(){

    }

    public static void ListarLocacoes(){

    }

    public static void DeletarVeiculo(){

    }

    public static void DeletarVaga(){

    }

    public static void DeletarLocacao(){

    }

}

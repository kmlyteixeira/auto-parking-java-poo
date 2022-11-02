import java.util.Scanner;

public class Estacionamento {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {

            System.out.println("\n\nSistema de Estacionamento");
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
                    DeletarVeiculo(sc);
                    break;

                case 9:
                    System.out.println("==== Deletar Vaga ====");
                    DeletarVaga(sc);
                    break;

                case 10:
                    System.out.println("==== Deletar Locação ====");
                    DeletarLocacao(sc);
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

        } while (tipo != 1 && tipo != 2 && tipo != 3);
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

        System.out.println("Carro cadastrado com sucesso!");
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

        System.out.println("Moto cadastrada com sucesso!");
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

        System.out.println("Bicicleta cadastrada com sucesso!");
    }

    public static void CadastrarVaga(Scanner sc) {

        String tipo = "";
        System.out.print("Digite o número da vaga: ");
        String numero = sc.next();
        System.out.print("Digite o preço da vaga (siga o formato: 999,99): ");
        double preco = sc.nextDouble();
        System.out.print("Digite o tamanho (em metros quadrados. Ex: 45,00): ");
        double tamanho = sc.nextDouble();
        System.out.println("Digite o tipo da vaga: [C]arro, [M]oto, [B]icicleta");
        tipo = sc.next();

        if (tipo.equalsIgnoreCase("C")) {
            new Vaga<Carro>(numero, tipo, preco, tamanho);
        } else if (tipo.equalsIgnoreCase("M")) {
            new Vaga<Moto>(numero, tipo, preco, tamanho);
        } else if (tipo.equalsIgnoreCase("B")) {
            new Vaga<Bicicleta>(numero, tipo, preco, tamanho);
        } else {
            System.out.println("Tipo inválido!");
        }

        System.out.println("Vaga cadastrada com sucesso!");
    }

    public static void CadastrarLocacao(Scanner sc){

        System.out.println("Insira a data de locação: ");
        String data = sc.next();
        System.out.println("Insira o veículo: ");
        int idVeiculo = sc.nextInt();
        try {
            Veiculo veiculo = Veiculo.getVeiculoById(idVeiculo);
            System.out.println("Insira a vaga: ");
            int idVaga = sc.nextInt();
            
            if (veiculo instanceof Carro) {
                Vaga<Carro> vaga = Vaga.getVagaById(idVaga);
                if (vaga.isOcupada()) {
                    throw new Exception("Vaga ocupada!");
                } else {
                    new Locacao(data, vaga, veiculo);
                    System.out.println("Locação cadastrada com sucesso!");
                }
            } else if (veiculo instanceof Moto) {
                Vaga<Moto> vaga = Vaga.getVagaById(idVaga);
                if (vaga.isOcupada()) {
                    throw new Exception("Vaga ocupada!");
                } else {
                    new Locacao(data, vaga, veiculo);
                    System.out.println("Locação cadastrada com sucesso!");
                }
            } else if (veiculo instanceof Bicicleta) {
                Vaga<Bicicleta> vaga = Vaga.getVagaById(idVaga);
                if (vaga.isOcupada()) {
                    throw new Exception("Vaga ocupada!");
                } else {
                    new Locacao(data, vaga, veiculo);
                    System.out.println("Locação cadastrada com sucesso!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DesocuparVaga(Scanner sc){
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
        for (Veiculo veiculo : Veiculo.getVeiculos()) {
            System.out.println(veiculo);
        }
    }

    public static void ListarVagas(){
        for (Vaga vaga : Vaga.getVagas()) {
            System.out.println(vaga);
        }
    }

    public static void ListarLocacoes(){
        for (Locacao locacao : Locacao.getLocacoes()) {
            System.out.println(locacao);
        }
    }

    public static void DeletarVeiculo(Scanner sc){
        System.out.println("Insira o id do veículo que será deletado: ");
        int idVeiculo = sc.nextInt();

        try {
            Veiculo veiculo = Veiculo.getVeiculoById(idVeiculo);
            Veiculo.getVeiculos().remove(veiculo);
            if (veiculo instanceof Carro) {
                Carro.getCarros().remove(veiculo);
            } else if (veiculo instanceof Moto) {
                Moto.getMotos().remove(veiculo);
            } else if (veiculo instanceof Bicicleta) {
                Bicicleta.getBicicletas().remove(veiculo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DeletarVaga(Scanner sc){
        System.out.println("Insira o id da vaga que será deletada: ");
        int idVaga = sc.nextInt();

        try {
            Vaga vaga = Vaga.getVagaById(idVaga);
            Vaga.getVagas().remove(vaga);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DeletarLocacao(Scanner sc){
        System.out.println("Insira o id da locação que será deletada: ");
        int idLocacao = sc.nextInt();

        try {
            Locacao locacao = Locacao.getLocacaoById(idLocacao);
            Locacao.getLocacoes().remove(locacao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

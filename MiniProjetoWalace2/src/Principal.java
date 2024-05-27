import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		NoArvore tree = new NoArvore(); // Crio uma nova arvore.
		Dados.carregarDados(tree); // Carrego os dados do txt.
		inicio(tree);

	}
	
	public static void inicio(NoArvore tree) {
        System.out.println("\n1: Insira um aluno");
        System.out.println("2: Remova um aluno pelo RGM");
        System.out.println("3: Buscar por RGM");
        System.out.println("4: Exibir todos os alunos");
        System.out.println("5: Esvaziar a arvore");
        System.out.println("6: Fechar");
        System.out.println("Selecione: ");

        Scanner teclado = new Scanner(System.in);
        int opcao = teclado.nextInt();
        
        switch(opcao) {
            case 1: {
                System.out.println("Nome: ");
                teclado.nextLine();
                String nome = teclado.nextLine();
                System.out.println("RGM: ");
                String rgm = teclado.nextLine();
                tree.adicionar(rgm, nome);
                break;
            }
            case 2: {
                System.out.println("RGM: ");
                teclado.nextLine();
                String rgm = teclado.nextLine();
                tree.deletar(rgm);
                break;
            }
            case 3: {
                System.out.println("RGM: ");
                teclado.nextLine();
                String rgm = teclado.nextLine();
                NoArvore.buscar(tree, rgm);
                break;
            }
            case 4: {
            	System.out.println("\n1: Pre-Ordem");
                System.out.println("2: In-Ordem");
                System.out.println("3: Pos-Ordem");
              //System.out.println("4: Graficamente");
                System.out.println("Selecione: ");
                int opcaoExibir = teclado.nextInt();
                switch(opcaoExibir) {
	                case 1: {
	                    NoArvore.exibirPreOrdem(tree);
	                    break;
	                }
	                case 2: {
	                    NoArvore.exibirInOrdem(tree);
	                    break;
	                }
	                case 3: {
	                	NoArvore.exibirPosOrdem(tree);
	                    break;
	                }
	              //case 4: {
	                //	NoArvore.exibirGraficamente(tree, 10, 10, 3);
	                //  break;
	                //}
	                default: {
	                    System.out.println("Opção inválida, saindo.");
	                    System.exit(0);
	                }
                }
                break;
            }
            case 5: {
                System.out.println("Esvaziando arvore.");
                NoArvore.esvaziar(tree);
                break;
            }
            case 6: {
                System.out.println("Saindo.");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Opção inválida, saindo.");
                System.exit(0);
            }
        }
        inicio(tree);
        teclado.close();	
    }

}

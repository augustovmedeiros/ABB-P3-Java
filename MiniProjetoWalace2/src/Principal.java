
public class Principal {

	public static void main(String[] args) {
		NoArvore tree = new NoArvore();
		Dados.carregarDados(tree);
		NoArvore.exibirInOrdem(tree);

	}

}

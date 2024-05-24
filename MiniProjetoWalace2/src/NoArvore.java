
public class NoArvore {
	String rgm = "";
	String nome = "";
	NoArvore esquerda = null;
	NoArvore direita = null;
	
	public static void exibirPreOrdem(NoArvore arvore) {
		if(arvore != null) {
			System.out.println("\n" + arvore.rgm + " - " + arvore.nome);
			exibirPreOrdem(arvore.esquerda);
			exibirPreOrdem(arvore.direita);
		}
	}
	
	public static void exibirInOrdem(NoArvore arvore) {
		if(arvore != null) {
			exibirPreOrdem(arvore.esquerda);
			System.out.println("\n" + arvore.rgm + " - " + arvore.nome);
			exibirPreOrdem(arvore.direita);
		}
	}
	
	public static void exibirPosOrdem(NoArvore arvore) {
		if(arvore != null) {
			exibirPreOrdem(arvore.esquerda);
			exibirPreOrdem(arvore.direita);
			System.out.println("\n" + arvore.rgm + " - " + arvore.nome);
		}
	}
	
	public static void buscar(NoArvore arvore, String rgm) {
        if (arvore == null) {
            System.out.println("Nó com RGM " + rgm + " não encontrado na árvore.");
            return;
        }

        if (rgm.compareTo(arvore.rgm) == 0) {
            System.out.println("Nó encontrado: " + arvore.rgm + " - " + arvore.nome);
            return;
        }

        if (rgm.compareTo(arvore.rgm) < 0) {
            buscar(arvore.esquerda, rgm);
        } else {
            buscar(arvore.direita, rgm);
        }
    } 
	
	public static NoArvore inserir(NoArvore arvore, String rgm, String nome) {
        if (arvore == null) {
            NoArvore novoNo = new NoArvore();
            novoNo.rgm = rgm;
            novoNo.nome = nome;
            return novoNo;
        }
        if(arvore.rgm == "") { //corrigir primeira entrada vazia.
        	arvore.rgm = rgm;
        	arvore.nome = nome;
        	return arvore;
        }
        if (rgm.compareTo(arvore.rgm) < 0) {
            arvore.esquerda = inserir(arvore.esquerda, rgm, nome);
        } else if (rgm.compareTo(arvore.rgm) > 0) {
            arvore.direita = inserir(arvore.direita, rgm, nome);
        } else {
            System.out.println("RGM já existe na arvore.");
        }

        return arvore;
    }

}

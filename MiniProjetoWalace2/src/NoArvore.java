public class NoArvore {
	
	String rgm = "";
	String nome = "";
	NoArvore esquerda = null;
	NoArvore direita = null;
	
	public String getRgm() {
		return rgm;
	}
	public void setRgm(String rgm) {
		this.rgm = rgm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public NoArvore getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
	}
	public NoArvore getDireita() {
		return direita;
	}
	public void setDireita(NoArvore direita) {
		this.direita = direita;
	}
	
	public static void exibirPreOrdem(NoArvore arvore) {
		if(arvore != null) {
			System.out.println(arvore.getRgm() + " - " + arvore.getNome());
			exibirPreOrdem(arvore.getEsquerda());
			exibirPreOrdem(arvore.getDireita());
		}
	}

	public static void exibirInOrdem(NoArvore arvore) {
		if(arvore != null) {
			exibirPreOrdem(arvore.getEsquerda());
			System.out.println(arvore.getRgm() + " - " + arvore.getNome());
			exibirPreOrdem(arvore.getDireita());
		}
	}

	public static void exibirPosOrdem(NoArvore arvore) {
		if(arvore != null) {
			exibirPreOrdem(arvore.getEsquerda());
			exibirPreOrdem(arvore.getDireita());
			System.out.println(arvore.getRgm() + " - " + arvore.getNome());
		}
	}
	
	public static void buscar(NoArvore arvore, String rgm) {
		if (arvore == null) {
			System.out.println("Nó com RGM " + rgm + " não encontrado na árvore.");
			return;
		}

		if (Integer.parseInt(rgm) == Integer.parseInt(arvore.rgm)) {
			System.out.println("Nó encontrado: " + arvore.rgm + " - " + arvore.nome);
			return;
		}

		if (Integer.parseInt(rgm) < Integer.parseInt(arvore.rgm)) {
			buscar(arvore.esquerda, rgm);
		} else {
			buscar(arvore.direita, rgm);
		}
	} 
	
	public void adicionar(String rgm, String nome) {
		inserir(this, rgm, nome);
	}
	
	public static NoArvore inserir(NoArvore arvore, String rgm, String nome) {
		if (arvore == null) {
			NoArvore novoNo = new NoArvore();
			novoNo.setRgm(rgm);
			novoNo.setNome(nome);
			return novoNo;
		}
		if(arvore.rgm == "") { //corrigir primeira entrada vazia.
			arvore.setRgm(rgm);
			arvore.setNome(nome);
			return arvore;
		}
		if (Integer.parseInt(rgm) < Integer.parseInt(arvore.getRgm())) {
			arvore.setEsquerda(inserir(arvore.getEsquerda(), rgm, nome));
		} else if (Integer.parseInt(rgm) > Integer.parseInt(arvore.getRgm())) {
			arvore.direita = inserir(arvore.getDireita(), rgm, nome);
		} else {
			System.out.println("RGM já existe na arvore.");
		}

		return arvore;
	}
	
	public void deletar(String rgm) {
		buscar(this, rgm);
		remover(this, rgm);
	}
	
	public static NoArvore remover(NoArvore raiz, String rgm) {
	    if (raiz == null) {
	        return null;
	    }
	    
	    if (Integer.parseInt(rgm) < Integer.parseInt(raiz.rgm)) {
	        raiz.esquerda = remover(raiz.esquerda, rgm);
	    } else if (Integer.parseInt(rgm) > Integer.parseInt(raiz.rgm)) {
	        raiz.direita = remover(raiz.direita, rgm);
	    } else {
	        // Nó a ser removido encontrado
	        System.out.println("RGM: " + raiz.rgm + " - Nome: " + raiz.nome + " Removido!");
	        
	        // Verifica se o nó a ser removido não tem filhos
	        if (raiz.esquerda == null && raiz.direita == null) {
	            return null;
	        }
	        // Verifica se o nó a ser removido tem apenas um filho
	        else if (raiz.esquerda == null) {
	            return raiz.direita;
	        } else if (raiz.direita == null) {
	            return raiz.esquerda;
	        }
	        // Caso o nó a ser removido tenha dois filhos
	        else {
	            // Substitui o nó a ser removido pelo menor nó na subárvore direita
	            NoArvore menor = menorNo(raiz.direita);
	            raiz.nome = menor.nome;
	            raiz.rgm = menor.rgm;
	            raiz.direita = remover(raiz.direita, menor.rgm);
	        }
	    }
	    return raiz;
	}

	// Método auxiliar para encontrar o menor nó em uma subárvore
	private static NoArvore menorNo(NoArvore node) {
	    NoArvore atual = node;
	    while (atual.esquerda != null) {
	        atual = atual.esquerda;
	    }
	    return atual;
	}

	
	public static NoArvore esvaziar(NoArvore raiz) {
		if (raiz == null) {
			return null;
		}
		String rgm = raiz.getRgm();
		if (Integer.parseInt(rgm) < Integer.parseInt(raiz.rgm)) {
			raiz.esquerda = esvaziar(raiz.esquerda);
		} else if (Integer.parseInt(rgm) > Integer.parseInt(raiz.rgm)) {
			raiz.direita = esvaziar(raiz.direita);
		} else {
			if (raiz.esquerda == null) {
				return raiz.direita;
			}
			else if (raiz.direita == null) {
				return raiz.esquerda;
			}
			else {
				raiz.nome = "";
				raiz.rgm = "";
				raiz.direita = null;
				raiz.esquerda = null;
			}
		}
		return raiz;
	}
	
	//public static void gotoxy(int coluna, int linha) {
	//	char escCode = 0x1B; //CODIGO PARA ESCAPAR O CURSOR DO CONSOLE PARA A POSIÇÃO.
	//	System.out.print(String.format("%c[%d;%df",escCode,linha,coluna));
	//}
	
	//public static void exibirGraficamente(NoArvore tree, int col, int linha, int desloc) {
	//	gotoxy(col, linha);
	//	System.out.print(tree.getNome());
	//	if(tree.getEsquerda() != null) {
	//		exibirGraficamente(tree.getEsquerda(), col-desloc, linha+2, desloc/2+1);
	//	}
	//	if(tree.getDireita() != null) {
	//		exibirGraficamente(tree.getDireita(), col+desloc, linha+2, desloc/2+1);
	//	}
		
	//}
	
}
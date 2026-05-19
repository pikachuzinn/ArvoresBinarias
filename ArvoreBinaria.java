class ArvoreBinaria {
    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }

    // metodo de insercao
    void inserir(int chave) {
        raiz = inserirRec(raiz, chave);
    }

    No inserirRec(No raiz, int chave) {
        if (raiz == null) {
            raiz = new No(chave);
            return raiz;
        }

        if (chave < raiz.chave)
            raiz.esquerda = inserirRec(raiz.esquerda, chave);
        else if (chave > raiz.chave)
            raiz.direita = inserirRec(raiz.direita, chave);

        return raiz;
    }

    // metodos de percurso
    void preOrdem() {
        preOrdemRec(raiz);
    }

    void preOrdemRec(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.chave + " ");
            preOrdemRec(raiz.esquerda);
            preOrdemRec(raiz.direita);
        }
    }

    void emOrdem() {
        emOrdemRec(raiz);
    }

    void emOrdemRec(No raiz) {
        if (raiz != null) {
            emOrdemRec(raiz.esquerda);
            System.out.print(raiz.chave + " ");
            emOrdemRec(raiz.direita);
        }
    }

    void posOrdem() {
        posOrdemRec(raiz);
    }

    void posOrdemRec(No raiz) {
        if (raiz != null) {
            posOrdemRec(raiz.esquerda);
            posOrdemRec(raiz.direita);
            System.out.print(raiz.chave + " ");
        }
    }

    // metodo de remocao
    void remover(int chave) {
        raiz = removerRec(raiz, chave);
    }

    No removerRec(No raiz, int chave) {
        // caso base: arvore vazia
        if (raiz == null) {
            return raiz;
        }

        // desce na arvore
        if (chave < raiz.chave) {
            raiz.esquerda = removerRec(raiz.esquerda, chave);
        } else if (chave > raiz.chave) {
            raiz.direita = removerRec(raiz.direita, chave);
        } else {
            // no com um filho ou sem filho
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            // no com dois filhos: pega o sucessor (menor da subarvore direita)
            raiz.chave = menorValor(raiz.direita);

            // deleta o sucessor
            raiz.direita = removerRec(raiz.direita, raiz.chave);
        }
        return raiz;
    }

    int menorValor(No raiz) {
        int menorValor = raiz.chave;
        while (raiz.esquerda != null) {
            menorValor = raiz.esquerda.chave;
            raiz = raiz.esquerda;
        }
        return menorValor;
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(5);
        arvore.inserir(3);
        arvore.inserir(2);
        arvore.inserir(4);
        arvore.inserir(7);
        arvore.inserir(6);
        arvore.inserir(8);

        System.out.println("Percurso pre-ordem: ");
        arvore.preOrdem();
        System.out.println();

        System.out.println("Percurso em-ordem: ");
        arvore.emOrdem();
        System.out.println();

        System.out.println("Percurso pos-ordem: ");
        arvore.posOrdem();
        System.out.println();

        System.out.println("Removendo 2");
        arvore.remover(2);
        System.out.println("Em-ordem depois da remocao: ");
        arvore.emOrdem();
        System.out.println();

        System.out.println("Removendo 3");
        arvore.remover(3);
        System.out.println("Em-ordem depois da remocao: ");
        arvore.emOrdem();
        System.out.println();

        System.out.println("Removendo 5");
        arvore.remover(5);
        System.out.println("Em-ordem depois da remocao: ");
        arvore.emOrdem();
        System.out.println();
    }
}
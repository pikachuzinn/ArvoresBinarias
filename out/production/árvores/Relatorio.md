# Relatório: Justificativa para Implementação Recursiva da Remoção em Árvore Binária

## Introdução

A tarefa consistiu em implementar uma árvore binária em Java, incluindo operações de inserção, percursos (pré-ordem, em-ordem, pós-ordem) e, crucialmente, uma funcionalidade de remoção de nós. A remoção deveria contemplar três cenários: nós folha, nós com um filho e nós com dois filhos, sendo que para este último, a metodologia de Sucessor (menor dos maiores) foi a escolhida. Este relatório justifica a decisão de implementar a função de remoção de forma recursiva.

## Implementação Recursiva da Remoção

A função `removeRec(Node root, int key)` foi implementada recursivamente. A lógica central da remoção em uma Árvore Binária de Busca (BST) se alinha naturalmente com a natureza recursiva das estruturas de dados de árvore.

### Vantagens da Abordagem Recursiva:

1.  **Clareza e Concisão:** A implementação recursiva da remoção é frequentemente mais clara e concisa do que sua contraparte iterativa. A estrutura do código reflete diretamente a definição recursiva da árvore, onde cada nó é a raiz de uma subárvore. Isso torna o código mais fácil de ler e entender, pois a lógica para navegar e modificar a árvore é expressa de forma elegante.

2.  **Espelhamento da Estrutura da Árvore:** Árvores são estruturas de dados recursivas por natureza. Cada nó em uma árvore pode ser visto como a raiz de sua própria subárvore. Operações que envolvem a travessia e modificação dessas subárvores se beneficiam enormemente de uma abordagem recursiva, pois a mesma lógica pode ser aplicada repetidamente a subproblemas menores.

3.  **Manipulação de Ponteiros (Referências):** Na remoção, especialmente quando um nó é substituído por um de seus filhos ou por seu sucessor, a atualização das referências dos nós pais é fundamental. A recursão simplifica isso, pois a função retorna o nó (ou a nova raiz da subárvore modificada) para o seu chamador, que então pode atualizar sua referência (`root.left = removeRec(...)` ou `root.right = removeRec(...)`). Em uma abordagem iterativa, gerenciar essas referências de pais pode ser significativamente mais complexo, muitas vezes exigindo o uso de ponteiros para ponteiros ou estruturas auxiliares para rastrear o nó pai.

4.  **Tratamento dos Casos de Remoção:**
    *   **Nó Folha:** Quando um nó folha é encontrado e corresponde à chave a ser removida, a função simplesmente retorna `null`, efetivamente removendo o nó ao desvincular a referência do seu pai.
    *   **Nó com Um Filho:** Se o nó a ser removido tem apenas um filho, a função retorna esse filho, fazendo com que o pai do nó removido aponte diretamente para o neto, ignorando o nó do meio.
    *   **Nó com Dois Filhos (Sucessor):** Este é o caso mais complexo. A abordagem recursiva facilita a busca pelo sucessor in-order (o menor valor na subárvore direita) e, em seguida, a remoção desse sucessor da subárvore direita. A chave do nó a ser removido é substituída pela chave do sucessor, e a remoção do sucessor é delegada a uma chamada recursiva na subárvore direita.

### Desvantagens Potenciais (e por que foram aceitáveis neste contexto):

*   **Overhead de Pilha:** Chamadas recursivas consomem espaço na pilha de chamadas. Para árvores muito profundas, isso poderia levar a um `StackOverflowError`. No entanto, para a maioria dos casos práticos e para fins de demonstração de um algoritmo de árvore binária, a profundidade da recursão é gerenciável.
*   **Depuração:** A depuração de código recursivo pode ser um pouco mais desafiadora devido à natureza das chamadas de pilha. No entanto, com ferramentas de depuração modernas e uma compreensão clara da lógica recursiva, isso é superável.

## Conclusão

A escolha de uma implementação recursiva para a função de remoção em uma árvore binária de busca é justificada pela sua elegância, clareza e pela forma como ela naturalmente se alinha com a estrutura recursiva da árvore. Embora existam considerações sobre o uso da pilha, os benefícios em termos de legibilidade e simplicidade de manutenção do código superam as desvantagens para esta aplicação. A abordagem recursiva permitiu uma manipulação eficiente e intuitiva dos diferentes casos de remoção, especialmente o cenário mais complexo de nós com dois filhos utilizando o sucessor in-order.

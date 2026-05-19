# Relatório: Por que eu usei recursão pra remover nós na Árvore Binária

## Introdução

A atividade pediu pra implementar uma árvore binária em Java com inserção, os três tipos de percurso (pré-ordem, em-ordem e pós-ordem) e também a remoção de nós. A remoção tinha que funcionar em três situações: quando o nó não tem filhos, quando tem só um filho, e quando tem dois filhos. Nesse último caso, a gente usou o Sucessor, que é o menor valor da subárvore da direita. Aqui eu vou explicar por que escolhi fazer a remoção de forma recursiva.

## Por que usei recursão

A função removerRec(No raiz, int chave) foi feita de forma recursiva. Eu escolhi assim porque achei mais fácil de entender e de escrever do que fazer com laços e controle manual de ponteiros.

### Vantagens que eu percebi:

1.  O código fica mais fácil de ler. Quando a gente usa recursão, o código fica menor e mais direto. Dá pra entender o que cada parte faz sem ter que ficar rastreando variáveis de controle. Eu mesmo achei mais fácil de escrever assim.

2.  A árvore já é recursiva por natureza. Cada nó é tipo a raiz de uma árvore menor. Então faz sentido usar uma função que se chama de novo pra cada subárvore, porque é exatamente isso que acontece na estrutura.

3.  Atualizar as referências fica mais simples. Numa abordagem iterativa, você precisa guardar o nó pai pra poder atualizar o filho dele depois da remoção. Com recursão isso é automático, porque a função retorna o nó atualizado e o próprio Java cuida de setar o esquerda ou direita do pai.

4.  Os três casos de remoção ficaram tranquilos de implementar:

Nó folha: só retorna null e pronto, o pai perde a referência.
Nó com um filho: retorna esse filho direto, pulando o nó removido.
Nó com dois filhos: pega o sucessor (menor da direita), copia o valor dele pro nó atual, e aí chama a função de novo pra remover o sucessor lá embaixo.

### Desvantagens (mas não foram problema aqui):

A recursão usa memória da pilha de chamadas, então se a árvore ficar muito grande e desbalanceada pode dar StackOverflowError. Mas pra essa atividade que é só demonstração, não chegou nem perto disso. Outro ponto é que debugar recursão pode confundir um pouco, mas com calma dá pra acompanhar o fluxo.

## Conclusão

No geral, achei que a recursão foi a melhor escolha pra esse caso. O código ficou mais limpo, mais fácil de entender e de explicar. O caso mais complicado que é o de dois filhos também ficou bem organizado com o uso do sucessor. Pra uma atividade de estudo como essa, a abordagem recursiva cumpriu bem o que precisava.

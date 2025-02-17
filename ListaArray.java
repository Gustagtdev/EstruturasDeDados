package util;

public class ListaArray {
    /*CONSTANTES-Sempre serão definidas com todas as letras maiúsculas.
    Ao invés de usar uma literal(valor) no código,devemos usar uma constante.
     */
    final public static int TAMANHO_INICIAL = 3;
    final public static int FATOR_CRESCIMENTO = 5;
    final public static int NAO_ESTA_PRESENTE = -1;
    //Atributos
    private Object[] arrayInterno;
    private int numElementos;

    //Métodos
    public ListaArray() {
        this.numElementos = 0;//Não precisaria,pois a inicialização é default
        this.arrayInterno = new Object[TAMANHO_INICIAL];
    }

    /*Verifica a necessidade do crescimento de um array interno. Este método é privado
    pois só deve ser visível internamente a classe ListaArray
     */
    private void verificarNecessidadeDeCrescimento() {
        //Obtendo o tamanho do array referenciado por this.arrayInterno
        int tamanho = this.arrayInterno.length;
        /*Se o tamanho é igual ao número de elementos é porque o array interno está cheio,
        então precisamos de um novo array*/
        if (tamanho == this.numElementos) {
            //Criação de um array maior
            Object[] novoArray = new Object[tamanho + FATOR_CRESCIMENTO];
            //Copiando as referências que estão no array interno para o novo array
            for (int i = 0; i < tamanho; i++) {
                novoArray[i] = this.arrayInterno[i];
                /*o novo array passa a ser o array interno
                (o antigo será descartado pelo garbage collection)
                 */
                this.arrayInterno = novoArray;
                /*OBS: Em Java a escrita "this" é opcional.
                 * Entretanto como o conceito de "this" é um dos mais importantes de POO,
                 * sempre vamos usar "this" em nossos códigos*/
            }
        }
    }

    /*Adiciona a referência para um novo elemento no final do arrayInterno
  @param elemento- referência para o Objeto a ser direcionado na ListaArray
  @return- informa se o elemento foi adicionado*/
    public boolean adicionar(Object elemento) {
        //Verificando se o arrayInterno tem espaço para inclusão do elemento
        this.verificarNecessidadeDeCrescimento();
        this.arrayInterno[this.numElementos] = elemento;
        //Incrementamos o numElementos
        this.numElementos++;
        //Informamos que a adição foi feita com sucesso!
        return true;
    }

    /*Adiciona a referência para um novo elemento na posição indicada
    /@param elemento- referência para o Objeto a ser direcionado na ListaArray
    /@return true: Se a posição for plausível; false: Se a posição for inválida.
     */
    public boolean adicionar(Object elemento, int posicao) {
            /*Verificando se a posição é plausível.Não pode ser negativa,
            pois não há posições negativas em uma lista;não pode ser maior que numElementos,
            pois não podemos deixar posições nulas("buracos") no array */
        if (posicao < 0 || posicao > this.numElementos) {
            return false;
            //Verificar se o arrayInterno tem espaço para inclusão
            this.verificarNecessidadeDeCrescimento();
            //Deslocando os elementos para abrir espaço no elemento no array para a
            // posição indicada.
            for (int i = this.numElementos; i > posicao; i--) {
                this.arrayInterno[i] = this.arrayInterno[i - 1];
                //Colocando a referência para o elemento na posição passada
                this.arrayInterno[posicao] = elemento;
                //Informamos que a adição foi feita com sucesso!
                return true;
            }
        }
    }

    /*Retorna a referência para o elemento presente na posição indicada
    /@param posicao - índice para a recuperação do elemento
    /@return referência para o elemento da posição ou null se a posição for inválida
     */
    public Object obter(int posicao) {
        //Se a posição for inválida, retornamos null
        if (posicao < 0 || posicao >= this.numElementos) {
            return null;
            //Retornando a referência para o elemento da posição
            return this.arrayInterno[posicao];
        }
    }
        /*Retorna a posição em que um elemento está presente
        /@param elemento - referência para o elemento procurado
        /@return posição onde está o elemento ou NAO_ESTA_PRESENTE se não for encontrado
         */
        public int posicaoDe(Object elemento){
            //Varrendo o arrayInterno a procura de um elemento
            for(int i=0;i<this.numElementos;i++) {
                //Se na posição "i" estiver quem estamos procurando retornamos o valor de "i".
                if (this.arrayInterno[i] == elemento) {
                    return i;
                    //Retornando -1 para indicar que o elemento não foi encontrado
                return NAO_ESTA_PRESENTE;
                }

            }
            /*Remove o elemento da posição indicada. Precisará agrupar os elementos
            /para não deixar null('buraco') no arrayInterno
            /@param posicao
            /@return
             */
            public boolean remover(int posicao){
                //Se a posição não for palusível,retornamos false
                if(posicao<0||posicao>=this.numElementos) {
                    return false;
                    //Para retirar um elemento e não deixar um buraco no arrayInterno
                    //Vamos trazer uma posição para trás os elementos da posição indicada
                    //até o último elemento presente
                    for (int i = posicao; i < this.numElementos; i++) {
                        this.arrayInterno[i] = this.arrayInterno[i + 1];
                        //Para que a última posição não fique duplicada,colocamos null.
                        this.arrayInterno[this.numElementos - 1] = null;
                        //Diminui o número de elementos presentes na lista
                        this.numElementos--;
                        //Retornamos true informando que o elemento foi retirado
                        return true;
                    }
                /*Remove o elemento da lista caso esteja presente
                /@param elemento - referência para o objeto a ser removido.
                /@return true: Se o elemento estiver presente na lista,false: Caso não esteja.
                 */
                    public boolean remover (Object elemento){
                        //Se o elemento estiver na lista o método posicaoDe
                        //retornará o índice onde está presente ou -1(NAO_ESTA_PRESENTE)
                        int posicao = this.posicaoDe(elemento);
                        //Se não estiver na lista
                        if (posicao == NAO_ESTA_PRESENTE) {
                            return false;
                            //Utilizamos o método remover pela posição para a operação
                            return this.remover(posicao);
                        }
                        /*Retorna o número de elementos presentes na lista
                        /@return número de elementos
                         */
                        public int obterNumElementos(){
                            return this.numElementos;
                        }
                    }
                }

            }

    }

}



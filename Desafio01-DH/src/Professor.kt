abstract class Professor(nome:String, sobrenome:String, id:Int) : Pessoa(nome, sobrenome, id){
    val tempoDeCasa : Int

    init {
        tempoDeCasa = 0
    }
}
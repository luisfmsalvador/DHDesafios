data class Curso(val nome:String,
            val id: Int,
            val qtdeMaximaAlunos: Int) {

    val alunosMatriculados = mutableSetOf<Aluno>()
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null

    fun adicionarUmAluno(umAluno: Aluno):Boolean{
        if (alunosMatriculados.size < qtdeMaximaAlunos){
            println("Matrícula realizada com sucesso!")
            alunosMatriculados.add(umAluno)
            return true
        } else {
            throw Exception("Não há mais vagas para este curso!")
        }
    }

    fun excluirAluno(umAluno: Aluno){
        alunosMatriculados.remove(umAluno)
    }
}
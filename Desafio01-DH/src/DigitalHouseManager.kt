import java.time.LocalDateTime

class DigitalHouseManager() {
    val alunos = mutableMapOf<Int,Aluno>()
    val professores = mutableMapOf<Int,Professor>()
    val cursos = mutableMapOf<Int,Curso>()
    val matriculas = mutableSetOf<Matricula>()

    fun registrarCurso(nome:String, id:Int, qtdeMaximaAlunos:Int){
        cursos.put(id, Curso(nome,id,qtdeMaximaAlunos))
    }

    fun excluirCurso(id: Int){
        cursos.remove(id)
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome:String, id:Int, quantidadeDeHoras:Int){
        professores.put(id, ProfessorAdjunto(nome, sobrenome, id, quantidadeDeHoras))
    }

    fun registrarProfessorTitular(nome:String, sobrenome:String, id:Int, especialidade:String){
        professores.put(id, ProfessorTitular(nome,sobrenome, id, especialidade))
    }

    fun excluirProfessor(id:Int){
        professores.remove(id)
    }

    fun matricularAluno(nome:String, sobrenome: String, id:Int){
        alunos.put(id,Aluno(nome, sobrenome, id))
    }

    fun matricularAluno(idAluno:Int, idCurso: Int){
        try{
            val aluno = alunos[idAluno]
            val curso = cursos[idCurso]
            if (aluno != null && curso != null){
                if (cursos[idCurso]?.adicionarUmAluno(aluno)!!) {
                    matriculas.add(Matricula(aluno, curso, LocalDateTime.now()))
                }
            }
        } catch (e:NullPointerException){
            println("Erro: " + e.message)
        } catch (e:Exception){
            println("Erro inesperado: " + e.message)
        }
    }

    fun alocarProfessores(idCurso: Int, idProfessorTitular: Int, idProfessorAdjunto: Int){
        try {
            if (cursos.containsKey(idCurso) && professores.containsKey(idProfessorTitular) && professores.containsKey(idProfessorAdjunto)) {
                cursos[idCurso]?.professorAdjunto = professores[idProfessorAdjunto] as ProfessorAdjunto?
                cursos[idCurso]?.professorTitular = professores[idProfessorTitular] as ProfessorTitular?
            }
        } catch (e:NullPointerException){
            println("Erro ao acessar o objeto: " + e.message)
        } catch (e:Exception){
            println("Erro inesperado: " + e.message)
        }
    }
}
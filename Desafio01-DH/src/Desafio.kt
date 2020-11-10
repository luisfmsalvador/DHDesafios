fun main() {
    var digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarCurso("Ciências Contábeis", 1, 4)
    digitalHouseManager.registrarCurso("Administração", 2, 15)
    digitalHouseManager.registrarCurso("Gestão Comercial", 3, 12)
    digitalHouseManager.registrarCurso("Logística", 4, 14)
    digitalHouseManager.registrarCurso("Direito", 5, 11)

    println(digitalHouseManager.cursos.toString())

    digitalHouseManager.excluirCurso(3)

    println(digitalHouseManager.cursos.toString())

    digitalHouseManager.registrarProfessorTitular("Davi","Jones", 1, "SIG")
    digitalHouseManager.registrarProfessorTitular("David","Thompson", 2,"Matemática")
    digitalHouseManager.registrarProfessorTitular("Peterson","Climbert", 3,"Português instrumental")
    digitalHouseManager.registrarProfessorTitular("Joseph","Michel", 4,"Modal")
    digitalHouseManager.registrarProfessorTitular("Mark","Johson", 5,"Direito empresarial")

    digitalHouseManager.registrarProfessorAdjunto("Carlos","Silva",6, 20)
    digitalHouseManager.registrarProfessorAdjunto("Charles","Oliveira",7, 25)
    digitalHouseManager.registrarProfessorAdjunto("Claudemir","Santos",8, 10)
    digitalHouseManager.registrarProfessorAdjunto("Cleberson","Cavalcanti",9, 18)

    digitalHouseManager.excluirProfessor(4)

    println(digitalHouseManager.professores.toString())

    digitalHouseManager.matricularAluno("Aluno", "da Silva", 1)
    digitalHouseManager.matricularAluno("Aluno", "dos Santos", 2)
    digitalHouseManager.matricularAluno("Aluno", "Cavacante", 3)
    digitalHouseManager.matricularAluno("Aluno", "Toledo", 4)
    digitalHouseManager.matricularAluno("Aluno", "Pereira", 5)

    println(digitalHouseManager.alunos.toString())

    digitalHouseManager.matricularAluno(1, 1)
    digitalHouseManager.matricularAluno(2, 1)
    digitalHouseManager.matricularAluno(3, 1)
    digitalHouseManager.matricularAluno(4, 1)
    digitalHouseManager.matricularAluno(5, 1)

    var aluno = digitalHouseManager.alunos[1]
    digitalHouseManager.cursos[1]?.excluirAluno(aluno!!)

    digitalHouseManager.matricularAluno(5, 1)

    println(digitalHouseManager.matriculas.toString())

    digitalHouseManager.alocarProfessores(1, 1, 6)

    println(digitalHouseManager.cursos[1]?.professorAdjunto?.nome)
    println(digitalHouseManager.cursos[1]?.professorTitular?.nome)
}
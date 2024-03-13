import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MembroEquipe membro1 = new MembroEquipe("João");
        MembroEquipe membro2 = new MembroEquipe("Maria");
        MembroEquipe membro3 = new MembroEquipe("Jose");

        LiderEquipe lider1 = new LiderEquipe("Pedro");
        LiderEquipe lider2 = new LiderEquipe("Paulo");

        Tarefa<MembroEquipe> tarefa1 = new Tarefa<>("Desenvolvimento de código", membro1);
        Tarefa<MembroEquipe> tarefa2 = new Tarefa<>("Correção de bugs", membro2);
        Tarefa<LiderEquipe> tarefa3 = new Tarefa<>("Revisão de código", lider1);
        Tarefa<MembroEquipe> tarefa4 = new Tarefa<>("Identação do código", membro2);

        List<Tarefa<MembroEquipe>> tarefas = new ArrayList<>();
        List<Tarefa<LiderEquipe>> tarefasLider = new ArrayList<>();

        /////adicione as tarefas na lista
        tarefas.add(tarefa1);
        tarefas.add(tarefa2);
        tarefasLider.add(tarefa3);
        tarefas.add(tarefa4);

        double cargaJoao = calcularCargaDeTrabalho(tarefas, membro1);
        double cargaMaria = calcularCargaDeTrabalho(tarefas, membro2);
        double cargaPedro = calcularCargaDeTrabalho(tarefasLider, lider1);
        double cargaJose = calcularCargaDeTrabalho(tarefas, membro3);
        double cargaPaulo = calcularCargaDeTrabalho(tarefasLider, lider2);

        System.out.println("Carga de trabalho do João: " + cargaJoao + " tarefa(s).");
        System.out.println("Carga de trabalho da Maria: " + cargaMaria + " tarefa(s).");
        System.out.println("Carga de trabalho do Pedro: " + cargaPedro + " tarefa(s).");
        System.out.println("Carga de trabalho do Jose: " + cargaJose + " tarefa(s).");
        System.out.println("Carga de trabalho do Paulo: " + cargaPaulo + " tarefa(s).");
    }

    public static <T> double calcularCargaDeTrabalho(List<Tarefa<T>> tarefas, T membro) {
        int carga = 0;
        for (Tarefa<T> tarefa : tarefas) {
            if (tarefa.getResponsavelTarefa().equals(membro)) {
                carga++;
            }
        }
        return carga;
    }
}
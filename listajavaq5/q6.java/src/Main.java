import java.util.ArrayList;//importa a classe ArrayList,usada para criar a fila
import java.util.Collections;//importa a classe Collections,usada para ordenar a fila

enum Ticket {
    ADULTO,
    CRIANÇA;//cria um enum com os tipos de tickets
}

abstract class Pessoa implements Comparable<Pessoa> {
    protected int idade;
    protected String nome;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public abstract Ticket getTicketType();

    @Override
    public int compareTo(Pessoa pessoa) {
        return pessoa.idade - this.idade; //o retorno do compareTo() foi alterado para comparar pela inverter a ordem,se fosse no comum ia ficar crescente
    }//o resto do código é o de uma fila comum

    public String getName() {
        return nome;
    }

    public int getAge() {
        return idade;
    }

    @Override
    public String toString() {
        return nome + ": " + idade + "[" + getTicketType() + "]";
    }
}

class Adulto extends Pessoa {
    public Adulto(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public Ticket getTicketType() {
        return Ticket.ADULTO;
    }
}

class Criança extends Pessoa {
    public Criança(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public Ticket getTicketType() {
        return Ticket.CRIANÇA;
    }
}

class Queue<T extends Pessoa> {
    private ArrayList<T> pessoas;//usa o T para poder usar tanto adulto quanto criança

    public Queue() {
        this.pessoas = new ArrayList<>(10);//inicia com 10
    }

    public void push(T pessoa) {
        pessoas.add(pessoa);
        Collections.sort(pessoas); // Ordena automaticamente pela idade (mais velho primeiro,ja q o compareTo foi invertido)
    }

    public T pop() {
        if (!isEmpty()) {
            return pessoas.remove(0);
        } 
        else {
            return null; 
        }
    }

    public boolean isEmpty() {
        return pessoas.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Pessoa> fila = new Queue<>();

        fila.push(new Criança("Pedro", 5));
        fila.push(new Adulto("Ingridt", 30));
        fila.push(new Criança("João", 8));
        fila.push(new Adulto("Enzo", 20));
        fila.push(new Criança("Ana", 6));

        System.out.println("Fila:");

        while (!fila.isEmpty()) {
            Pessoa p = fila.pop();
            System.out.println(p);
        }
    }
}

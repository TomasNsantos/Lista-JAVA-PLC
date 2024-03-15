        /////////public class Main {
//cria classe abstrata do cafe
    abstract class Coffee {
        String name;
        double waterRequired;
        double milkRequired;
        double coffeeRequired;
    
        Coffee(double water, double milk, double coffee, String nm){
            waterRequired = water;
            milkRequired = milk;
            coffeeRequired = coffee;
            name = nm;
        }
    
        public abstract void prepare();

        public String getName() {
            return name;
        }
    
        public double getWaterRequired() {
            return waterRequired;
        }
    
        public double getMilkRequired() {
            return milkRequired;
        }
    
        public double getCoffeeRequired() {
            return coffeeRequired;
        }
    }

    //cria classes dos tipos de cafe
    class Expresso extends Coffee {
        Expresso(){
            super(100, 0, 50, "Expresso");
        }
        
        @Override
        public void prepare(){
            System.out.println("Preparando um " + super.getName() + " :");
            System.out.println("Aqueça " + super.getWaterRequired() + "ml de Água");
            System.out.println("Adicione " + super.getCoffeeRequired() + "g de Café");
            System.out.println("Sirva em uma xícara de " + super.getName());
        }
    }

    class Latte extends Coffee {
        Latte(){
            super(0, 100, 45, "Latte");
        }
        
        @Override
        public void prepare(){
            System.out.println("Preparando um " + super.getName() + " :");
            System.out.println("Aqueça " + super.getMilkRequired() + "ml de Leite");
            System.out.println("Adicione " + super.getCoffeeRequired() + "g de Café");
            System.out.println("Sirva em uma xícara de " + super.getName());
        }
    }

    class Capuccino extends Coffee {
        Capuccino(){
            super(100, 100, 75, "Capuccino");
        }
        
        @Override
        public void prepare(){
            System.out.println("Preparando um " + super.getName() + " :");
            System.out.println("Aqueça " + super.getWaterRequired() + "ml de Água");
            System.out.println("Adicione " + super.getMilkRequired() + "ml de Leite");
            System.out.println("Adicione " + super.getCoffeeRequired() + "g de Café");
            System.out.println("Sirva em uma xícara de " + super.getName());
        }
    }

    //cria a maquina de cafe
    class CoffeeMachine {
        double water;
        double milk;
        double coffee;
    
        CoffeeMachine(double water, double milk, double coffee){
            this.water = water;
            this.milk = milk;
            this.coffee = coffee;
        }
    
        public void makeCoffee(Coffee coffee)  {
            if(this.water >= coffee.getWaterRequired() && this.milk >= coffee.getMilkRequired() && this.coffee >= coffee.getCoffeeRequired()){
                this.water -= coffee.getWaterRequired();
                this.milk -= coffee.getMilkRequired();
                this.coffee -= coffee.getCoffeeRequired();
                coffee.prepare();
            } else {
                //throw new NotEnoughException("Não há recursos suficientes para preparar o café " + coffee.getName());
                System.out.println("\nNão há recursos suficientes para preparar o café " + coffee.getName());
            }
            System.out.println("\nResta isso na máquina :\n" + this.getResources() + "\n");
        }
    
        public String getResources(){
            //System.out.println("o que sobrou na máquina de café: ");
            return "Água: " + this.water + "ml\nLeite: " + this.milk + "ml\nCafé: " + this.coffee + "g";
        }
    
        public void setResources(double water, double milk, double coffee){
            this.water = water;
            this.milk = milk;
            this.coffee = coffee;
        }
    }

    //cria excecao
    class NotEnoughException extends Exception {
        public NotEnoughException(String message){
            super(message);
        }
    }

public class Main {
    public static void main(String[] args)  {

        ////////////////////////////////
        // Primeira Máquina de Café
        CoffeeMachine coffeeMachine = new CoffeeMachine(200,200,170);

        // Prepara um café de cada tipo

        Expresso expresso = new Expresso();
        coffeeMachine.makeCoffee(expresso);

        Latte latte = new Latte();
        coffeeMachine.makeCoffee(latte);

        Capuccino capuccino = new Capuccino();
        coffeeMachine.makeCoffee(capuccino);
        coffeeMachine.makeCoffee(capuccino);

        // Imprime o que sobrou na máquina de café
        System.out.println("\nao final,sobrou isso na máquina de café: \n");
        System.out.println(coffeeMachine.getResources());

    }
}

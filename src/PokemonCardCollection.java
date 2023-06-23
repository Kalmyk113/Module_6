import acm.program.ConsoleProgram;
import java.util.random.RandomGenerator;

public class PokemonCardCollection extends ConsoleProgram {

    private PokemonCards pokeDeck;
    private PokemonCanvas canvas;
    private RandomGenerator rgen;
    private String name;

    public void run() {
        // use pokeDeck.get(index) to get a certain pokemon
        pokeDeck = new PokemonCards();
        int choice;

        do {


            println("Choose an Option: ");
            println("1 - Remove a Pokemon: ");
            println("2 - View a Pokemon: ");
            println("3 - View Slideshow of Pokemon: ");
            println("4 - Search a Pokemon: ");
            println("5 - Quit: ");
            choice = readInt("Choice: ");

            switch(choice) {
                case 1:
                    break;
                case 2: //view Pokemon Randomly
                    break;
                case 3:
                    break;
                case 4: //search Pokemon
                    name = readLine("Enter a Pokemon Name: ");
                    if(pokeDeck.searchPokemon(name) < 0){
                        println("Pokemon Not in Collection");
                    } else {
                        println("Attack: " + pokeDeck.get(pokeDeck.searchPokemon(name)).getAtk());
                        println("Defense: " + pokeDeck.get(pokeDeck.searchPokemon(name)).getDef());
                        println("Speed: " + pokeDeck.get(pokeDeck.searchPokemon(name)).getSpd());
                    }
                    break;
                case 5:
                    println("Thank You for Using the Program");
                    readLine();
                    exit();
                    break;
                default:
                    println("Invalid Input");
                    break;
            }

        } while (choice != 5);

    }

    public void init() {
        canvas = new PokemonCanvas(); // Responsible for displaying the cards
        add(canvas);
        setTitle("Pokemon Card Collection");
        setSize(1280, 720);
    }

    public static void main(String[] args)
    {
        (new PokemonCardCollection()).start(args);
    }
}



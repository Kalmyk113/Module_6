import acm.graphics.GImage;
import acm.program.ConsoleProgram;
import java.util.random.RandomGenerator;

public class PokemonCardCollection extends ConsoleProgram {

    private PokemonCards pokeDeck;
    private PokemonCanvas canvas;
    private RandomGenerator rgen = RandomGenerator.getDefault();
    private String name;
    private GImage pokePic;

    public void run() {
        // use pokeDeck.get(index) to get a certain pokemon
        pokeDeck = new PokemonCards();
        int choice;

        do {
            println("--------------------------------------");
            println("Choose an Option: ");
            println("1 - Remove a Pokemon: ");
            println("2 - View a Pokemon: ");
            println("3 - View Slideshow of Pokemon: ");
            println("4 - Search a Pokemon: ");
            println("5 - Quit: ");
            choice = readInt("Choice: ");
            println("--------------------------------------");

            switch(choice) {
                case 1:
                    name = readLine("Enter a Pokemon Name to Delete: ");
                    name = name.toUpperCase();
                    if(pokeDeck.searchPokemon(name) == -1){
                        println("Pokemon Not in Collection");
                    }else{
                        println(pokeDeck.get(pokeDeck.searchPokemon(name)).getName() + "has been removed");
                        pokeDeck.removePokemon(pokeDeck.searchPokemon(name));
                        System.out.println(pokeDeck.getSize());
                    }
                    break;

                case 2: //view Pokemon Randomly
                    canvas.clear();
                    int random = rgen.nextInt(0, pokeDeck.getSize());
                    canvas.displayTypeBg(pokeDeck.get(random).getType());
                    canvas.displayTemplate();
                    canvas.displayDetails(pokeDeck.get(random).getName(),pokeDeck.get(random).getWeight(),pokeDeck.get(random).getHeight());
                    canvas.displayStats(
                            pokeDeck.get(random).getHp(),
                            pokeDeck.get(random).getAtk(),
                            pokeDeck.get(random).getDef(),
                            pokeDeck.get(random).getSpA(),
                            pokeDeck.get(random).getSpD(),
                            pokeDeck.get(random).getSpe(),
                            pokeDeck.get(random).getTotBS()
                    );
                    canvas.displayImage(pokeDeck.get(random).getName());
                    break;

                case 3: //slideshow
                    for(int i=0; i<pokeDeck.getSize(); i++){
                        canvas.clear();
                        canvas.displayTypeBg(pokeDeck.get(i).getType());
                        canvas.displayTemplate();
                        canvas.displayDetails(pokeDeck.get(i).getName(),pokeDeck.get(i).getWeight(),pokeDeck.get(i).getHeight());
                        canvas.displayStats(
                                pokeDeck.get(i).getHp(),
                                pokeDeck.get(i).getAtk(),
                                pokeDeck.get(i).getDef(),
                                pokeDeck.get(i).getSpA(),
                                pokeDeck.get(i).getSpD(),
                                pokeDeck.get(i).getSpe(),
                                pokeDeck.get(i).getTotBS()
                        );
                        canvas.displayImage(pokeDeck.get(i).getName());
                        pause(3000);
                    }
                    break;

                case 4: //search Pokemon
                    name = readLine("Enter a Pokemon Name: ");
                    name = name.toUpperCase();
                    if(pokeDeck.searchPokemon(name) == -1){
                        println("Pokemon Not in Collection");
                    } else {
                        canvas.clear();
                        canvas.displayTypeBg(pokeDeck.get(pokeDeck.searchPokemon(name)).getType());
                        canvas.displayTemplate();
                        canvas.displayDetails(pokeDeck.get(pokeDeck.searchPokemon(name)).getName(),pokeDeck.get(pokeDeck.searchPokemon(name)).getWeight(),pokeDeck.get(pokeDeck.searchPokemon(name)).getHeight());
                        canvas.displayStats(
                                pokeDeck.get(pokeDeck.searchPokemon(name)).getHp(),
                                pokeDeck.get(pokeDeck.searchPokemon(name)).getAtk(),
                                pokeDeck.get(pokeDeck.searchPokemon(name)).getDef(),
                                pokeDeck.get(pokeDeck.searchPokemon(name)).getSpA(),
                                pokeDeck.get(pokeDeck.searchPokemon(name)).getSpD(),
                                pokeDeck.get(pokeDeck.searchPokemon(name)).getSpe(),
                                pokeDeck.get(pokeDeck.searchPokemon(name)).getTotBS()
                        );
                        canvas.displayImage(pokeDeck.get(pokeDeck.searchPokemon(name)).getName());
                    }
                    break;
                case 5: //Exit
                    println("Thank You for Using the Program");
                    println("--------------------------------------");
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
        canvas.reset();
    }

    public static void main(String[] args)
    {
        (new PokemonCardCollection()).start(args);
    }
}



import acm.program.ConsoleProgram;

public class PokemonCardCollection extends ConsoleProgram {

    private PokemonCards pokeDeck;
    private PokemonCanvas canvas;

    public void run(){
        pokeDeck = new PokemonCards();
        println(pokeDeck);
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



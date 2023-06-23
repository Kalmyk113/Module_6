import acm.graphics.GCanvas;
import acm.graphics.GLabel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PokemonCanvas extends GCanvas {

    private static final int TEXT_HEIGHT = 15;   // you can modify this to suit your ascii art
    private static final int TEXT_X_OFFSET = 10;   // you can modify this to suit your ascii art
    private int textX;
    private int textY;

    public void reset() {
        // Sample graphics object
        GLabel testMessage = new GLabel("Pokedex testing\n");
        textX = TEXT_X_OFFSET;
        textY = TEXT_HEIGHT;
        add(testMessage, textX, textY);

        GLabel nextMessage = new GLabel("\n");
        textY += TEXT_HEIGHT;
        add(nextMessage, textX, textY);
    }
}

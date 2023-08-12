import acm.graphics.*;

import java.awt.*;

public class PokemonCanvas extends GCanvas {

    private static final int TEXT_HEIGHT = 15;   // you can modify this to suit your ascii art
    private static final int TEXT_X_OFFSET = 10;   // you can modify this to suit your ascii art
    private int textX;
    private int textY;
    private GLabel stat;
    private GLabel statActual;
    private String type1;
    private String type2;
    double offset;

    public void reset() {
    }

    //displays blank slate with corresponding type color
    public void displayTemplate(){
        offset = 0;
        GRoundRect stats = new GRoundRect(30,400,getWidth()-60,220,40);
        stats.setFilled(true);
        stats.setFillColor(typeColor(type1, 230));
        add(stats);

        for(int i=0; i<7; i++){
            switch(i){
                case 0:
                    stat = new GLabel("HP");
                    break;
                case 1:
                    stat = new GLabel("Attack");
                    break;
                case 2:
                    stat = new GLabel("Defense");
                    break;
                case 3:
                    stat = new GLabel("Sp.Atk");
                    break;
                case 4:
                    stat = new GLabel("Sp.Def");
                    break;
                case 5:
                    stat = new GLabel("Speed");
                    break;
                case 6:
                    stat = new GLabel("Total");
                    break;
                default:
                    break;
            }
            stat.setFont("courier new-bold-22");
            add(stat,40,435+offset);

            if(i != 6){
                GLine divide = new GLine(40,435+offset+stat.getHeight()/4,getWidth()-40,435+offset+stat.getHeight()/4);
                divide.setColor(Color.gray);
                add(divide);
            }

            offset += stat.getHeight()+3;
        }
    }

    //displays name, weight, and height
    public void displayDetails(String name, String weight, String height){

        GLabel pokeName = new GLabel(name);
        pokeName.setFont("courier new-bold-22");
        GRoundRect nameBg = new GRoundRect(30,20,pokeName.getWidth()+20,40,25);
        nameBg.setFilled(true);
        nameBg.setFillColor(typeColor(type1, 230));
        add(nameBg);
        add(pokeName,30+(nameBg.getWidth()- pokeName.getWidth())/2,20+pokeName.getHeight());

        GRoundRect wnh = new GRoundRect(30,150,125,150,25);
        wnh.setFilled(true);
        wnh.setFillColor(typeColor(type1, 230));
        add(wnh);

        GLabel pokeWeightLabel = new GLabel("Weight:");
        GLabel pokeWeight = new GLabel(weight);
        pokeWeightLabel.setFont("courier new-bold-22");
        pokeWeight.setFont("courier new-bold-22");

        GLabel pokeHeightLabel = new GLabel("Height:");
        GLabel pokeHeight = new GLabel(height);
        pokeHeightLabel.setFont("courier new-bold-22");
        pokeHeight.setFont("courier new-bold-22");

        add(pokeWeightLabel,40,160+ pokeWeightLabel.getHeight());
        add(pokeWeight,40,160+ pokeWeightLabel.getHeight()+ pokeWeight.getHeight());

        add(pokeHeightLabel,40,170+ pokeWeightLabel.getHeight()+ pokeWeight.getHeight()+pokeHeightLabel.getHeight());
        add(pokeHeight,40,170+ pokeWeightLabel.getHeight()+ pokeWeight.getHeight()+pokeHeightLabel.getHeight()+pokeHeight.getHeight());

    }

    //displays combat stats
    public void displayStats(int hp, int atk, int def, int spa, int spd, int spe, int bastot){

        for(int i=0; i<7; i++){

            GRoundRect statBar = new GRoundRect(375,10);
            statBar.setFilled(true);
            statBar.setFillColor(Color.gray);

            GRoundRect statBarFilled = new GRoundRect(375,10);
            statBarFilled.setFilled(true);
            statBarFilled.setFillColor(Color.red);

            switch(i){
                case 0:
                    statActual = new GLabel(Integer.toString(hp));
                    statBarFilled.setSize(375*hp/255,10);
                    break;
                case 1:
                    statActual = new GLabel(Integer.toString(atk));
                    statBarFilled.setSize(375*atk/255,10);
                    break;
                case 2:
                    statActual = new GLabel(Integer.toString(def));
                    statBarFilled.setSize(375*def/255,10);
                    break;
                case 3:
                    statActual = new GLabel(Integer.toString(spa));
                    statBarFilled.setSize(375*spa/255,10);
                    break;
                case 4:
                    statActual = new GLabel(Integer.toString(spd));
                    statBarFilled.setSize(375*spd/255,10);
                    break;
                case 5:
                    statActual = new GLabel(Integer.toString(spe));
                    statBarFilled.setSize(375*spe/255,10);
                    break;
                case 6:
                    statActual = new GLabel(Integer.toString(bastot));
                    break;
                default:
                    break;
            }

            statActual.setFont("courier new-bold-22");
            add(statActual,525,435+29.167*i);

            if(i != 6){
                add(statBar,140,420+29.167*i);
                add(statBarFilled,140,420+29.167*i);
            }
        }
    }

    //displays the image of the pokemon
    public void displayImage(String pokeName){
        pokeName=pokeName.toLowerCase() + ".png";
        GImage pokemon = new GImage("assets/" + pokeName);
        pokemon.scale(0.5);

        add(pokemon,getWidth()/2-pokemon.getWidth()/2,getHeight()/2-pokemon.getHeight());
    }

    //displays the background for the pokemon's corresponding typing
    public void displayTypeBg(String type){
        if(checkDualType(type)){

            for(int x=0; x<5; x++){
                for(int y=0; y<5; y++){
                    GRect test = new GRect(120,120);
                    test.setFillColor(typeColor(type2, 200));
                    test.setFilled(true);
                    add(test,-15 + 1.4*y*test.getWidth(),-5 +1.4*x*test.getHeight());
                    test.rotate(45);
                    test.sendToBack();
                }
            }
        }

        GImage typeBg = new GImage("assets/" + type1 + ".png");
        add(typeBg,getWidth()/2-typeBg.getWidth()/2,getHeight()/2-typeBg.getHeight()/2);
        typeBg.sendToBack();
    }

    //checks for dual typings
    public boolean checkDualType(String type){
        if(type.contains("-")){
            String[] split = type.split("-");
            this.type1= split[0];
            this.type2= split[1];
            return true;

        }else{
            this.type1=type;
            return false;
        }
    }

    //colors for different pokemon types
    public Color typeColor(String type, int a){
        return switch (type) {
            case "Normal" -> new Color(168, 167, 122, a);
            case "Fire" -> new Color(238, 129, 48, a);
            case "Water" -> new Color(99, 144, 240, a);
            case "Electric" -> new Color(247, 208, 44, a);
            case "Grass" -> new Color(122, 199, 76, a);
            case "Ice" -> new Color(150, 217, 214, a);
            case "Fighting" -> new Color(194, 46, 40, a);
            case "Poison" -> new Color(163, 62, 161, a);
            case "Ground" -> new Color(226, 191, 44, a);
            case "Flying" -> new Color(169, 143, 243, a);
            case "Psychic" -> new Color(247, 85, 135, a);
            case "Bug" -> new Color(166, 185, 26, a);
            case "Rock" -> new Color(182, 161, 54, a);
            case "Ghost" -> new Color(115, 87, 151, a);
            case "Dragon" -> new Color(111, 53, 252, a);
            case "Dark" -> new Color(112, 88, 72, a);
            case "Steel" -> new Color(183, 183, 206, a);
            case "Fairy" -> new Color(214, 133, 173, a);
            default -> new Color(0, 0, 0, a);
        };
    }

    public Color typeColor(String type){
        return typeColor(type, 255);
    }


}

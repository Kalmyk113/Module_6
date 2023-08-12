import acm.graphics.GImage;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PokemonCards {

    private ArrayList<Pokemon> list;
    private Scanner sc;

    public PokemonCards() {

        list = new ArrayList<>();
        try{
            File file = new File("Pokemon.txt");
            sc = new Scanner(file);
            while(sc.hasNext()){
                String line = sc.nextLine();
                String[] arr = line.split(",");

                int hp = Integer.parseInt(arr[3]);
                int atk = Integer.parseInt(arr[4]);
                int def = Integer.parseInt(arr[5]);
                int spA = Integer.parseInt(arr[6]);
                int spD = Integer.parseInt(arr[7]);
                int spe = Integer.parseInt(arr[8]);
                int totBS = Integer.parseInt(arr[9]);

                Class myClass = Class.forName(arr[0]);
                //weight, height, HP, Attack, Defense, Sp.A, Sp.D, Speed, TotalBS
                Constructor constructor = myClass.getConstructor(String.class, String.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, String.class);
                Object instance = constructor.newInstance(arr[1], arr[2], hp, atk, def, spA, spD, spe, totBS, arr[10]);
                list.add((Pokemon) instance);
            }

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public Pokemon get(int pokeIndex){
        return list.get(pokeIndex);
    }

    public int getSize(){
        return list.size();
    }

    public int searchPokemon(String inputPokemon){
        for(int i=0; i<list.size(); i++){
            if(Objects.equals(list.get(i).getName(), inputPokemon)){
                return i;
            }
        }
        return -1;
    }


    public void removePokemon(int pokeIndex){
        list.remove(pokeIndex);
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < list.size(); i++){
            str = str + list.get(i).getName()+ " " + list.get(i).getType();
            str = str + "Atk: " + list.get(i).getAtk();
            str = str + "\n";
        }
        return str;
    }

}

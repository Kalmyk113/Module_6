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

                int atk = Integer.parseInt(arr[3]);
                int def = Integer.parseInt(arr[4]);
                int spd = Integer.parseInt(arr[5]);

                Class myClass = Class.forName(arr[0]);
                Constructor constructor = myClass.getConstructor(String.class, String.class, int.class, int.class, int.class);
                Object instance = constructor.newInstance(arr[1], arr[2], atk, def, spd);
                list.add((Pokemon) instance);
            }

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public Pokemon get(int index){
        return list.get(index);
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

    public void showPokemon(String name){

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

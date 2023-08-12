/*Format:
    HP, Attack, Defense, Sp.A, Sp.D, Speed, TotalBS
  txt file format:
    Name, weight, height, HP, Attack, Defense, Sp.A, Sp.D, Speed, TotalBS, type
*/

public abstract class Pokemon {

    protected String name;
    protected String type;
    protected String height;
    protected String weight;

    protected int hp;
    protected int atk;
    protected int def;
    protected int spA;
    protected int spD;
    protected int spe;
    protected int totBS;

    public String getName() {
        return name;
    }
    public String getHeight() {
        return height;
    }
    public String getWeight() {
        return weight;
    }
    public String getType() {
        return type;
    }
    public int getHp() {
        return hp;
    }
    public int getAtk() {
        return atk;
    }
    public int getDef() {
        return def;
    }
    public int getSpA() {
        return spA;
    }
    public int getSpD() {
        return spD;
    }
    public int getSpe() {
        return spe;
    }
    public int getTotBS() {
        return totBS;
    }


}

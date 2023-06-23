public abstract class Pokemon {

    protected String name;
    protected String type;
    protected String height;
    protected String weight;

    protected int atk;
    protected int def;
    protected int spd;

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

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getSpd() {
        return spd;
    }
}

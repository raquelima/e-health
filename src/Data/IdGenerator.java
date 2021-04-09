package Data;

public class IdGenerator {
    private int identtity = 1;

    public IdGenerator() {
    }

    public String getID(){
        String id = String.format("%03d",identtity);
        identtity++;
        return id;
    }
    public String getID(int presentID){
        String id = String.format("%03d",presentID);
        return id;
    }

    public void setNewId() {
        identtity = identtity -1;
    }
}

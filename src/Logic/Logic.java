package Logic;

public class Logic {

    private int identtity = 1;


    public Logic() {
    }

    public boolean checkPW(String text){
        boolean check = false;
        if(text.equals("e-health")){
            check = true;
        }
        return check;
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

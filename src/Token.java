import java.util.Random;

import java.util.ArrayList;


public class Token {

    static ArrayList<String> chips = new ArrayList<>();
    private String tokenType;
    
    
    

    public Token() {
        chips.add("RedPlanet.PNG");
        chips.add("RedBall.PNG");
        chips.add("YellowStar.PNG");
        chips.add("BlueTriangle.PNG");
        chips.add("GreenTriangle.PNG");
        chips.add("GreenStar.PNG");
        chips.add("BluePLanetWithLWall.PNG");
        chips.add("YellowBallWithTWall.PNG");
        chips.add("YellowTriangle.PNG");
        chips.add("YellowPlanet.PNG");
        chips.add("VortexRightWall.PNG");
        chips.add("RedTriangle.PNG");
        chips.add("GreenBallLWall.PNG");
        chips.add("GreenPlanet.PNG");
        chips.add("BlueBall.PNG");
        chips.add("BlueStarTWall.PNG");
        chips.add("RedStar.PNG");
        
    }
    
    public static String getToken() {
        Random rand = new Random();
        String output = chips.get(rand.nextInt(17));
        chips.remove(output);
        return output;
    }
    
    
    
}
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MakeVariations {
        
                


    public static void main(String[] args) throws IOException {
        Cube solved = new Cube();
        char[] tmp = {'n','n','n','n'};
        Cube temp = new Cube(tmp,tmp,tmp,tmp,tmp,tmp);
        for (Cube layer1 : makeState(solved, temp)) {
           makeState(layer1, solved);
        }
    }     
    static ArrayList<String> appearence = new ArrayList<>(); 
public static ArrayList<Cube> makeState(Cube parentCube, Cube grandParent) throws IOException {
        try (FileWriter adjWriter = new FileWriter("AsjencyList.txt", true)) {
            Cube u = new Cube().copy(parentCube).u();
            Cube uP = new Cube().copy(parentCube).uPrime();
            Cube f = new Cube().copy(parentCube).f();
            Cube fP = new Cube().copy(parentCube).fPrime();
            Cube d = new Cube().copy(parentCube).d();
            Cube dP = new Cube().copy(parentCube).uPrime();
            Cube r = new Cube().copy(parentCube).r();
            Cube rP = new Cube().copy(parentCube).rPrime();
            Cube b = new Cube().copy(parentCube).b();
            Cube bP = new Cube().copy(parentCube).bPrime();
            Cube l = new Cube().copy(parentCube).l();
            Cube lP = new Cube().copy(parentCube).lPrime();
            Cube[] variations = {u,uP,f,fP,d,dP,r,rP,b,bP,l,lP};
            String[] vString = {"U", "U'", "F", "F'", "D", "D'", "R", "R'", "B","B'", "L", "L'"};
            ArrayList<Cube> child = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                if (!variations[i].tocode().equals(grandParent.tocode())) {
                    child.add(variations[i]);
                    adjWriter.write(variations[i].tocode()  + "@" + parentCube.tocode()  + "@" + vString[i]  + "\n");
                }
        
            }
            
            return child;

            }catch (IOException e) {
                e.printStackTrace();

        }
        return null;
        
    }
}



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Solver {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("AsjencyList.txt");
        Scanner scanner = new Scanner(file);
        Scanner input = new Scanner(System.in);
        HashMap<String,String[]> states = new HashMap<>();
        char[] top = new char[4];
        char[] front = new char[4];
        char[] bottom = new char[4];
        char[] right = new char[4];
        char[] back = new char[4];
        char[] left = new char[4];        
        while(scanner.hasNextLine()){
            String[] line = scanner.nextLine().split("@");
            String[] value = {line[1],line[2]};
            states.put(line[0],value);
        }
        System.out.println("Top: ");
        for(int i = 0; i < 4; i++){
            top[i] = input.next().charAt(0);
        }
        System.out.println("Front: ");
        for(int i = 0; i < 4; i++){
            front[i] = input.next().charAt(0);
        }
        System.out.println("Bottom: ");
        for(int i = 0; i < 4; i++){
            bottom[i] = input.next().charAt(0);
        }
        System.out.println("Right: ");
        for(int i = 0; i < 4; i++){
            right[i] = input.next().charAt(0);
        }
        System.out.println("Back: ");
        for(int i = 0; i < 4; i++){
            back[i] = input.next().charAt(0);
        }
        System.out.println("Left: ");
        for(int i = 0; i < 4; i++){
            left[i] = input.next().charAt(0);
        }
        Cube problem = new Cube(top, front, bottom, right, back, left);
        Cube solved = new Cube();
        String key = problem.tocode();
        String solvedCube = solved.tocode();
        ArrayList<String> steps = new ArrayList<>();
        while(!states.get(key)[0].equals(solvedCube)){
            steps.add(states.get(key)[1]);
            key = states.get(key)[0];
        }
        System.out.println("The solution is: ");
        steps.add(states.get(key)[1]);
        for (String move : steps) {
                if (move.length() >1) {
                    System.out.println(move.charAt(0));
                }else{
                    System.out.println(move + "'");
                }                    
        
            
        }
    
}
}

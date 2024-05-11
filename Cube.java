import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Cube {
    char[] top;
    char[] front;
    char[] bottom;
    char[] right;
    char[] back;
    char[] left;
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
            // while(!states.get(key)[0].equals(solvedCube)){
            //     steps.add(states.get(key)[1]);
            //     key = states.get(key)[0];
            // }
            for(int i = 0; i < 11; i++){
                System.out.println(key);
                if(states.get(key)[0].equals(solvedCube)){
                    break;
                };
                steps.add(states.get(key)[1]);
                key = states.get(key)[0];
            }
            System.out.println("The solution is: ");
            if(!steps.isEmpty()){
                for (String move : steps) {
                        if (move.contains("'")) {
                            move.replace("'", "");
                        }else{
                            move += "'";
                        }
                        System.out.println(move);
                }
            }
            if (states.get(key)[1].contains("'")) {
                states.get(key)[1].replace("'", "");
            }else{
                states.get(key)[1] += "'";
            }
            System.out.println(states.get(key)[1]);
        }
    

public Cube(char[] top, char[] front, char[] bottom, char[] right, char[] back, char[] left) {
        this.top = top;
        this.front = front;
        this.bottom = bottom;
        this.right = right;
        this.back = back;
        this.left = left;
    }
public Cube(){
      top = new char[] {'W', 'W', 'W', 'W'};
      front = new char[] {'G', 'G', 'G', 'G'};
      bottom = new char[] {'Y', 'Y', 'Y', 'Y'};
      right = new char[] {'R', 'R', 'R', 'R'};
      back = new char[] {'B', 'B', 'B', 'B'};
      left = new char[] {'O', 'O', 'O', 'O'};
        }
public void swapcolorOnSide(char[] side){
    char temp1 = side[3];
    side[3] = side[1];
    side[1] = side[0];
    side[0] = side[2];
    side[2] = temp1;
}

public void swapReverseOnSide(char[] side){
    char temp1 = side[3];
    side[3] = side[2];
    side[2] = side[0];
    side[0] = side[1];
    side[1] = temp1;
}

public void swapCubeless(char[] side1, char[] side2, int num1, int num2, int num3 ,int num4){
    side1[num1] = side2[num2];
    side1[num3] = side2[num4];

}
 public Cube u(){
        swapcolorOnSide(top);
        char temp1 = front[0];
        char temp2 = front[1];
        swapCubeless(front, right, 0, 0, 1, 1);
        swapCubeless(right, back, 0, 0, 1, 1);
        swapCubeless(back, left, 0, 0, 1, 1);
        left[0] = temp1;
        left[1] = temp2;
        Cube newcube = new Cube(top, front, bottom, right, back, left);
        return newcube;
    }
public Cube uPrime(){
    swapReverseOnSide(top);
    char temp1 = front[0];
    char temp2 = front[1];
    swapCubeless(front, left, 0, 0, 1, 1);
    swapCubeless(left, back, 0, 0, 1, 1);
    swapCubeless(back, right, 0, 0, 1, 1);
    right[0] = temp1;
    right[1] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
    }
public Cube d(){
    swapcolorOnSide(bottom);
    char temp1 = front[2];
    char temp2 = front[3];
    swapCubeless(front, left, 2, 2, 3, 3);
    swapCubeless(left, back, 2, 2, 3, 3);
    swapCubeless(back, right, 2, 2, 3, 3);
    right[2] = temp1;
    right[3] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;

}
public Cube dPrime(){
    swapReverseOnSide(bottom);
    char temp1 = front[2];
    char temp2 = front[3];
    swapCubeless(front, right, 2, 2, 3, 3);
    swapCubeless(right, back, 2, 2, 3, 3);
    swapCubeless(back, left, 2, 2, 3, 3);
    left[2] = temp1;
    left[1] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;   
}
public Cube f(){
    swapcolorOnSide(front);
    char temp1 = top[2];
    char temp2 = top[3];
    swapCubeless(top, left, 2, 3, 3, 1);
    swapCubeless(left, bottom, 1, 0, 3, 1);
    swapCubeless(bottom, right, 0,2 , 1, 0);
    right[0] = temp1;
    right[2] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
}
public Cube fPrime(){
    swapReverseOnSide(front);
    char temp1 = top[3];
    char temp2 = top[2];
    swapCubeless(top, right, 2, 0, 3, 2);
    swapCubeless(right, bottom, 0, 2, 3, 0);
    swapCubeless(bottom, left, 0,1 , 1, 3);
    left[1] = temp1;
    left[3] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
}
public Cube b(){
    swapcolorOnSide(back);
    char temp1 = top[0];
    char temp2 = top[1];
    swapCubeless(top, right, 0, 1, 1, 3);
    swapCubeless(right, bottom, 1, 3, 3, 2);
    swapCubeless(bottom, left, 2,0 , 3, 2);
    left[2] = temp1;
    left[0] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
}
public Cube bPrime(){
    swapReverseOnSide(back);
    char temp1 = top[0];
    char temp2 = top[1];
    swapCubeless(top, left, 0, 2, 1, 0);
    swapCubeless(left, bottom, 0, 2, 2, 3);
    swapCubeless(bottom, right, 2,3 , 3, 1);
    right[1] = temp1;
    right[3] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
}
public Cube r(){
    swapcolorOnSide(right);
    char temp1 = front[1];
    char temp2 = front[3];
    swapCubeless(front, bottom, 1, 1, 3, 3);
    swapCubeless(bottom, back, 1, 2, 3, 0);
    swapCubeless(back, top, 0,3, 2, 1);
    top[1] = temp1;
    top[3] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
}
public Cube rPrime(){
    swapReverseOnSide(right);
    char temp1 = front[1];
    char temp2 = front[3];
    swapCubeless(front, top, 1, 1, 3, 3);
    swapCubeless(top, back, 1, 2, 3, 0);
    swapCubeless(back, bottom, 0,3, 2, 1);
    bottom[1] = temp1;
    bottom[3] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
}
public Cube l(){
    swapcolorOnSide(left);
    char temp1 = front[0];
    char temp2 = front[2];
    swapCubeless(front, top, 0, 0, 2, 2);
    swapCubeless(top, back, 0, 3, 2, 1);
    swapCubeless(back, bottom, 1,2, 3, 0);
    bottom[0] = temp1;
    bottom[2] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
}
public Cube lPrime(){
    swapReverseOnSide(left);
    char temp1 = front[0];
    char temp2 = front[2];
    swapCubeless(front, bottom, 0, 0, 2, 2);
    swapCubeless(bottom, back, 0, 3, 2, 1);
    swapCubeless(back, top, 1,2, 3, 0);
    top[0] = temp1;
    top[2] = temp2;
    Cube newcube = new Cube(top, front, bottom, right, back, left);
    return newcube;
}
public Cube copy(Cube parent) {
    char[] top = new char[4];
    char[] front = new char[4];
    char[] bottom = new char[4];
    char[] right = new char[4];
    char[] back = new char[4];
    char[] left = new char[4];
    System.arraycopy(parent.top, 0, top, 0, 4);
    System.arraycopy(parent.front, 0, front, 0, 4);
    System.arraycopy(parent.bottom, 0, bottom, 0, 4);
    System.arraycopy(parent.right, 0, right, 0, 4);
    System.arraycopy(parent.back, 0, back, 0, 4);
    System.arraycopy(parent.left, 0, left, 0, 4);
    Cube copy = new Cube(top, front, bottom, right, back, left);
    return copy;
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("   ").append(top[0]).append(top[1]).append("\n");
    sb.append("   ").append(top[2]).append(top[3]).append("\n");
    sb.append(left[0]).append(left[1]).append(" ").append(front[0]).append(front[1]).append(" ").append(right[0]).append(right[1]).append(" ").append(back[0]).append(back[1]).append("\n");  
    sb.append(left[2]).append(left[3]).append(" ").append(front[2]).append(front[3]).append(" ").append(right[2]).append(right[3]).append(" ").append(back[2]).append(back[3]).append("\n");
    sb.append("   ").append(bottom[0]).append(bottom[1]).append("\n");
    sb.append("   ").append(bottom[2]).append(bottom[3]).append("\n");
    return sb.toString();
}
public String tocode(){
    return Arrays.toString(top) + Arrays.toString(front) + Arrays.toString(bottom) + Arrays.toString(right) + Arrays.toString(back) + Arrays.toString(left);
} 
    }


        
    
  



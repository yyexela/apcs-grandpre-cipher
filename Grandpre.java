import java.util.Scanner;

class Grandpre{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Econding (0) or Decoding (1)?");
        byte mode = scan.nextByte();

        if(mode != 1 && mode != 0){
            System.out.println("Invalid mode");
        } else {
            System.out.println(grabInput(mode, scan));
        }
        
        
    }
    
    public static String grabInput(int mode, Scanner scan){
        if(mode == 0){
            System.out.println("Input original message");
            String input = scan.nextLine();
            input = scan.nextLine();
            return encryption(input);
        } else {
            System.out.println("Input encrypted message");
            String input = scan.nextLine();
            input = scan.nextLine();
            return decryption(input);
        }
    }

    public static String encryption (String input){
        String output = "";
        char crntLtr;
        int crntLtrPos, column;
        int row;

        for(int i = 0; i < input.length(); i++){
            crntLtr = input.charAt(i);
            crntLtrPos = (int) crntLtr;

            row = (int) (Math.random()*2 + 1);

            if(crntLtrPos >= 113 && crntLtrPos <= 122){
                //q-z, 1/4
                if(row == 1){
                    output = output + "1";
                } else {
                    output = output + "4";
                }
                column = crntLtrPos - 112;
                output = output + "" + column;
                
            } else if(crntLtrPos < 113 && crntLtrPos >= 107){
                //k-p 7/9
                if(row == 1){
                    output = output + "7";
                } else {
                    output = output + "9";
                }
                column = crntLtrPos - 106;
                output = output + "" + column;

            } else if(crntLtrPos < 107 && crntLtrPos >= 98){
                //b-k 2/5
                if(row == 1){
                    output = output + "2";
                } else {
                    output = output + "5";
                }
                column = crntLtrPos - 97;
                output = output + "" + column;

            } else {
                //a 8/10
                if(row == 1){
                    output = output + "8";
                } else {
                    output = output + "10";
                }
                output = output + "1";

            }
            output = output + " ";
        }
        return output;
    }

    public static String decryption (String input){
        input = input + " ";
        String output = "";
        char ltr1, ltr2, ltr3;
        int second;

        for (int i = 0; i < input.length(); i+=3){
            ltr1 = input.charAt(i);
            ltr2 = input.charAt(i+1);
            ltr3 = input.charAt(i+2);
            second = Character.getNumericValue(ltr2);
    
            if(ltr3 != ' '){
                second = Character.getNumericValue(ltr3);
                output = output + ((char) (second + 96));
                i++;
            }
            else if (ltr1 == '1' || ltr1 == '4'){
                output = output + ((char) (second + 112));
            }
            else if (ltr1 == '7' || ltr1 == '9'){
                output = output + ((char) (second + 106));
            }
            else if (ltr1 == '2' || ltr1 == '5'){
                output = output + ((char) (second + 97));
            }
            else {
                output = output + "a";
            }
        }
        return output;
    }

}
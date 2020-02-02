package arrays;

public class URLify {
    /*
    * given: buffer in the string
    * manipulate the string to have %20 instead of spaces
    * Since manipulation problem & we have buffer, then it's a good idea to edit the str starting from the end
    *
    * count spaces
    * amountOfSpace = trueLength + spaceCount * 2;
    * int endOfArray = amountOfSpace - 1;
    * for(int i = trueLength - 1; i >= 0 i--) {
    *   if str[i] is a space
    *       copy in %20
    *       shift index - 3
    *   else
    *       str[endOfArray] = str[i];
    *       endOfArray--;
    * }
    * */

    public void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for(int i = 0; i < trueLength ; i++) {
            if(str[i] == ' ')
                spaceCount++;
        }

        int amountOfSpace = trueLength + spaceCount * 2;
        int endOfArray = amountOfSpace - 1;
        for(int i = trueLength - 1; i >= 0 ;i--) {
            if(str[i] == ' ') {
                str[endOfArray] = '0';
                str[endOfArray - 1] = '2';
                str[endOfArray - 2] = '%';
                endOfArray-=3;
            } else {
                str[endOfArray] = str[i];
                endOfArray--;
            }
        }
    }

    public static void main(String[] args) {
        URLify urLify = new URLify();
        char[] str = "Mr John Smith             ".toCharArray();
        urLify.replaceSpaces(str, 13);
        System.out.println(String.valueOf(str));
    }
}

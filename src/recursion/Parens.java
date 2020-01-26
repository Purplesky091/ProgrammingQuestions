package recursion;

import java.util.ArrayList;

public class Parens {

    void addParens(ArrayList<String> list, int leftRem,
                          int rightRem, char[] str, int index) {
        if(leftRem < 0 || rightRem < leftRem) // invalid state
            return;

        if(leftRem == 0 && rightRem == 0) // no more left or right parenthesis
            list.add(String.copyValueOf(str));
        else {
            str[index] = '(';
            addParens(list, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')';
            addParens(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

    public ArrayList<String> generateParens(int count) {
        char[] str= new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        addParens(list, count, count, str, 0);
        return list;
    }

    public static void main(String[] args) {
        Parens p = new Parens();
        ArrayList<String> parenSet = p.generateParens(3);
        /*for(String parens : parenSet)
            System.out.print(parens + " ");

        System.out.println();*/
    }

}

package calculator;

import java.util.Scanner;

public class Calculator {
    public int calculate(String value){
        String[] values = value.split(" ");
        int result = Integer.parseInt(values[0]);
        String operator = "";

        for(int i=1;i< values.length;i++){
            if((i%2)==1) operator = values[i];
            if((i%2)==0){
                if(operator.equals("+")) result += Integer.parseInt(values[i]);
                if(operator.equals("-")) result -= Integer.parseInt(values[i]);
                if(operator.equals("*")) result *= Integer.parseInt(values[i]);
                if(operator.equals("/")) result /= Integer.parseInt(values[i]);
            }
        }
        return result;
    }
}

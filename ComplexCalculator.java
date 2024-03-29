import java.util.*;

import chainstructure.Pilha;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ComplexCalculator {
    public static void main(String[] args) {
        ComplexCalculator.reader();
    }

    public static void calculator(String line, Pilha calculator){
        float a,b;
        ComplexNumber c1,c2;
        try{
            String[] str = (line.split(" "));
            b = Float.parseFloat(str[0]);
            a = Float.parseFloat(str[1]);
            calculator.push(line);
        }catch(NumberFormatException ex){
            switch(line){
                case "+":
                c1 = new ComplexNumber(0, 0);
                try {
                    c1 = popNum(calculator);
                    c2 = popNum(calculator);
                    add(calculator, c1, c2);
            
                } catch (Exception e) {
                    calculator.push(c1.getA() + " " + c1.getB());
                }
                break;

                case "-":
                c1 = new ComplexNumber(0, 0);
                try {
                    c1 = popNum(calculator);
                    c2 = popNum(calculator);
                    sub(calculator, c1, c2);
            
                } catch (Exception e) {
                    calculator.push(c1.getA() + " " + c1.getB());
                }
                break;

                case "*":
                c1 = new ComplexNumber(0, 0);
                try {
                    c1 = popNum(calculator);
                    c2 = popNum(calculator);
                    mult(calculator, c1, c2);
            
                } catch (Exception e) {
                    calculator.push(c1.getA() + " " + c1.getB());
                }
                break;

                case "/":
                c1 = new ComplexNumber(0, 0);
                try {
                    c1 = popNum(calculator);
                    c2 = popNum(calculator);
                    div(calculator, c1, c2);
            
                } catch (Exception e) {
                    calculator.push(c1.getA() + " " + c1.getB());
                }
                break;

                case "chs":
                    c1 = popNum(calculator);
                    a = c1.getA();
                    b = c1.getB();
                    a = a - (a*2);
                    b = b - (b*2);
                    calculator.push(a + " " + b);
                break;

                case "inv":
                    try {
                        c1 = popNum(calculator);
                        inv(calculator, c1);
                    } catch (Exception e) {
                        break;
                    }
                break;

                case "conj":
                    c1 = popNum(calculator);
                    b = c1.getB();
                    c2 = new ComplexNumber(c1.getA(), b - (b*2));
                    mult(calculator, c1, c2);
                break;

                case "abs":
                    c1 = popNum(calculator);
                    abs(calculator, c1);
                break;

                case "pop":
                    calculator.pop();
                break;

                case "dup":
                    String aux = (String) calculator.pop();
                    calculator.push(aux);
                    calculator.push(aux);
                break;

                case "swap":
                if(!calculator.isEmpty()){
                    c1 = new ComplexNumber(0, 0);
                    try{
                        c1 = popNum(calculator);
                        c2 = popNum(calculator);
                        calculator.push(c1.getA() + " " + c1.getB());
                        calculator.push(c2.getA() + " " + c2.getB());
                    }catch(Exception e){
                        calculator.push(c1.getA() + " " + c1.getB());
                        break;
                    }
                }
            }
        }
    }

    public static ComplexNumber popNum(Pilha calculator){
        float a,b;
		ComplexNumber complex2;
        while(true){
            String[] split = ((String) calculator.pop()).split(" ");
            if(split.length!=2){
                b = 0;
                a = Float.parseFloat(split[0]);
                complex2 = new ComplexNumber(a, b);
            }else{
                b = Float.parseFloat(split[1]);
                a = Float.parseFloat(split[0]);
                complex2 = new ComplexNumber(a, b);
            }
                return complex2;    
        }
    }

    public static void add(Pilha calculator,ComplexNumber complex1,ComplexNumber complex2){
		complex1.add(complex2);
		String aux = (Float) complex1.newComplex.getA() + " " + (Float) complex1.newComplex.getB() ;
		calculator.push(aux);
    }

    public static void sub(Pilha calculator,ComplexNumber complex1,ComplexNumber complex2){
		complex1.subtract(complex2);
		String aux = (Float) complex1.newComplex.getA() + " " + (Float) complex1.newComplex.getB() ;
		calculator.push(aux);
    }

    public static void div(Pilha calculator,ComplexNumber complex1,ComplexNumber complex2){
		complex1.divide(complex2);
		String aux = (Float) complex1.newComplex.getA() + " " + (Float) complex1.newComplex.getB() ;
		calculator.push(aux);
    }

    public static void mult(Pilha calculator,ComplexNumber complex1,ComplexNumber complex2){
		complex1.multiply(complex2);
		String aux = (Float) complex1.newComplex.getA() + " " + (Float) complex1.newComplex.getB() ;
		calculator.push(aux);
    }

    public static void inv(Pilha calculator,ComplexNumber complex1){
        ComplexNumber invert = new ComplexNumber(1, 0);
		complex1.divide(invert);
		String aux = (Float) complex1.newComplex.getA() + " " + (Float) complex1.newComplex.getB() ;
		calculator.push(aux);
    }

    public static void abs(Pilha calculator,ComplexNumber complex1){
        double absolute = 0;
        float a = complex1.getA();
        float b = complex1.getB();

        absolute = Math.sqrt((a*a) + (b*b));

		String aux = Double.toString(absolute);
		calculator.push(aux);
    }

    public static void reader(){
        for (int j = 1; j < 9; j++) {
            System.out.println("\n-----------------------------------");
            System.out.println("Teste "+ j + "\n");            
            Path path = Paths.get("teste" + j + ".txt");
            Pilha calc = new Pilha();
            int tamMax = calc.size();
            try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
                while (sc.hasNext()){
                    String linha = sc.nextLine();
                    calculator(linha,calc);
                    if(calc.size() > tamMax){
                        tamMax = calc.size();
                    }
                }
                System.out.println("Tamanho máximo atingido pela pilha: " + tamMax);
                if(calc.isEmpty()){
                    System.out.println("Pilha vazia.");
                }else{
                    System.out.println("Tamanho da pilha: " + calc.size());
                    System.out.println("Último valor da pilha: " + calc.pop());
                }
            }catch (IOException x){
                System.err.format("Erro de E/S: %s%n", x);
            }
        }
    }
}

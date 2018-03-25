/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

/**
 *
 * @author Piet
 */
public class SeanMcintosh2 {
    
}

class TicTacToes {
 
    public static void main(String[] args) {
        System.out.println("First Tic Tac Toe: ");
        char x = 'X';
        char o = '\u004F';
 
        char[][] game1 = {
                {x , x, o},
                {o, x, x},
                {o, o, x}
        };
        System.out.println("Second Tic Tac Toe: ");
        char[][] game2 = {
                {o, o, x},
                {x, o, x},
                {o, x, x}
        };
 
        print2DArray(game1);
        print2DArray(game2);
    }
    private static void print1DArray(char[]array) {
        boolean firstchar = true;
        for (char c: array) {
            System.out.print(firstchar ? c: ", " + c);
            if (firstchar)firstchar = false;
        }
        System.out.println();
    }
 
    public static void print2DArray(char[][] array) {
        for (char[] a: array) print1DArray(a);
    }
}

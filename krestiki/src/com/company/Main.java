package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
Menu();

    }
    static void Menu()
    {
        Stat stat = new Stat();
        int n = 1;
        while(n!=3)
        {
        System.out.println("\n\n            Меню:\n 1.Запустить игру. \n 2.Открыть статистику. \n 3.Выход.");
            Scanner str = new Scanner(System.in);
            n = str.nextInt();
            if (n > 0 && n < 4) {
                if (n == 1) {
                    startGame();
                } else if (n == 2) {
                    System.out.println("Статистика за эту сессию: ");
                    System.out.println("Сыгранных матчей: "+ stat.game);
                    System.out.println("Побед X: "+stat.winX);
                    System.out.println("Побед O: "+stat.winO);
                    System.out.println("Ничей: "+stat.draw);
                } else {
                    return ;
                }
            } else
                System.out.println("Пожалуйста, выберите из имеющихся пунктов: ");

        }

    }
    static void startGame()
    {
        int ch = 3;
        Draw draw = new Draw();
        Game check = new Game();
        Stat stat = new Stat();
        boolean b;
        boolean isCurrentX = false;
        do {
            isCurrentX = !isCurrentX;
            draw.drawField();
            System.out.println("Ход " + (isCurrentX ? "X" : "O"));
            int n = getNumber();
            draw.field[n] = isCurrentX ? 1 : 2;
            b = check.isGameOver(n);
            if (check.isDraw()){
                ch =0;
                break;
            }
        } while (b==false);
        draw.drawField();
        System.out.println();
        if(ch!=0)
        ch = isCurrentX ? 1 : 2;
        if(ch==0) {
            System.out.println("Ничья!");
            stat.draw++;
        }
        else if(ch==1) {
            System.out.println("Победитель - X");
            stat.winX++;
        }
        else if(ch==2) {
            System.out.println("Победитель - O");
            stat.winO++;
        }
        stat.game++;
    }
    static int getNumber(){
        Draw draw = new Draw();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
                int n = Integer.parseInt(reader.readLine());
                if (n >= 0 && n < draw.field.length && draw.field[n]==0){
                    return n;
                }
                System.out.println("Выберите свободную ячейку и напишите ее номер: ");
            } catch (NumberFormatException e) {
            } catch (IOException e) {
            }
        }
    }


}
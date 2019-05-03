package com.company;

public class Game {

    static boolean isGameOver(int n){
        Draw f = new Draw();
        // 0 1 2
        // 3 4 5
        // 6 7 8
        //поиск совпадений по горизонтали
        int row = n-n%3; //номер строки - проверяем только её
        if (f.field[row]==f.field[row+1] &&
                f.field[row]==f.field[row+2]) return true;
        //поиск совпадений по вертикали
        int column = n%3; //номер столбца - проверяем только его
        if (f.field[column]==f.field[column+3])
            if (f.field[column]==f.field[column+6]) return true;
        //мы здесь, значит, первый поиск не положительного результата
        //если значение n находится на одной из граней - возвращаем false
        if (n%2!=0) return false;
        //проверяем принадлежит ли к левой диагонали значение
        if (n%4==0){
            //проверяем есть ли совпадения на левой диагонали
            if (f.field[0] == f.field[4] &&
                    f.field[0] == f.field[8]) return true;
            if (n!=4) return false;
        }
        return f.field[2] == f.field[4] &&
                f.field[2] == f.field[6];
    }



    public static boolean isDraw() {
        Draw f = new Draw();
        for (int n : f.field)
            if (n==0)
                return false;
        return true;
    }
}

package org.coach.tdd.template;

public class Library {
    private int [][] startMatric ;
//    public boolean someLibraryMethod(){
//        return true;
//    }
    public void creatStartMatric(int row, int col) {
        startMatric = new int [row + 1][col + 1];
        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < col + 1; j++) {
                startMatric[i][j] = 0;
            }
        }
    }
    public int[][] returnMatric() {
        return startMatric;
    }

    public void setDefaultLife(int i, int j) {
        startMatric[i][j] = 1;
    }

    public void printToScream() {
        for (int i = 0; i < startMatric.length; i++) {
            for (int j = 0; j < startMatric[0].length; j++) {
                System.out.print(startMatric[i][j] + " ");
            }
            System.out.println();
        }
    }
}

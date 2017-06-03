package org.coach.tdd.template;

public class Library {
    private boolean [][] startMatric ;

    public void creatStartMatric(int row, int col) {
        startMatric = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                startMatric[i][j] = false;
            }
        }
    }

    public void getNextWorld() {
        boolean[][] nextWorld = new boolean[startMatric.length][startMatric[0].length];
        for (int i = 0; i < startMatric.length; i++) {
            for (int j = 0; j < startMatric[0].length; j++) {
                nextWorld[i][j] = returnNeighbour(i, j);
            }
        }
        startMatric = nextWorld;
        printToScream();

    }
    public void getNumWorld(int numWorld, int holdTimeEveryWorld) throws InterruptedException {
        int numWorldSub = numWorld;
        while (numWorldSub-- > 0) {
            getNextWorld();
            Thread.sleep(holdTimeEveryWorld * 1000);
        }
    }

    private boolean returnNeighbour(int row, int col) {
        int neighbourCount = getNeibourCount(row, col);
        boolean nextStation = false;
        if (neighbourCount == 3) {
            nextStation = true;
        } else if (neighbourCount == 2) {
            nextStation = startMatric[row][col];
        } else {
            nextStation = false;
        }
        return nextStation;
    }

    private int getNeibourCount(int row, int col) {
        int neighbourCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int rowNeighbour = row + i;
                int colNeighbour = col + j;
                if (isEdge(rowNeighbour, colNeighbour)) {
                    continue;
                }
                if (startMatric[rowNeighbour][colNeighbour]) {
                    neighbourCount++;
                }
            }
        }
        if (startMatric[row][col]) {
            neighbourCount--;
        }
        return neighbourCount;
    }

    private boolean isEdge(int rowNeighbour, int colNeighbour) {
        boolean isAnEdge = false;
        if (rowNeighbour < 0 || rowNeighbour > startMatric.length - 1) {
            isAnEdge = true;
        }
        if (colNeighbour < 0 || colNeighbour > startMatric[0].length - 1) {
            isAnEdge = true;
        }
        return isAnEdge;
    }

    public boolean[][] returnMatric() {
        return startMatric;
    }

    public void setDefaultLife(int i, int j) {
        startMatric[i][j] = true;
    }

    public void printToScream() {
        for (int i = 0; i < startMatric.length; i++) {
            for (int j = 0; j < startMatric[0].length; j++) {
                if (startMatric[i][j]) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

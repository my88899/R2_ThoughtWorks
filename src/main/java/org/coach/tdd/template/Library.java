package org.coach.tdd.template;

public class Library {
    private int [][] startMatric ;
    public void creatStartMatric(int row, int col) {
        startMatric = new int [row + 1][col + 1];
        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < col + 1; j++) {
                startMatric[i][j] = 0;
            }
        }
    }

    public void getNextWorld() {
        int[][] nextWorld = startMatric;
        for (int i = 0; i < startMatric.length; i++) {
            for (int j = 0; j < startMatric[0].length; j++) {
                nextWorld[i][j] = returnNeighbour(i, j);
            }
        }
        startMatric = nextWorld;
        printToScream();
    }

    private int returnNeighbour(int row, int col) {
        int neighbourCount = getNeibourCount(row, col);
        int nextStation = 0;
        if (neighbourCount == 3) {
            nextStation = 1;
        } else if (neighbourCount == 2) {
            nextStation = startMatric[row][col];
        } else {
            nextStation = 0;
        }
        return nextStation;
    }

    private int getNeibourCount(int row, int col) {
        int neighbourCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int rowNeighbour = row + i;
                int colNeighbour = col + j;
                if (rowNeighbour < 0 || rowNeighbour > startMatric.length - 1) {
                    continue;
                }
                if (colNeighbour < 0 || colNeighbour > startMatric[0].length - 1) {
                    continue;
                }
                neighbourCount += startMatric[rowNeighbour][colNeighbour];
            }
        }
        neighbourCount -= startMatric[row][col];
        return neighbourCount;
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

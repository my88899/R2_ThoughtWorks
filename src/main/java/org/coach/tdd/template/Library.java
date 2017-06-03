package org.coach.tdd.template;

public class Library {
    private boolean [][] worldMatric;

    public void initalWorldMatric(int row, int col) {
        worldMatric = new boolean[row][col];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                worldMatric[i][j] = false;
//            }
//        }
    }

    public void getNextWorldMatric() {
        boolean[][] nextWorldCellsStation = new boolean[worldMatric.length][worldMatric[0].length];
        for (int i = 0; i < worldMatric.length; i++) {
            for (int j = 0; j < worldMatric[0].length; j++) {
                nextWorldCellsStation[i][j] = returnNextWorldCellStationInPosition(i, j);
            }
        }
        worldMatric = nextWorldCellsStation;
        printToScream();
    }

    public void getNumWorld(int numOfWorldSteps, int holdTimeEveryWorldSecond) throws InterruptedException {
        int numWorldRemainder = numOfWorldSteps;
        while (numWorldRemainder-- > 0) {
            getNextWorldMatric();
            Thread.sleep(holdTimeEveryWorldSecond * 1000);
        }
    }

    private boolean returnNextWorldCellStationInPosition(int positionRow, int positionCol) {
        int neighbourCount = getNeighborCount(positionRow, positionCol);
        boolean nextWorldCellStationInPosition = false;
        if (neighbourCount == 3) {
            nextWorldCellStationInPosition = true;
        } else if (neighbourCount == 2) {
            nextWorldCellStationInPosition = worldMatric[positionRow][positionCol];
        } else {
            nextWorldCellStationInPosition = false;
        }
        return nextWorldCellStationInPosition;
    }

    private int getNeighborCount(int positionRow, int positionCol) {
        int neighbourCellsCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (isEdge(positionRow + i, positionCol + j)) {
                    continue;
                }
                if (worldMatric[positionRow + i][positionCol + j] == true) {
                    neighbourCellsCount++;
                }
            }
        }
        if (worldMatric[positionRow][positionCol] == true) {
            neighbourCellsCount -= 1;
        }
        return neighbourCellsCount;
    }

    private boolean isEdge(int positionRow, int positionCol) {
        boolean isAnEdge = false;
        if (positionRow < 0 || positionRow > worldMatric.length - 1) {
            isAnEdge = true;
        }
        if (positionCol < 0 || positionCol > worldMatric[0].length - 1) {
            isAnEdge = true;
        }
        return isAnEdge;
    }

    public boolean[][] returnMatric() {
        return worldMatric;
    }

    public void setDefaultLife(int i, int j) {
        worldMatric[i][j] = true;
    }

    public void printToScream() {
        for (int i = 0; i < worldMatric.length; i++) {
            for (int j = 0; j < worldMatric[0].length; j++) {
                if (worldMatric[i][j]) {
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

package org.coach.tdd.template;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LibraryTest {
    @Test
    public void shouldReturnMatric() throws InterruptedException {
        int row = 10;
        int col = 10;
        int [][] defaultLife = {{4, 5}, {5, 5}, {5, 6}};

        Library classUderTest = new Library();
        classUderTest.initalWorldMatric(row, col);
        setAliveCellsInWorld(classUderTest, defaultLife);

        boolean[][] testResult = new boolean[row][col];
        setAliveCellsInWorld(testResult, defaultLife);

        assertArrayEquals(testResult, classUderTest.returnMatric());
    }

    @Test
    public void testOneStepWorldIgnoreEdge() throws InterruptedException {
        int row = 10;
        int col = 10;
        int[][] defaultLife = {{4, 5}, {5, 5}, {5, 6}};
        int[][] resultAliveCellsPoint = {{4, 5}, {5, 5}, {5, 6}, {4, 6}};

        Library classUderTest = new Library();
        classUderTest.initalWorldMatric(row, col);
        setAliveCellsInWorld(classUderTest, defaultLife);
        classUderTest.getNextWorldMatric();

        boolean[][] testResult = new boolean[row][col];
        setAliveCellsInWorld(testResult, resultAliveCellsPoint);

        assertArrayEquals(testResult, classUderTest.returnMatric());
    }

    @Test
    public void testOneStepWorldEdge() throws InterruptedException {
        int row = 10;
        int col = 10;
        int[][] defaultLife = {{0, 0}, {1, 0}, {1, 1}};
        int[][] resultAliveCellsPoint = {{0, 0}, {1, 0}, {1, 1}, {0, 1}};

        Library classUderTest = new Library();
        classUderTest.initalWorldMatric(row, col);
        setAliveCellsInWorld(classUderTest, defaultLife);
        classUderTest.getNextWorldMatric();

        boolean[][] testResult = new boolean[row][col];
        setAliveCellsInWorld(testResult, resultAliveCellsPoint);

        assertArrayEquals(testResult, classUderTest.returnMatric());
    }

    @Test
    public void testNumStepWorldEdge() throws InterruptedException {
        int row = 10;
        int col = 10;
        int[][] defaultLife = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        int[][] resultAliveCellsPoint = {{1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 3}, {3, 1}, {3, 2}};

        Library classUderTest = new Library();
        classUderTest.initalWorldMatric(row, col);
        setAliveCellsInWorld(classUderTest, defaultLife);
        classUderTest.getNumWorld(3, 1);

        boolean[][] testResult = new boolean[row][col];
        setAliveCellsInWorld(testResult, resultAliveCellsPoint);
        assertArrayEquals(testResult, classUderTest.returnMatric());
    }

    @Test
    public void testPrintOut() throws InterruptedException {
        int row = 10;
        int col = 10;
        int[][] defaultLife = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
//        int[][] resultAliveCellsPoint = {};

        Library classUderTest = new Library();
        classUderTest.initalWorldMatric(row, col);
        setAliveCellsInWorld(classUderTest, defaultLife);

//        boolean[][] testResult = new boolean[row][col];
        classUderTest.getNumWorld(5, 2);
    }

    private void setAliveCellsInWorld(boolean[][] testResult, int[][] defaultLife) {
        for (int i = 0; i < defaultLife.length; i++) {
            testResult[defaultLife[i][0]][defaultLife[i][1]] = true;
            testResult[defaultLife[i][0]][defaultLife[i][1]] = true;
        }
    }

    private void setAliveCellsInWorld(Library classUderTest, int[][] defaultLife) {
        for (int i = 0; i < defaultLife.length; i++) {
            classUderTest.setDefaultLife(defaultLife[i][0], defaultLife[i][1]);
        }
    }

}


package org.coach.tdd.template;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LibraryTest {
//    @Test
//    public void shouldSomeLibraryMethodReturnTrue() {
//        Library classUnderTest = new Library();
//        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
//    }
    @Test
    public void shouldReturnMatric() {
        Library classUderTest = new Library();
        int [][] testResult = new int [10][10];
        int [][] defaultLife = {{4, 5}, {5, 5}, {5, 6}};
        classUderTest.creatStartMatric(9, 9);
        for (int i = 0; i < defaultLife.length; i++) {
            classUderTest.setDefaultLife(defaultLife[i][0], defaultLife[i][1]);
            testResult[defaultLife[i][0]][defaultLife[i][1]] = 1;
            testResult[defaultLife[i][0]][defaultLife[i][1]] = 1;

        }
        classUderTest.printToScream();
        assertArrayEquals(testResult, classUderTest.returnMatric());
    }
    @Test
    public void testOneStepWorldIgnoreEdge() {
        Library classUderTest = new Library();
        int[][] testResult = new int[10][10];
        int[][] defaultLife = {{4, 5}, {5, 5}, {5, 6}, {4, 6}};
        classUderTest.creatStartMatric(9, 9);
        for (int i = 0; i < defaultLife.length - 1; i++) {
            classUderTest.setDefaultLife(defaultLife[i][0], defaultLife[i][1]);
            testResult[defaultLife[i][0]][defaultLife[i][1]] = 1;
            testResult[defaultLife[i][0]][defaultLife[i][1]] = 1;
        }
        testResult[defaultLife[3][0]][defaultLife[3][1]] = 1;
        classUderTest.getNextWorld();
        assertArrayEquals(testResult, classUderTest.returnMatric());
    }
    @Test
    public void testOneStepWorldEdge() {
        Library classUderTest = new Library();
        int [][] testResult = new int [10][10];
        int [][] defaultLife = {{0, 0}, {1, 0}, {1, 1}, {0, 1}};
        classUderTest.creatStartMatric(9, 9);
        for (int i = 0; i < defaultLife.length - 1; i++) {
            classUderTest.setDefaultLife(defaultLife[i][0], defaultLife[i][1]);
            testResult[defaultLife[i][0]][defaultLife[i][1]] = 1;
            testResult[defaultLife[i][0]][defaultLife[i][1]] = 1;
        }
        testResult[defaultLife[3][0]][defaultLife[3][1]] = 1;
        classUderTest.getNextWorld();
        assertArrayEquals(testResult, classUderTest.returnMatric());
    }
    @Test
    public void testNumStepWorldEdge() {
        Library classUderTest = new Library();
        int [][] testResult = new int [10][10];
//        int [][] defaultLife = {{0, 0}, {1, 0}, {1, 1}};
        classUderTest.creatStartMatric(9, 9);
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                classUderTest.setDefaultLife(i, j);
            }
        }
        testResult[1][1] = 1;
        testResult[1][2] = 1;
        testResult[1][3] = 1;
        testResult[2][1] = 1;
        testResult[2][3] = 1;
        testResult[3][1] = 1;
        testResult[3][2] = 1;
        classUderTest.getNumWorld(3);
        classUderTest.printToScream();
        assertArrayEquals(testResult, classUderTest.returnMatric());
    }

}


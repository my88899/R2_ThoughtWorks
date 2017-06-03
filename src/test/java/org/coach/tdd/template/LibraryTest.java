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
//        assertEquals();
        assertArrayEquals(testResult, classUderTest.returnMatric());
    }
}


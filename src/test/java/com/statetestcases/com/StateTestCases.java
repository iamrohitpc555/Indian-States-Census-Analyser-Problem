package com.statetestcases.com;

import com.stateinformation.com.StateAnalyser;
import com.stateinformation.com.StateException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTestCases {

    @Test
    public void check_StateCensusDataFile_ReturnHowMuchRecord() throws StateException {

        StateAnalyser stateAnalyser = new StateAnalyser();
        Assert.assertEquals( 37,
                stateAnalyser.openCSVBuilder("/Users/rohitchaudhari/IdeaProjects/Indian States Census Analyser/src/main/java/StateCensusData.csv"));
    }




    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileName_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            assertEquals(37,stateAnalyser.openCSVBuilder("/Users/rohitchaudhari/IdeaProjects/Indian States Census Analyser/src/main/java/StateCensusData1.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileType_TrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            assertEquals(37,stateAnalyser.openCSVBuilder("/Users/rohitchaudhari/IdeaProjects/Indian States Census Analyser/src/main/java/StateCensusData.pdf"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            assertEquals(StateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenDelimiterIncorrect_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            assertEquals(37,stateAnalyser.openCSVBuilder("/Users/rohitchaudhari/IdeaProjects/Indian States Census Analyser/src/main/java/StateCensusData.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenHeaderIncorrect_ThrowException() {

        StateAnalyser stateAnalyser = new StateAnalyser();
        try {
            assertEquals(37,stateAnalyser.openCSVBuilder("/Users/rohitchaudhari/IdeaProjects/Indian States Census Analyser/src/main/java/StateCensusData.csv"));
        } catch (StateException e) {
            System.out.println("Exception is : "+ e.getMessage());
            assertEquals(StateException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }
}
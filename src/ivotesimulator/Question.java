package ivotesimulator;

import java.util.Random;

public class Question {
    private String singleSolution;
    private boolean[] multiSolution;
    private Random rand = new Random();
    
    public Question(boolean questionType) {
        if(questionType) { //If Heads/True, then single solution.
            multiSolution = null;
            int answer = rand.nextInt(4); //Randomly selects an answer to the question.
            if(answer == 0)
                singleSolution = "A";
            else if(answer == 1)
                singleSolution = "B";
            else if(answer == 2)
                singleSolution = "C";
            else
                singleSolution = "D";
        }
        else { //If Tails/False, then multiSolution
            singleSolution = null;
            multiSolution =  new boolean[4];
            for(int i = 0; i < 4; i++) //Randomly assigns what answers are correct
                multiSolution[i] = rand.nextBoolean(); 
        }
    }
    
    
    public String getSingleSolution() {
        return singleSolution;
    }
    
    private void setSolution(String answer) {
        singleSolution = answer;
    }
    
    public boolean[] getMultiSolution() {
        return multiSolution;
    }
    
    private void setMultiSolution(boolean[] answers) {
        multiSolution = answers;
    }
    
    private boolean checkAnswer(String answer) {
        if(singleSolution == answer)
            return true;
        else
            return false;
    }
    
    private boolean checkAnswers(boolean[] answers) {
        if(multiSolution == answers)
            return true;
        else
            return false;
    }
}

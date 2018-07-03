package ivotesimulator;

import java.util.Random;

public class SimulationDriver {
    public static void main(String args[]) {
        IVoteService voter = new IVoteService();
        
        //Have students use their studentID to login/register with the IVoteService.
        Student student1 = new Student(12345, voter);
        Student student2 = new Student(23456, voter);
        Student student3 = new Student(34567, voter);
        Student student4 = new Student(45678, voter);
        Student student5 = new Student(56789, voter);
        
        //Teacher randomly decides what type of question to give the students. Configures and answer and sets up the voter system.
        boolean coinFlip = coinFlip();
        Question question = new Question(coinFlip);
        voter.setQuestion(question);
        
        //Have the Students submit their answers
        student1.submit(coinFlip);
        student2.submit(coinFlip);
        student3.submit(coinFlip);
        student4.submit(coinFlip);
        student5.submit(coinFlip);
        
        if(coinFlip) { //Votes are already tallied if it was a multi-choice question.
            System.out.println("Single Answer Question:");
            voter.tallySingle();
        }
        else
            System.out.println("Multi-Answer Question:");
        
        voter.output();
    }
    
    private static boolean coinFlip() { //If True, teacher will make a single solution question. False for Multi.
        if(((int)Math.random() % 2) == 0)
            return true;
        else
            return false;
    }
}

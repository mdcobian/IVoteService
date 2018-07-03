package ivotesimulator;
import java.util.Random;

public class Student {
    private Random rand = new Random();
    private int id;
    private String answer;
    private boolean[] answers;
    private IVoteService voter;
    
    public Student(int identity, IVoteService voteSystem) {
        id = identity;
        voter = voteSystem;
    }
    private int getID() {
        return id;
    }
    
    private void setID(int identity) {
        id = identity;
    }
    
    private String getSingle() {
        return answer;
    }
    
    private void setSingle(String response) {
        answer = response;
    }
    
    private boolean[] getAnswers() {
        return answers;
    }
    
    private void setAnswers(boolean[] response) {
        answers = response;
    }
    
    public void submit(boolean questionType) { //Heads/True for single. Tails/False for multi.
        if(questionType) {
            int answer = rand.nextInt(4); //Randomly selects an answer to the question.
            if(answer == 0)
                voter.addVote("A");
            else if(answer == 1)
                voter.addVote("B");
            else if(answer == 2)
                voter.addVote("C");
            else
                voter.addVote("D");
        }
        else {
            boolean[] answers = new boolean[4];
            for(int i = 0; i < 4; i++)
                answers[i] = rand.nextBoolean();
            voter.addVotes(answers);
        }
    }
}

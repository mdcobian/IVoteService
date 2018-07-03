package ivotesimulator;

public class IVoteService {
    int total;
    int right;
    int wrong;
    int[] voteCounts = new int[]{0, 0, 0, 0, 0};
    Question question;
    String solution;
    boolean[] solutions;
    
    private int getTotal() {
        return total;
    }
    
    private int[] getVoteCounts() {
        return voteCounts;
    }
    
    private int getRight() {
        return right;
    }
    
    private int getWrong() {
        return wrong;
    }
    private Question getQuestion() {
        return question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
        if(question.getSingleSolution() != null) { //Configure a single answer
            solution = question.getSingleSolution();
            solutions = null;
        }
        else {
            solutions = question.getMultiSolution();
            solution = null;
        }
    }
    
    public void addVote(String answer) { //Add up a vote for a single answer question.
        if(answer == "A")
            voteCounts[0] += 1;
        else if(answer == "B")
            voteCounts[1] += 1;
        else if(answer == "C")
            voteCounts[2] += 1;
        else if(answer == "D")
            voteCounts[3] += 1;
        else
            voteCounts[4] += 1; //Any other response will be added to a designated wrong index.
        total++;
    }
    
    public void addVotes(boolean[] votes) { //Add up votes for a multiple answer question.
        for(int i = 0; i < votes.length; i++) {
            if(votes[i] == true)
                voteCounts[i] += 1;
        }
        if(votes == solutions)
            right++;
        else
            wrong++;
        total++;
    }
    
    public void tallySingle() { //Only to be called when all answers have been submitted.
        right = 0;
        if(solution == "A") {
            right = voteCounts[0];
        }
        else if(solution == "B") {
            right = voteCounts[1];
        }
        else if(solution == "C") {
            right = voteCounts[2];
        }
        else if(solution == "D") {
            right = voteCounts[3];
        }
        for (int i = 0; i < 5; i++)
            wrong += voteCounts[i];
        wrong = wrong - right;
    }
    
    public void output() {
        System.out.println("Total Responses: " + total);
        System.out.println("Individual Answers: A: " + voteCounts[0] + " B: " + voteCounts[1] + " C: " + voteCounts[2] + " D: " +
                voteCounts[3] + " Other: " + voteCounts[4]);
        System.out.println("Correct Responses: " + right);
        System.out.println("Incorrect Responses: " + wrong);
        System.out.println();
    }
}
class Hangman
{
    private String [] computerword;
    private String [] playerguesses;
    private String [] missedletters;
    private int playerattempts;

    public Hangman(String[] computerword) { // can set word to guess if wanted
        this.computerword = computerword;
    }

    public String[] getComputerword() {
        return computerword;
    }

    public void setComputerword(String[] computerword) {
        this.computerword = computerword;
    }

    public String[] getPlayerguesses() {
        return playerguesses;
    }

    public void setPlayerguesses(String[] playerguesses) {
        this.playerguesses = playerguesses;
    }

    public String[] getMissedletters() {
        return missedletters;
    }

    public void setMissedletters(String[] missedletters) {
        this.missedletters = missedletters;
    }

    public int getPlayerattempts() {
        return playerattempts;
    }

    public void setPlayerattempts(int playerattempts) {
        this.playerattempts = playerattempts;
    }

    public void mainMenu()
    {
        System.out.println("H A N G M A N");

    }
}

package workshop;

public class FizzBuzz {

//comment smell removed
    public static String playFizzBuzz(int guessedNumber) {     //unclear method and variable name
        String answer = "";                                 //unclear variable name and now set to empty string
        if (guessedNumber % 3 == 0) {
            answer += "Fizz";                               //unnecssary if-else blocks removed
        }
        if (guessedNumber % 5 == 0) {
            answer += "Buzz";
        }
        return answer.isEmpty() ? String.valueOf(guessedNumber) : answer;          //return statements simplified
    }
}

package algorithm;

public class FibonacciRecursive implements Fibonacci {

    @Override
    public int getMemberValue(int member) {
        if(member > 1){
            return getMemberValue(member-1)+getMemberValue(member-2);
        }
        else if(member == 0){
            return 0;
        }
        else if(member == 1){
            return 1;
        }
        else{
            return -1;
        }
    }
}

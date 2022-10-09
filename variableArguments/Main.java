public class Main {
    public static void main(String[] args) {
        System.out.println(arg(1,2,3,4,5));
    }
    //Variable Arguments
    public static int arg(int... numbers){
        int sum = 0;
        for(int nr : numbers){
            sum += nr;
        }
        return sum;
    }
}

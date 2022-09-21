public class main {
    public static void main(String[] args) {
        int number = 1;
        boolean isPrime = true;

        if(number == 1){
            System.out.println("Sayi Asal Degildir.");
            return;
        }
        if(number < 1){
            System.out.println("Gecersiz Sayi.");
        }

        for(int i=2; i<number; i++){
            if(number % i == 0){
                isPrime = false;
            }
        }
        if(isPrime){
            System.out.println("Sayi Asaldır.");
        }
        else{
            System.out.println("Sayi Asal Degildir.");
        }
    }
}

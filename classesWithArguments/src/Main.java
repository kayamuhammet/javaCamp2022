public class Main {
    public static void main(String[] args) {
        //Parametreli
        //Product product = new Product(2022,"Laptop","Asus Rog Strix",22000,10,"black");

        //Parametresiz
        Product product = new Product();
        product.setName("Laptop");
        product.setId(2019);
        product.setDescription("Asus ROG Strix");
        product.setPrice(8800);
        product.setStockAmount(5);

        ProductManager productManager = new ProductManager();
        productManager.Add(product);
        System.out.println(product.getCode());

    }
}

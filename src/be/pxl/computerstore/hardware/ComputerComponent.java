package be.pxl.computerstore.hardware;

public abstract class ComputerComponent {
    private String vendor;
    private String name;
    private double price;
    private String articleNumber;
    private static int aantal = 0;

    static {
        aantal++;
    }

    public ComputerComponent(String vendor, String name, double price) {
        setVendor(vendor);
        setName(name);
        setPrice(price);
        createArticleNumber();
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void createArticleNumber() {
        if (vendor.length() < 3) {
            if (vendor.length() < 2) {
                articleNumber = vendor + "XX";
            } else {
                articleNumber = vendor + "X";
            }
        } else {
            articleNumber = vendor.substring(0, 3);
        }

        articleNumber += "-";

        StringBuilder code = new StringBuilder();
        code.insert(0, aantal);
        while (code.length() < 5) {
            code.insert(0, '0');
        }

        articleNumber += code.toString();

    }

    // Getters and Setters

    public String getVendor() {
        return vendor;
    }

    private void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "(" + articleNumber + ")";
    }

    public String getFullDescription() {
        return "ArticleNumber = " + articleNumber +
                "\nVendor = " + vendor +
                "\nName = " + name +
                "\nPrice = " + price;
    }
}

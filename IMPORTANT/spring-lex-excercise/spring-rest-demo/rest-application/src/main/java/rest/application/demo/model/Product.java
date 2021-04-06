package rest.application.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;

@Document(collection = "product")
public class Product {
        private long productCode;

        public long getProductCode() {
            return productCode;
        }

        public void setProductCode(long productCode) {
            this.productCode = productCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductVendor() {
            return productVendor;
        }

        public void setProductVendor(String productVendor) {
            this.productVendor = productVendor;
        }

        public double getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(double productPrice) {
            this.productPrice = productPrice;
        }

        public int getProductInStock() {
            return productInStock;
        }

        public void setProductInStock(int productInStock) {
            this.productInStock = productInStock;
        }

        private String productName;
        private String productVendor;
        private double productPrice;
        private int productInStock;

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productPrice=" + productPrice +
                ", productInStock=" + productInStock +
                '}';
    }
}

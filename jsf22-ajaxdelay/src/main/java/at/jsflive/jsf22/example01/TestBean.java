package at.jsflive.jsf22.example01;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Michael Kurz
 */
@ManagedBean
@SessionScoped
public class TestBean implements Serializable {
    private String product;
    private List<String> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<String>();
        String p = "a";
        for (int i = 0; i < 10; i++) {
            products.add(p);
            p += "a";
        }
    }

    public List<String> getMatchingProducts() {
        List<String> matchingProducts = new ArrayList<String>();
        if (product != null) {
            for (String p : products) {
                if (p.startsWith(product)) {
                    matchingProducts.add(p);
                }
            }
        }
        return matchingProducts;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}

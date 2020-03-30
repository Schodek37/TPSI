package Lab3;

/**
 *
 * @author Schodek
 */
public class Product{
    
    public Integer id;
    public String name;
    public Double price;
    public String category;

    public Product(Integer id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + category + " " + price;
    }
    

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Double getPrice() {
        return price;
    }
        
    public String getCategory() {
        return category;
    }
    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
   
    
    
}

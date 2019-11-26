package pl.manciak.thymeleaf.restApi;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.manciak.thymeleaf.Manager.ProductManager;
import pl.manciak.thymeleaf.entity.FoodEntities.Products;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class ManagerToControllerDataTransmission {

    @Mock
    ProductManager productManager;

    @InjectMocks
    ProductRestController controller;

    @Before
    public void init(){
        given(productManager.getAllProducts()).willReturn(preparedMockData());
    }

    @Test
    public void should_show_all_products() {
        List<Products> products = (List) controller.showAllProducts().getBody();
        Assert.assertThat(products, Matchers.hasSize(5));
    }

    @Test
    public void should_not_show_all_products() {
        List<Products> products = (List) controller.showAllProducts().getBody();
        Assert.assertNotEquals(products, Matchers.hasSize(6));
    }

    @Test
    public void should_not_show_all_products_cause_null_arg() {
        List<Products> products = (List) controller.showAllProducts().getBody();
        Assert.assertNotEquals(products, Matchers.hasSize(null));
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

////////////////////////////////////////////////////////
///////////////////////////////////////////////////////

    private List<Products> preparedMockData(){
        List<Products> productList = new ArrayList<>();
        productList.add(new Products("Marchew",1F,1F,1F,1F,1F));
        productList.add(new Products("Mardchew",1F,1F,1F,1F,1F));
        productList.add(new Products("Mardchew",1F,1F,1F,1F,1F));
        productList.add(new Products("Mardchew",1F,1F,1F,1F,1F));
        productList.add(new Products("Mardchew",1F,1F,1F,1F,1F));
        return  productList;
    }

    private List<Products> preparedNullData(){
        return null;
    }
}
package com.automation.pages;

import com.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class InventoryPage extends BasePage {

    private By productTitle = By.className("title");
    private By addToCartButtons = By.xpath("//button[text()='Add to cart']");
    private By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }

    public void addFirstItemToCart() {

        List<WebElement> items = driver.findElements(addToCartButtons);
        if (!items.isEmpty()) {
            items.get(0).click();
        }
    }

    public int getCartItemCount() {
        try {
            String countText = driver.findElement(cartBadge).getText();
            return Integer.parseInt(countText);
        } catch (Exception e) {
            return 0;
        }
    }
}
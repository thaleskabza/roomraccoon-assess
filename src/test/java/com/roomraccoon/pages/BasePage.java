package com.roomraccoon.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Initialize all elements with Selenium PageFactory
        PageFactory.initElements(driver, this);
    }
}
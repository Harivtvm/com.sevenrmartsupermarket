package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String get_attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);

	}
	public String get_cssvalue(WebElement element, String value) {
		return element.getCssValue(value);

	}
	
	
	public List<String> getTextofElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}
	public static String getRandomFullname() {
		Faker faker=new Faker();
		//String name = faker.name().fullName();
		//String firstName = faker.name().firstName();
		//String lastName = faker.name().lastName();
//String streetAddress = faker.address().streetAddress();
		return faker.name().fullName();
		
	}
	public boolean isTextContains(WebElement element,String expectedtext) {
		return element.getText().contains(expectedtext);
		
	}
}

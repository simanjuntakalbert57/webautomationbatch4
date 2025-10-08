package com.webautomationbatch4.page_factory.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webautomationbatch4.abstractcomponents.AbstractComponents;
import com.webautomationbatch4.page_factory.object_repository.ConfirmationObjectRepository;

public class ConfirmationPage extends AbstractComponents {

    ConfirmationObjectRepository confirmationObjectRepository;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.confirmationObjectRepository = new ConfirmationObjectRepository(driver);
    }

    public String getConfirmationMessage() throws InterruptedException {
        visibilityElement(confirmationObjectRepository.confirmMessage);
        return confirmationObjectRepository.confirmationMessage.getText();
    }
}

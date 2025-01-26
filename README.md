# Automated Test Framework for SauceDemo  

## Project Overview  

The framework automates the following steps:  
1. Navigate to the [SauceDemo](https://www.saucedemo.com/) website.  
2. Log in with the following credentials:  
   - Username: `standard_user`  
   - Password: `secret_sauce`  
3. Identify and select the item with the highest price (without using the "Sort By" option).  
4. Add the selected item to the cart.  

## Framework Structure  

The project follows the **Page Object Model (POM)** design pattern for better maintainability and scalability.  

### Directory Structure  

```plaintext  
src/  
├── main/  
│   ├── java/  
│   │   ├── pages/           # Page classes for different screens (e.g., LoginPage)  
│   │   ├── utilities/       # Utility classes for reusable functions (e.g., reports)  
│   │   └── resources/       # Configuration files and other resources  
│  
├── test/  
│   ├── java/  
│   │   ├── base/            # Base class for test setup and teardown  
│   │   └── testcases/       # Test classes for specific test scenarios
```

## Key Components  

- **Pages**: Encapsulates elements and actions for each page.  
- **Utilities**: Includes report logic for report generation.
- **Test Cases**: Contains test logic and assertions for the specified workflow.  

## Prerequisites  

- Java 8 or higher  
- Maven  
- Selenium WebDriver  
- TestNG  

## Test Details  

The framework verifies the following:  
- Successful login to the application.  
- Identification of the item with the highest price without using the "Sort By" feature.  
- Adding the highest price item to the cart.  
 

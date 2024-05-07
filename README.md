# Departmental Store Management System

This is a Java-based Departmental Store Management System that facilitates various functionalities such as adding stock, viewing stock, removing stock, generating new bills, and viewing bills. It provides separate interfaces for owners and cashiers.

## Features

- **Owner Interface**: Allows the owner to manage cashiers, including adding, viewing, and removing cashier accounts.
- **Cashier Interface**: Enables cashiers to perform stock management tasks like adding, viewing, and removing stock, as well as generating bills for customers.
- **Stock Management**: Owners and cashiers can add new stock items, view existing stock details, and remove stock items from the inventory.
- **Bill Generation**: Cashiers can generate bills for customers, showing details of purchased items, quantities, unit prices, taxes, and total amounts.
- **User Authentication**: Requires login authentication for both owners and cashiers to access the system.

## How It Works

1. **Owner Login**: Owners can log in with their username and password to access administrative functions.
2. **Cashier Login**: Cashiers can log in with their credentials to access stock management and billing functionalities.
3. **Stock Management**: Cashiers can add new stock items by specifying the item name, stock count, cost price, and tax. They can also view existing stock details and remove items from the inventory if necessary.
4. **Billing**: Cashiers can generate bills for customers by selecting purchased items, specifying quantities, and calculating total amounts including taxes.
5. **Cashier Management**: Owners can add new cashiers to the system, view existing cashier accounts, and remove cashier accounts if required.

## Main Functions

1. `Owner()`: Manages the owner interface, allowing the owner to add, view, and remove cashier accounts.
2. `Cashier()`: Manages the cashier interface, enabling cashiers to perform stock management tasks and generate bills.
3. `cashierfunc()`: Implements functionalities available to cashiers, such as adding stock, viewing stock, removing stock, generating bills, and logging out.
4. `addStock()`: Allows cashiers to add new stock items to the inventory, specifying details such as item name, stock count, cost price, and tax.
5. `viewStock()`: Displays the current stock details including item name, stock count, cost price, and tax.
6. `removeStock()`: Enables cashiers to remove stock items from the inventory based on the item name.
7. `newBill()`: Facilitates the generation of new bills for customers, showing details of purchased items, quantities, unit prices, taxes, and total amounts.
8. `viewBill()`: Displays the details of generated bills, including purchased items, quantities, unit prices, taxes, and total amounts.

## Usage

1. Clone the repository to your local machine.
2. Compile the `Main.java` file using a Java compiler.
3. Run the compiled program to start the Departmental Store Management System.
4. Choose the appropriate login option (Owner or Cashier) and follow the on-screen prompts to perform various tasks.

## Contributors

- Dhivyapriya G (https://github.com/DhivyapriyaG)) - Role Developer 

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

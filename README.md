# Banking System Project

This project is a Java-based banking system designed to simulate the essential operations and account management features of a bank. The application provides classes for different types of accounts, client management, and monthly operations like debits and credits through an `Accountable` system.

## Features

- **Account Types**: Supports various account types such as `DepositAccount`, `CreditAccount`, and `WebAccount`.
- **Client Management**: Each account is associated with a unique client identified by name and fiscal code.
- **WebAccount Security**: Includes a `login` feature for WebAccounts, requiring users to set a password before they can perform operations.
- **Monthly Operations**: Allows adding recurring debits (e.g., subscription fees) or credits (e.g., salary) to accounts, which the bank processes automatically at the end of each month.
- **Account Balances**: Calculates and tracks the total balance for each account within the bank.

## Structure

The project contains the following main classes:

- **Bank**: Manages the collection of accounts, performs operations, and processes monthly Accountable transactions.
- **Client**: Represents a client with personal information.
- **Account**: Abstract base class for different account types.
- **DepositAccount, CreditAccount, WebAccount**: Specialized account types with unique functionalities.
- **Accountable**: Interface for handling monthly transactions, like recurring debits or credits.

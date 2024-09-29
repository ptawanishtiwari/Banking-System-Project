**Java Banking System**

This project is a simple **Java-based Banking System** that manages user accounts and transactions efficiently. It includes features like account creation, credit and debit transactions, balance inquiry, and tracking of the last 20 transactions in **FIFO** order.

#### Key Features:
1. **Account Creation**: Users can create accounts by providing details such as their name, father's name, address, Aadhaar number, and mobile number.
   - Aadhaar number validation ensures it contains exactly 12 digits.
   - Mobile number validation ensures it contains exactly 10 digits.

2. **Secure Transactions**: The system requires a password for any credit or debit transaction to ensure security. A default password of `"0709"` is used, which can be customized.

3. **Transaction Management**:
   - **Credit**: Users can deposit money into their account after password authentication.
   - **Debit**: Users can withdraw money, provided they have sufficient balance, and after successful password authentication.
   - Both credit and debit transactions are logged and stored in a transaction queue, maintaining only the last 20 transactions.

4. **Balance Inquiry**: Users can check their account balance after password verification.

5. **Transaction History**: Users can view the last 20 transactions in **FIFO** order, ensuring that only the most recent transactions are displayed.

6. **Profile Management**: Users can display their profile information (name, father's name, Aadhaar number, mobile number, address).

#### Code Highlights:
- **Queue for Transactions**: A `Queue<String>` is used to store transaction details and ensure that only the last 20 transactions are kept.
- **Validation**: Custom validation for Aadhaar and mobile numbers using regular expressions.
- **Security**: Simple password-based authentication for credit, debit, and balance checks.
- **User Lookup**: Users are stored in an `ArrayList`, and lookup is done based on their mobile number.

---

This project serves as a foundation for understanding how basic banking operations can be handled in Java. It can be extended with more features like multi-user support, database integration, or a graphical interface.

package comp2850.banking

class StudentAccount(holder: String) : BankAccount(holder) {
    

    var overdraft : Int = 0
    set(Overdraftvalue){
        require(Overdraftvalue in 0..100) 
        field = Overdraftvalue
    }
    
    override fun withdraw(amount: Int){
        
        require(amount > 0) {"Withdrawal amount must be greater than 0"}
        val maxwithdraw = balance + overdraft
        
        require(amount <= maxwithdraw){"Insufficient funds for withdrawal"}
        
        
        balance -= amount
    }
    fun withdrawalsAllowed(): Boolean{ 
        return balance + overdraft > 0
    }

    override fun toString(): String {
        return "Account for $holder, balance = $balance (overdraft = $overdraft)"
    }
} 
    
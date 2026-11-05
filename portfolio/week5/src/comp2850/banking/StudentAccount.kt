package comp2850.banking

class StudentAccount(val holder: String, var balance: Int =  0) : BankAccount(holder, balance) {
    
    fun overdraft(SetOverdraft: Int = 0){
        require(SetOverdraft > 100)        
        require(SetOverdraft < 0)
        var Overdraft = SetOverdraft
        }
    fun withdraw(Amount: Int){

        val maxwithdraw = balance + Overdraft
        
        if (Amount > maxwithdraw){
            print("Insufficient funds for withdrawal")
            throw IllegalArgumentException
        }
        
        balance -= Amount



    }   

    
    



    


}
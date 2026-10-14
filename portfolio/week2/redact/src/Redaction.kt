// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string

fun redact(Document:String, RedactionValue:String, Character:Char = 'X'): String{
    
    var words = Document.split(" ")
    var DocumentEdited = ""
    var WordX = ""
    var FirstValue = 0 

    for (word in words){
        if (word == RedactionValue){
            WordX = Character.toString().repeat(word.length)
            if (FirstValue == 0){
                DocumentEdited += WordX
                FirstValue = 1
            } else{
                DocumentEdited += " " + WordX
            }
        } else {
            if (FirstValue == 0){
                DocumentEdited += word
                FirstValue = 1
            } else{
                DocumentEdited += " " + word
            }
        }    
        
    }

   return(DocumentEdited)
}


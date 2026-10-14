// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string


fun redact(Document: String, RedactionValue: String, Character: Char = 'X'): String {
    
    var words = Document.split(" ")
    var DocumentEdited = ""
    var WordX = ""
    var FirstValue = 0 

    for (word in words) {
        if (word.contains(RedactionValue)) {
            WordX = Character.toString().repeat(RedactionValue.length)
    
            val index = word.indexOf(RedactionValue)
            val before = word.substring(0, index)
            val after = word.substring(index + RedactionValue.length)
            val FinalWord = before + WordX + after

            if (FirstValue == 0) {
                DocumentEdited += FinalWord
                FirstValue = 1
            } else {
                DocumentEdited += " " + FinalWord
            }
        } else {
            if (FirstValue == 0) {
                DocumentEdited += word
                FirstValue = 1
            } else {
                DocumentEdited += " " + word
            }
        }    
    }

    return DocumentEdited
}
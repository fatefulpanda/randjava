//this class is a Morse Code translator
public class MorseCipher {
  private Alphabet alphabet;   //create alphabet
  public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
  public static final String[] codes = {
  ".-",    /* A */    "-...",  /* B */    "-.-.",  /* C */    "-..",   /* D */
  ".",     /* E */    "..-.",  /* F */    "--.",   /* G */    "....",  /* H */
  "..",    /* I */    ".---",  /* J */    "-.-",   /* K */    ".-..",  /* L */
  "--",    /* M */    "-.",    /* N */    "---",   /* O */    ".--.",  /* P */
  "--.-",  /* Q */    ".-.",   /* R */    "...",   /* S */    "-",     /* T */
  "..-",   /* U */    "...-",  /* V */    ".--",   /* W */    "-..-",  /* X */
  "-.--",  /* Y */    "--..",  /* Z */    ".----", /* 1 */    "..---", /* 2 */
  "...--", /* 3 */    "....-", /* 4 */    ".....", /* 5 */    "-....", /* 6 */
  "--...", /* 7 */    "---..", /* 8 */    "----.", /* 9 */    "-----", /* 0 */
};
  
  public MorseCipher() {
    this.alphabet = new Alphabet(letters);   //create new Alphabet that uses the letters above
  }
  public String encrypt(String plainText) {
    plainText = plainText.toUpperCase();    //converts the string plainText to all uppercase letters
    String[] q = plainText.split("");       //splits the plainText string to include spaces/make it an array 
    String s = "";                         //empty string placeholder
    for (int i=0; i<q.length-1; i++) {
      if (q[i].equals(" ")) {              //if the character is a space, add 4 spaces to the empty string
          s += "    ";  //4 spaces
        }
        else {
          int r = alphabet.indexOf(q[i].charAt(0)); //get the index of the character in the string
          s+=codes[r] + "   ";   //3 spaces   //add the morse translation to the empty string along with 3 spaces
        }
    }
    char w = q[q.length-1].charAt(0);     //translate the last character so there's no space
    int r =alphabet.indexOf(w);           //index of last character
    s+=codes[r];                          //add it to the string
    return s;                             //return the encrypted string
  }
  
  public String decrypt(String cryptText) {
    String[] q=cryptText.split("       ");     //7 spaces  //split the morse code to not have the 7 spaces
    String dc = "";                            //empty string to store decryption
    for (int i = 0; i<q.length;i++) {
      String[] w = q[i].split("   ");         //split the already split string where there's 3 spaces to get each morse "letter"
      for (int j=0; j<w.length;j++) {         //double for loop to find the matching letter to the code
        for (int k=0; k<codes.length;k++) {
          if (w[j].equals(codes[k])) {        //if the code matches the letter add it to the empty string
            dc+=alphabet.get(k);
          }
        }
      }
      dc += " "; //add spaces after each word
    }
    dc = dc.trim();  //remove the last space and then return the decrypted string
    return dc;
  }
  
  
}
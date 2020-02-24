# vigenere
Project: Vigenère Cipher
Description:  
- program that encrypts the alphabetic letters in a file using the Vigenère cipher. 
- program will take two command line parameters containing the names of the file storing the encryption keyand the file to be encrypted.

- first parameter is encryption key
  - repeat encrpytion key as needed(in this case 512 characters)
  - strip all non-alphabetic characters
  - convert to lowercase
  
- second parameter is text file
  - text file must have 512 characters or less. If less than 512, then pad with letter 'x'.
  - strip all non-alphabetic characters
  - convert to lowercase
- output is the ecryption key(unedited), text file(unedited), and the cipher text
  - output only has 80 letters per line except last line which may have less.


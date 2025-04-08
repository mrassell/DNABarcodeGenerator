# 🧬 DNABarcodeGenerator

**Class Project – CSCI 101**  
Instructor: Dr. Nassar

---

## 📄 Assignment Overview

This project generates valid DNA barcodes based on biological constraints. Each generated barcode is:

- Free of specific restriction enzyme sites (AgeI, AscI, BamHI, SbfI)
- Between 40–60% GC content
- Free of three or more consecutive repeating nucleotides (e.g., AAA, CCC)

Barcodes are generated based on user input:
- **N**: number of sequences to generate  
- **L**: length of each barcode  

The software prints the results to the console, with validation applied to each barcode.

📌 Refer to the full assignment description here:  
[📎 DNABarcodeGenerator Project Assignment (PDF)](./Quiz2%20(2).pdf)

---

## 🧪 Sample Output
<pre>
How many sequences of DNA barcodes you would like to generate?
3
What is the length of the DNA barcode?
8

barcode1: GTGTACGT  
barcode2: CTGACAAC  
barcode3: CTGATGAG  
</pre>


## 🛠️ Project Structure

The program is implemented in Java using the following methods:

- `generateBarcode()`  
  Returns a random DNA sequence of length `L`.

- `isRestrictedList(String barcode)`  
  Checks if the barcode contains restriction sites.

- `validateGCCount(String barcode)`  
  Validates if GC-content is between 40% and 60%.

- `isRedundantBarcode(String barcode)`  
  Ensures there are no three identical nucleotides in a row.

---

## 📎 Submission Notes

- Input is read using class variables.  
- User input validation is not required for this assignment (L ≥ 4, N ≥ 3).  
---

## 🧑‍💻 Author

Maheen Rassell  
[GitHub Profile](https://github.com/mrassell)

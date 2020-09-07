/*
 * Ass.1 In C implement a recursive and an iterative version of a function 
 * which reads characters from stdin until a newline character is read and 
 * then prints them on stdout in reverse order. Hint: use getchar(), putchar() (or getc(), putc()). 
 * For the iterative version you may assume a fixed max length of the input.
 */

/* 
 * Author: Frida Johansson
 *
 * Created on 26 augusti 2020
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 10
/* Method: PrintIterative
 * Reads characters from stdin and prints out in reverse order iteratively.
 */
void printIterative(char input){
    char chars[MAX];
    int pos = 0;
    input = getchar();
    
    while(input != '\n'){
        chars[pos] = input;
        input = getchar();
        pos++;
    }
    for(int i = MAX; i >=0; i--){
        putchar(chars[i]);
        }
    }

    
/* Method: printRecursive
 * Reads characters from stdin and prints out in reverse order recursively
 */
void printRecursive(char input){
    input = getchar();
    if(input =='\n')
        return;
    printRecursive(input);
    putchar(input);
   
    }


/* Main method
 * 
 */
int main(int argc, char** argv) {
   
    
    printf("\nEnter char and it will be printed in reverse order: ");
    char input;
    printRecursive(input);
    
    printf("\nEnter char and it will be printed in reverse order: ");
    char input2;
    printIterative(input2);
}

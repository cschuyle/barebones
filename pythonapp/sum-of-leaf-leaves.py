#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'sumLeftLeaves' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY root as parameter.
#

def sumLeftLeaves(bfsList):
    # Write your code here
    #[3,   9,20,   null,null,15,7,   x, x, x, x, XXXX, XXXX, x, x]
    #      z       z    z    j                   j     j
    #.     1.      3.   4    5.                  11.   12
    row = 1
    sum = 0
    while True:
        start = 2 ** row - 1
        end = start + 2 ** row
        for i in range(start, end, 2):
            if end >= len(bfsList):
                sum += bfsList[i]
                break
            leaf1i = i + 2 ** row + 2 * (i - start)
            leaf2i = leaf1i + 1
            if XYZZY!!! leaf1i is None and leaf2i is None:
                sum += bfsList[i]
            
            row += 1
        
    
    return sum
          
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    root_count = int(input().strip())

    root = []

    for _ in range(root_count):
        item = input().strip()
        root_item = int(item) if item != "null" else None
        root.append(root_item)

    result = sumLeftLeaves(root)

    fptr.write(str(result) + '\n')

    fptr.close()

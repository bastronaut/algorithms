'''
Binary search operates on a sorted array of size n. It searches for elements
by splitting at the n/2th element, and checks whether the element to find
is larger or smaller than the checked element. It then splits the bottom
(when element is smaller) or top (when element is bigger) in half again,
thereby eliminating the other half. It repeats this process until it finds the
element. runs in O(log n)
'''

import random

alphabet = "abcdefghijklmnopqrstuvwxyz"
words = []

# seed a list of random numbers
for num in range(0, 1000):
    word = ''
    sample = random.sample([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25], 12)
    for nr in sample:
        word += alphabet[nr]
    words.append(word)

findword = "a"
words.append(findword)

sortedwords = sorted(words)


def binarysearch(array, findword):
    high = len(sortedwords) - 1
    low = 0
    currentlocation = ((high-low)/2) + low
    numberofsearches = 0
    found = False
    while not found:
        numberofsearches += 1
        print 'testing at location:', currentlocation
        if sortedwords[currentlocation] == findword:
            print 'found the word: ', findword, ' at location: ', currentlocation, ' in ', numberofsearches, ' searches.'
            break
        elif sortedwords[currentlocation] < findword:
            low = currentlocation
            currentlocation = ((high-low)/2) + low
        elif sortedwords[currentlocation] > findword:
            high = currentlocation
            currentlocation = ((high-low)/2) + low

# passes an array that is constantly split until it finds it
def recursivesplitbinarysearch(array, findword):
    location = len(array)/2
    print 'array is now size:', len(array),' testing at location: ', location, array[location]
    if findword == array[location]:
        print 'found the word ', findword
        return
    elif findword > array[location]:
        recursivesplitbinarysearch(array[location:], findword)
    elif findword < array[location]:
        recursivesplitbinarysearch(array[:location], findword)

recursivesplitbinarysearch(sortedwords, findword)

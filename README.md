# COMP401
Java programming assignments
Jedi: HandEvaluator
Read and understand the Deck interface and its implementation DeckImpl. Using these, write a program called HandEvaluator that determines the winning percentage of a particular hand when pitted against a certain number of players.

The input to HandEvaluator will be a series of test cases in the form:

NumberOpponents Rank1 Suit1 Rank2 Suit2 Rank3 Suit3 Rank4 Suit4 Rank5 Suit5
NumberOpponents will be between 1 and 9 (inclusive). The rank and suit pairs that follow will indicate the cards in the hand to be evaluated. Ranks will be integers in the range 2 to 14 indicating the rank of the card. Suits will be indicated by the strings "S", "H", "D", and "C" corresponding to spades, hearts, diamonds, and clubs.

The program should read in the test case and then run an experiment 10000 times to determine how often this hand wins against the specified number of opponents. To run each experiment, create a new shuffled deck of cards, remove the cards in the specified hand from the deck, deal a poker hand for each opponent and compare the specified hand to it. If the specified hand beats all of the opponent hands, then tally the experiment as a win, otherwise, consider the experiment a loss. Calculate the win percentage to the nearest percentage and print to the output as a single number.

A value of 0 for NumberOpponents will indicate the end of input.

For example, given the following input:

9 5 S 5 H 10 D 14 C 3 H
9 5 S 6 S 7 S 8 S 9 S 
1 5 S 5 H 10 D 14 C 3 H
1 14 H 14 D 2 C 8 H 10 H
9 14 H 14 D 2 C 8 H 10 H
0
You should get something close to the following output:

1
100
60
91
45
0
Because the experiment has a small degree of randomness, your output may differ from the above, but it really shouldn't differ by more than 1 if at all.

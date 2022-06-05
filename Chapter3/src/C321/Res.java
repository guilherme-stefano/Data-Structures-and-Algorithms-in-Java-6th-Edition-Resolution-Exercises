package C321;

public class Res {


//The possible values for the array elements are 0 .. 9, each with probability 1/10. If one of the elements is 0, the product will be 0 as well. So we calculate the probability that at least one element is 0.

//It turns out, this is the opposite of all elements being greater than zero. The probability for an element to be greater than 0 is 9/10, and the probability that all elements are greater than zero is therefore (9/10)^100.

//The probability that at least one element is 0 is therefore 1 - (9/10)^100 which is approximately 0.9999734.

}

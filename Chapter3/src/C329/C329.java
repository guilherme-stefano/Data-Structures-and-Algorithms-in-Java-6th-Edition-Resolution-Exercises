// save tail from list1 in a variable and call it tail1
// while current tail from list1 is different from tail1 or tail from list2 rotate list1;
// if tail1 == current tail end execution and the lists are different 
// if tail1 == tail from list2 , stop while loop and begin next step
// in next step the go through the two lists simultaneously comparing tail elements
// if all the comparissons are true we return true because the lists contains the a same sequence of elements;
// if one comparisson is false we back to the previous while step comparing if tail from list1 is different from tail1 or tail from list2 and rotating
// repeat the logic until compare all the elements or rotate completly the list1
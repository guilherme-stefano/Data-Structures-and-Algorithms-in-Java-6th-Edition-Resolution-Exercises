package C227;

import java.math.BigInteger;

public class FibonacciProgression extends Progression {

protected BigInteger prev;

/** Constructs traditional Fibonacci, starting 0, 1, 1, 2, 3, ... */
 public FibonacciProgression() { 
	 this(new BigInteger("0"), new BigInteger("1")); 
 }

/** Constructs generalized Fibonacci, with give first and second values. */
 public FibonacciProgression(BigInteger first, BigInteger second) {
	 super(first);
	 prev = second.subtract(first); // fictitious value preceding the first
 }

 /** Replaces (prev,current) with (current, current+prev). */
 protected void advance() {
	 current = ((BigInteger)current).add(prev);
	 prev = ((BigInteger)current).subtract(prev);
 }
 }
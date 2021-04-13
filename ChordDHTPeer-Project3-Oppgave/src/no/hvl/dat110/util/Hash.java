package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private static BigInteger hashint;

	public static BigInteger hashOf(String entity) throws NoSuchAlgorithmException {

		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		MessageDigest md = MessageDigest.getInstance("MD5");

		// we use MD5 with 128 bits digest

		// compute the hash of the input 'entity'

		byte[] digest = md.digest(entity.getBytes());
		// convert the hash into hex format

		// convert the hex into BigInteger
		String hex = toHex(digest);
		// return the BigInteger

		hashint = new BigInteger(hex, 16);

		return hashint;

	}

	public static BigInteger addressSize() throws NoSuchAlgorithmException {

		// Task: compute the address size of MD5

		// get the digest length
		// compute the number of bits = digest length * 8(*8 siden digest length
		// returner i bytes-vilde)
		int nrBits = bitSize();
		// compute the address size = 2 ^ number of bits
		int Str = (int) Math.pow(2, nrBits);
		// return the address size
		BigInteger addressSize = BigInteger.valueOf(Str);
		return addressSize;
	}

	public static int bitSize() throws NoSuchAlgorithmException {

		int digestlen = 0;

		digestlen = MessageDigest.getInstance("MD5").getDigestLength();

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
